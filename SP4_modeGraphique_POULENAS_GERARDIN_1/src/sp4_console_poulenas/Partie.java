/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_poulenas;

import java.util.Scanner;

/**
 *
 * @author Poulenas
 */
public class Partie {
    Joueur[]ListeJoueurs= new Joueur[2];
    Joueur joueurCourant;
    Grille grilleJeu;
    public Partie ( Joueur joueur1, Joueur joueur2 ){
        ListeJoueurs[0]=joueur1;
        ListeJoueurs[1]=joueur2;
    }
    public void attribuerCouleursAuxJoueurs (){
        ListeJoueurs[0].couleur="rouge";
        ListeJoueurs[1].couleur="jaune";
    }
    public void initialiserPartie(){
       attribuerCouleursAuxJoueurs ();
       grilleJeu = new Grille();
       for (int i=0; i<21; i++){
           ListeJoueurs[0].ajouterJetons(new Jeton ("rouge"));
           ListeJoueurs[1].ajouterJetons(new Jeton ("jaune"));
       }
    }
    public void debuterPartie(){
        grilleJeu.afficherGrilleSurConsole();
        joueurCourant=ListeJoueurs[0];
        boolean a,b; 
        while ((a=grilleJeu.etreRempli())!=true && (b=grilleJeu.etreGagnantePourJoueur(joueurCourant))!=true){
            System.out.println(a+ " et " +b);
            
            grilleJeu.afficherGrilleSurConsole();
            Scanner sc; 
            sc = new Scanner(System.in);
            System.out.println("Choisissez une colonne");
            int choix = sc.nextInt();
            while ( choix != 1 && choix !=2 && choix!= 3 && choix != 4 && choix !=5 && choix != 6){
                System.out.println("Choisissez une colonne");
                choix = sc.nextInt();
            }
            while (grilleJeu.colonneRemplie(choix)!=false){
                System.out.println("Choisissez une colonne (colonne remplie)");
                choix = sc.nextInt();
                while ( choix != 1 || choix !=2 || choix!= 3 || choix != 4 || choix !=5 || choix != 6){
                    choix = sc.nextInt();
            }
            }
            Jeton J = joueurCourant.listeJetons[joueurCourant.nombresJetonsRestants-1];
            joueurCourant.nombresJetonsRestants--;
            grilleJeu.ajouterJetonDansColonne(J, choix);
            grilleJeu.afficherGrilleSurConsole();
            if (joueurCourant==ListeJoueurs[0]){
                joueurCourant=ListeJoueurs[1];                
            }else{
                joueurCourant=ListeJoueurs[0];
            }      
        }
        
    }
    
}
