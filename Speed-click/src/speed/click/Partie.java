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
        
        // Niveau 1 
        System.out.println ("NIVEAU 1");
        System.out.println ("NIVEAU 1");
        System.out.println ("NIVEAU 1");
        BoutonsJeu.AllumerBoutonAleat(); // Allume un premier bouton aléatoirement sur la grille
        int temp = rand.nextInt(2); // Nombre aléatoire pour choirsir si il y a un bouton piège ou non 
        if (temp==0){
            BoutonsJeu.AllumerBoutonPiege(); // Si 0 tirer aléatoirement, affiche un bouton piège 
        }
        BoutonsJeu.afficherBoutonSurGrille(); // Affiche grille
        Scanner sc; 
        sc = new Scanner(System.in);
        while (nbSecondes<60){ // Le temps imparti est de 20 secondes 
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
                // JoueurSeul.Score=JoueurSeul.Score-1; fonctionalité reporté niveau 2
                System.out.println("Choisir une ligne où cliquer");
                ligne = sc.nextInt();
                System.out.println("Choisir une colonne où cliquer");
                colonne = sc.nextInt(); // Redmande des coordonées 
            }
            JoueurSeul.Score=JoueurSeul.Score+1; // Clique correct, score +1
            System.out.println ("Bravo !");
            BoutonsJeu.EtteindreBoutonPiege();
            if (nbSecondes>=0 && nbSecondes<15){ // Entre 0 et 5 seconde allume 2 boutons pièges
                for (int i=0; i<2; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                }
            }
            if (nbSecondes>=15 && nbSecondes<30){ // Entre 5 et 10 secondes allume 3 boutons pièges
                for (int i=0; i<3; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                }
            }
            if (nbSecondes>=30 && nbSecondes<45){ // Entre 10 et 15 seondes allume 4 boutons pièges 
                for (int i=0; i<4; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                }
            }
            if (nbSecondes>=45 && nbSecondes<60){ // Entre 15 et 20 secondes allume 5 boutons pièges 
                for (int i=0; i<5; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                }
            }
            BoutonsJeu.ChangerBoutonAllume(ligne, colonne); // Change bouton allumé 
            System.out.println(nbSecondes);
            BoutonsJeu.afficherBoutonSurGrille(); // Réaffiche la grille
    }
        BoutonsJeu.EtteindreGrille();
        BoutonsJeu.afficherBoutonSurGrille(); // Réaffiche la grille
        System.out.println("Votre score est : "+JoueurSeul.Score); // Affiche score à la fin de la partie 
        monChrono.stop();
        
        
        // Niveau 2 
        System.out.println ("NIVEAU 2");
        System.out.println ("NIVEAU 2");
        System.out.println ("NIVEAU 2");
        System.out.println ("NIVEAU 2");
        BoutonsJeu.AllumerBoutonAleat(); // Allume un premier bouton aléatoirement sur la grille
        BoutonsJeu.AllumerBoutonPiege(); // Premier bouton piège 
        BoutonsJeu.AllumerBoutonPiege(); // Second bouton piège 
        BoutonsJeu.afficherBoutonSurGrille(); // Affiche grille
        nbSecondes = 0;// Remttre le nombre de secondes à 0
        while (nbSecondes<30){ // Chronomètre plus court que le précedent 
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
                JoueurSeul.Score=JoueurSeul.Score-1; // Décrémente le score 
                System.out.println("Choisir une ligne où cliquer");
                ligne = sc.nextInt();
                System.out.println("Choisir une colonne où cliquer");
                colonne = sc.nextInt(); // Redmande des coordonées 
            }
            JoueurSeul.Score=JoueurSeul.Score+1; // Clique correct, score +1
            System.out.println ("Bravo !");
            BoutonsJeu.EtteindreBoutonPiege(); // Etteint tous les boutons rouges 
            if (JoueurSeul.Score>0){ // Si score positif on allume 3 boutons pièges
               for (int i=0; i<3; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                } 
            }
            if (JoueurSeul.Score==1){ //Si score égal à 41 on allume 4 boutons pièges
               for (int i=0; i<4; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                } 
            }
            if (JoueurSeul.Score==2){ //Si score égal à 2 on allume 5 boutons pièges
               for (int i=0; i<5; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                }
            }
            if (JoueurSeul.Score==3){ // Si score égal à 3 on allume 6 boutons pièges
               for (int i=0; i<6; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                }
             }
            if (JoueurSeul.Score==4){ //Si score égal à 4 on allume 7 boutons pièges 
               for (int i=0; i<7; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                } 
              }
            if (JoueurSeul.Score>5){ // Si score supérieur à 5 on allume 8 boutons pièges 
               for (int i=0; i<8; i++){
                    BoutonsJeu.AllumerBoutonPiege();
                } 
            }
            BoutonsJeu.ChangerBoutonAllume(ligne, colonne); // Change bouton allumé 
            System.out.println(nbSecondes);
            BoutonsJeu.afficherBoutonSurGrille(); // Réaffiche la grille
            }
            
        BoutonsJeu.EtteindreGrille();
        BoutonsJeu.afficherBoutonSurGrille(); // Réaffiche la grille
        System.out.println("Votre score est : "+JoueurSeul.Score); // Affiche score à la fin de la partie 
        monChrono.stop();    // Arrête le chronomètre
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
           

