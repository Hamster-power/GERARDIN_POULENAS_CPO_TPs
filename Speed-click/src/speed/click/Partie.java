/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.click;

import java.util.Scanner;

/**
 *
 * @author camille
 */
public class Partie {
    Joueur[]ListeJoueurs= new Joueur[1];
    Joueur JoueurSeul;
    Grille BoutonsJeu;
    // Chrono
    
    public Partie (Joueur JoueurSeul) {
    ListeJoueurs[0]=JoueurSeul; // Premier joueur
    }
    
    public void InitialiserPartie(){
        BoutonsJeu = new Grille();
        
    }
    
    public void DebuterPartie(){
        JoueurSeul =  ListeJoueurs[0]; 
        BoutonsJeu.AllumerBoutonAleat();
        Scanner sc; 
        sc = new Scanner(System.in);
        System.out.println("Choisir une ligne où cliquer");
        int ligne = sc.nextInt();
        System.out.println("Choisir une colonne où cliquer");
        int colonne = sc.nextInt();
        while (BoutonsJeu.CliqueCorrect(ligne, colonne)!=true){
            System.out.println("Choisir une ligne où cliquer");
            ligne = sc.nextInt();
            System.out.println("Choisir une colonne où cliquer");
            colonne = sc.nextInt();
        }
    }
    
    public double DemarrerChrono(){
        return 3.1;   
    }
           
}
