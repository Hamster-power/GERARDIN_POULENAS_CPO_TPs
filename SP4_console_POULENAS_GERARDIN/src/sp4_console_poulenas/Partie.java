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
        int l = (int)(Math.random()*6);
        int c = (int)(Math.random()*7);
        grilleJeu.cellulesJeu[l][c].placerTrouNoir();
        for (int k=1; k<4; k++){
            l = (int)(Math.random()*6);
            c = (int)(Math.random()*7);
            while (grilleJeu.cellulesJeu[l][c].presenceTrouNoir()==true){
                l = (int)(Math.random()*6);
                c = (int)(Math.random()*7); 
        }    
        grilleJeu.cellulesJeu[l][c].placerTrouNoir(); 
        }
        int m =(int)(Math.random()*6); // Placement des trou des 3 désintégrateur pas sur des trous noirs
        int n = (int)(Math.random()*7);
        for (int i=0; i<3; i++){
        while (grilleJeu.cellulesJeu[m][n].presenceTrouNoir()==true && grilleJeu.cellulesJeu[m][n].presenceDesintegrateur()==true){ // Vérifie qu'il n'y ai pas de trou noir ni de désintégrateur 
            m =(int)(Math.random()*6);
            n = (int)(Math.random()*7);
        }
        grilleJeu.cellulesJeu[m][n].placerDesintegrateur(); // Place les 3 désintégrteur
        }
        int x =(int)(Math.random()*6); // Tire ligne et colonne au hasard
        int y =(int)(Math.random()*7);
        for (int i=0; i<2; i++){
        while (grilleJeu.cellulesJeu[x][y].presenceTrouNoir()==false){ // Vérifie qu'il y'ai bine un trou noir
            x =(int)(Math.random()*6);
            y = (int)(Math.random()*7);  
        }
        grilleJeu.cellulesJeu[x][y].placerDesintegrateur(); // Place les 2 désintégratuer sur les 2 trous noirs
       }
    }
    public void debuterPartie(){
        grilleJeu.afficherGrilleSurConsole();
        joueurCourant=ListeJoueurs[0];
        while (grilleJeu.etreRempli()!=true && grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])!=true && grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])!=true){
            grilleJeu.afficherGrilleSurConsole();
            System.out.println("Choisir 1 pour placer un jeton \nChoisir 2 pour récuperer un jeton \nChoisir 3 pour placer un désintégrateur");
            Scanner sc; 
            sc = new Scanner(System.in);
            int choix = sc.nextInt();
            
            if (choix==2){
                
            }
            System.out.println("Choisissez une colonne");
 
            while ( choix!=0 && choix != 1 && choix !=2 && choix!= 3 && choix != 4 && choix !=5 && choix != 6 ){
                System.out.println("Choisissez une colonne");
                choix = sc.nextInt();
            }
            
            while (grilleJeu.colonneRemplie(choix)!=false){
                System.out.println("Choisissez une colonne (colonne remplie)");
                choix = sc.nextInt();
                while ( choix !=0 && choix != 1 && choix !=2 && choix!= 3 && choix != 4 && choix !=5 && choix != 6 ){
                    choix = sc.nextInt();
            }
            }
            
        
           
            Jeton J = joueurCourant.listeJetons[joueurCourant.nombresJetonsRestants-1];
            joueurCourant.nombresJetonsRestants--; // Décrémente le nombre de jeton
            // Pour reucpeer un jeton on rentre des coordonées 
            // While etre recupérer jeton de sa couleur, 
            // Tant que couleur du jeton a recupérer n'est as ok, on redemande des coordonées valables 
            // Fonction recuperer jeton à utiliser grillleJeu.recuperejeton de la ligne et colonee
            // Réincrémente listejeton jours avec ajouter jeton 
            // Tasser grille
            // Affiche grille
            // 3 grand if pour le choix 
            // Vérifier qur le joueur à en posssesion un désintégrateur
            // Demander les coordonée de là où il veut jouer désintégrateur, il faut absoliument qu'il y ai un jeton adverse dans la cellule 
            // Vérifier qur le joueur à en posssesion un désintégrateur, couleur jeton différent couleur joueur courant
            // Placer désintégrateur ( ligne colonne en arguments
            // Joueur courant.utiliser désintégrateur
            // Supprimer le jeton que l'on a selection 
            // Retasse la grille 
            // Verifier que si il place un jeton il y'ai un désintégratuer
            
            
            
            
            
            grilleJeu.ajouterJetonDansColonne(J, choix);
            grilleJeu.afficherGrilleSurConsole(); // Affiche la grille 
            if (joueurCourant==ListeJoueurs[0]){ // chage de joueur 
                joueurCourant=ListeJoueurs[1];                
            }else{
                joueurCourant=ListeJoueurs[0];
            }      
        }
        
    }
    
}
