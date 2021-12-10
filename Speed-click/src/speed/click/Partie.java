/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.click;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author camille
 */
public class Partie {
    Joueur[]ListeJoueurs= new Joueur[1];
    Joueur JoueurSeul;
    Grille BoutonsJeu;
    Random rand =new Random();
    // Chrono
    
    public Partie (Joueur JoueurSeul) {
    ListeJoueurs[0]=JoueurSeul; // Premier joueur
    }
    
    public void InitialiserPartie(){
        BoutonsJeu = new Grille();
        
    }
    
    public void DebuterPartie(){
        JoueurSeul =  ListeJoueurs[0]; 
        BoutonsJeu.AllumerBoutonAleat(); // ALlume un premier bouton aléatoirement
        int temp = rand.nextInt(2);
        if (temp==0){
            BoutonsJeu.AllumerBoutonPiege();
        }
        BoutonsJeu.afficherBoutonSurGrille(); // Affiche grille
        Scanner sc; 
        sc = new Scanner(System.in);
        for (int i=0; i<3; i++){
            System.out.println("Choisir une ligne où cliquer");
            int ligne = sc.nextInt();
            System.out.println("Choisir une colonne où cliquer");
            int colonne = sc.nextInt();
            if (BoutonsJeu.CliqueRouge(ligne, colonne)==true){
                System.out.println("Vous avez perdu");
                break;
            }
            while (BoutonsJeu.CliqueCorrect(ligne, colonne)!=true){
                JoueurSeul.Score=JoueurSeul.Score-1;
                System.out.println("Choisir une ligne où cliquer");
                ligne = sc.nextInt();
                System.out.println("Choisir une colonne où cliquer");
                colonne = sc.nextInt();
            }
            JoueurSeul.Score=JoueurSeul.Score+1;
            System.out.println ("Bravo !");
            BoutonsJeu.ChangerBoutonAllume(ligne, colonne);
            BoutonsJeu.afficherBoutonSurGrille();
    }
        System.out.println("Votre score est : "+JoueurSeul.Score);
    }
    
    public double DemarrerChrono(){
        return 3.1;   
    }
           
}
