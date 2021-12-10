/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.click;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Timer;

/**
 *
 * @author camille
 */
public class Partie {
    Joueur[]ListeJoueurs= new Joueur[1];
    Joueur JoueurSeul;
    Grille BoutonsJeu;
    Random rand =new Random();
    int nbSecondes = 0; // Secondes chronomètre 
    Timer monChrono; // Initialise chronomètre 

    public Partie (Joueur JoueurSeul) {
    ListeJoueurs[0]=JoueurSeul; // Premier joueur
    }
    
    public void InitialiserPartie(){
        BoutonsJeu = new Grille(); // Creer grille
        
    }
    
    public void DebuterPartie(){
        JoueurSeul =  ListeJoueurs[0]; 
        BoutonsJeu.AllumerBoutonAleat(); // ALlume un premier bouton aléatoirement
        int temp = rand.nextInt(2); // Nombre aléatoire pour choirsir si il y a un bouton piège ou non 
        if (temp==0){
            BoutonsJeu.AllumerBoutonPiege(); // Si 0 tirer aléatoirement, affiche un bouton piège 
        }
        BoutonsJeu.afficherBoutonSurGrille(); // Affiche grille
        Scanner sc; 
        sc = new Scanner(System.in);
        while (nbSecondes<10){ // Le temps imparti est de 20 secondes 
            System.out.println("Choisir une ligne où cliquer"); 
            int ligne = sc.nextInt();
            System.out.println("Choisir une colonne où cliquer");
            int colonne = sc.nextInt();
            DemarrerChrono(); // Démarre chronomètre après premières coordonnées rentrées 
            if (BoutonsJeu.CliqueRouge(ligne, colonne)==true){ //Si le clique est sur un bouton rouge 
                System.out.println("Vous avez perdu"); // Partie perdu 
                break; // Sort de la boucle de jeu
            }
            while (BoutonsJeu.CliqueCorrect(ligne, colonne)!=true){ // Tant que le bouton cliqué n'est pas vert ni rouge 
                JoueurSeul.Score=JoueurSeul.Score-1; // Score baisse
                System.out.println("Choisir une ligne où cliquer");
                ligne = sc.nextInt();
                System.out.println("Choisir une colonne où cliquer");
                colonne = sc.nextInt(); // Redmande des coordonées 
            }
            JoueurSeul.Score=JoueurSeul.Score+1; // Clique correct, score +1
            System.out.println ("Bravo !");
            temp = rand.nextInt(2); // Nombre aléatoire pour choirsir si il y a un bouton piège ou non 
            if (temp==0){
                BoutonsJeu.AllumerBoutonPiege(); // Si 0 tirer aléatoirement, affiche un bouton piège 
            }
            BoutonsJeu.ChangerBoutonAllume(ligne, colonne); // Change bouton allumé 
            BoutonsJeu.afficherBoutonSurGrille(); // Réaffiche la grille
    }
        BoutonsJeu.EtteindreGrille();
        System.out.println("Votre score est : "+JoueurSeul.Score); // Affiche score à la fin de la partie 
        monChrono.stop();
    } 
    
    public double DemarrerChrono(){ 
        
        ActionListener tache_recurrente = new ActionListener() { // Définit un tâche récurrente
        @Override
        public void actionPerformed(ActionEvent e1) {
            nbSecondes++; // Incrémente les secondes
            }
        ;         
        };
	monChrono = new Timer(1000, tache_recurrente);
        monChrono.start(); // Démarre le chronomètre
        return 0; // Valeur de retour 
    }
    
    
    }
           

