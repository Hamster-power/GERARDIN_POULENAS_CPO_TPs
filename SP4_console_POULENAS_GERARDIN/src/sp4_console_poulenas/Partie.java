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
        int coul1 = (int)(Math.random()*2);
        if (coul1==1){
            ListeJoueurs[0].couleur="rouge";
            ListeJoueurs[1].couleur="jaune";
        }else if (coul1==2){
            ListeJoueurs[1].couleur="rouge";
            ListeJoueurs[0].couleur="jaune";
    }
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
        while (grilleJeu.cellulesJeu[x][y].presenceTrouNoir()==false){ // Vérifie qu'il y'ai bien un trou noir
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
                //récupérer jeton
                System.out.println("Choisir l'emplacement du jeton à recuperer");
                System.out.println("Choisir la ligne");
                int ligne = sc.nextInt();
                System.out.println("Choisir la colonne");
                int colonne = sc.nextInt();
                while (grilleJeu.cellulesJeu[ligne][colonne].lireCouleurDuJeton()!=joueurCourant.couleur){
                    System.out.println("Choisir l'emplacement du jeton à recuperer");
                    System.out.println("Choisir la ligne");
                    ligne = sc.nextInt();
                    System.out.println("Choisir la colonne");
                    colonne = sc.nextInt();
                }
                grilleJeu.cellulesJeu[ligne][colonne].recupererJeton();
                grilleJeu.tasserGrille(colonne);
                grilleJeu.afficherGrilleSurConsole(); // Affiche la grille 

                
            }
            if (choix ==3){
                if (joueurCourant.nombreDesintegrateur==0){
                    System.out.println("Pas de désintégrateur en votre possession");
                    while(choix !=1 && choix!=2){
                         System.out.println("Choisissez entre 1 et 2");
                         choix = sc.nextInt();
                    }
                }
                if (choix == 3){
            System.out.println("Chosir les coordonées de placement du désintégrateur");
            int ligne = sc.nextInt();
            int colonne = sc.nextInt();
            if (grilleJeu.cellulesJeu[ligne][colonne].lireCouleurDuJeton()== joueurCourant.couleur){
                System.out.println("Chosir les coordonées de placment du désintégrateur");
                ligne = sc.nextInt();
                colonne = sc.nextInt();
            }
            joueurCourant.utiliserDesintegrateur();
            grilleJeu.tasserGrille(colonne);
                }
            
            }
            
            
            
            
            
            
            
            if (choix ==1){
            System.out.println("Choisissez une colonne");
            int choixcol = sc.nextInt();
            while ( choixcol!=0 && choix != 1 && choixcol !=2 && choixcol!= 3 && choixcol!= 4 && choixcol !=5 && choixcol != 6 ){
                System.out.println("Choisissez une colonne");
                choixcol = sc.nextInt();
            } 
            while (grilleJeu.colonneRemplie(choixcol)!=false){
                System.out.println("Choisissez une colonne non remplie");
                choix = sc.nextInt();
                while ( choixcol !=0 && choixcol != 1 && choixcol !=2 && choixcol!= 3 && choixcol != 4 && choixcol !=5 && choixcol != 6 ){
                    choixcol = sc.nextInt();
            }
            }
            
        
           
            Jeton J = joueurCourant.listeJetons[joueurCourant.nombresJetonsRestants-1];
            joueurCourant.nombresJetonsRestants--;
            grilleJeu.ajouterJetonDansColonne(J, choixcol);
            grilleJeu.afficherGrilleSurConsole();
                
            }
   
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
            
            if (joueurCourant==ListeJoueurs[0]){ // chage de joueur 
                joueurCourant=ListeJoueurs[1];                
            }else{
                joueurCourant=ListeJoueurs[0];
            }
        }
    }
}

