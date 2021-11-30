/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_poulenas;

import java.util.Random; // Import du random
import java.util.Scanner; 

/**
 *
 * @author Poulenas
 */
public class Partie {
    Joueur[]ListeJoueurs= new Joueur[2]; // Création tableu de 2 joueurs
    Joueur joueurCourant; 
    Grille grilleJeu; // Création grille 
    Random rand =new Random(); 
    
    public Partie ( Joueur joueur1, Joueur joueur2 ){
        ListeJoueurs[0]=joueur1; // Premier joueur
        ListeJoueurs[1]=joueur2; // Deuxième joueur
    }
    public void attribuerCouleursAuxJoueurs (){
        int coul1 = rand.nextInt(2); // Nombre aléatoire
        if (coul1==0){
            ListeJoueurs[0].affecterCouleur("rouge");
            ListeJoueurs[1].affecterCouleur("jaune");
        }else if (coul1==1){
            ListeJoueurs[1].affecterCouleur("rouge");
            ListeJoueurs[0].affecterCouleur("jaune");
    }
    }
   
    public void initialiserPartie(){
       attribuerCouleursAuxJoueurs(); // Attribue couleur aux joueurs 
       grilleJeu = new Grille(); // Création grille jeu
       for (int i=0; i<21; i++){ // boucle pour remplir le tableu de jeton
           ListeJoueurs[0].ajouterJetons(new Jeton ("rouge")); // Jeton rouge
           ListeJoueurs[1].ajouterJetons(new Jeton ("jaune")); // Jeton jaune
       }
        int l = rand.nextInt(6);
        int c = rand.nextInt(7);
        grilleJeu.cellulesJeu[l][c].placerTrouNoir(); // Génération des trou noirs
        for (int k=1; k<5; k++){
            l = rand.nextInt(6);
            c = rand.nextInt(7);
            while (grilleJeu.cellulesJeu[l][c].presenceTrouNoir()==true){ // Test présence trou noir
                l = rand.nextInt(6);
                c = rand.nextInt(7); 
        }    
        grilleJeu.cellulesJeu[l][c].placerTrouNoir(); 
        }
        int m = rand.nextInt(6); // Placement des trou des 3 désintégrateur pas sur des trous noirs
        int n = rand.nextInt(7);
        for (int i=0; i<3; i++){
        while (grilleJeu.cellulesJeu[m][n].presenceTrouNoir()==true && grilleJeu.cellulesJeu[m][n].presenceDesintegrateur()==true){ // Vérifie qu'il n'y ai pas de trou noir ni de désintégrateur 
            m =rand.nextInt(6);
            n = rand.nextInt(7);
        }
        grilleJeu.cellulesJeu[m][n].placerDesintegrateur(); // Place les 3 désintégrteur
        }
        int x =rand.nextInt(6); // Tire ligne et colonne au hasard
        int y =rand.nextInt(7);
        for (int i=0; i<2; i++){
        while (grilleJeu.cellulesJeu[x][y].presenceTrouNoir()==false){ // Vérifie qu'il y'ai bien un trou noir
            x =(int)(Math.random()*6);
            y = (int)(Math.random()*7);  
        }
        grilleJeu.cellulesJeu[x][y].placerDesintegrateur(); // Place les 2 désintégratuer sur les 2 trous noirs
       }
    }
    public void debuterPartie(){
        joueurCourant=ListeJoueurs[0]; // Premier joueur commence 
        while (grilleJeu.etreRempli()!=true && grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])!=true && grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])!=true){
            grilleJeu.afficherGrilleSurConsole(); // Affiche grille
            System.out.println("Choisir 1 pour placer un jeton \nChoisir 2 pour récuperer un jeton \nChoisir 3 pour placer un désintégrateur");
            System.out.println(joueurCourant.couleur); // affiche la cuelur du joueur qui joue
            Scanner sc; 
            sc = new Scanner(System.in);
            int choix = sc.nextInt(); // Choisi ce que l'on veut faire comme action 
            
            if (choix==2){
                //récupérer jeton
                System.out.println("Choisir l'emplacement du jeton à recuperer"); 
                System.out.println("Choisir la ligne");
                int ligne = sc.nextInt();
                System.out.println("Choisir la colonne");
                int colonne = sc.nextInt();
                while (grilleJeu.cellulesJeu[ligne][colonne].lireCouleurDuJeton()!=joueurCourant.couleur){ // couleur fu jeton doit être différent de celui du joueur en trian de jouer
                    System.out.println("Choisir l'emplacement du jeton à recuperer");
                    System.out.println("Choisir la ligne");
                    ligne = sc.nextInt();
                    System.out.println("Choisir la colonne");
                    colonne = sc.nextInt();
                }
                joueurCourant.ajouterJetons(grilleJeu.recupererJeton(ligne, colonne));
                grilleJeu.tasserGrille(colonne); // tasse grille 
                grilleJeu.afficherGrilleSurConsole(); // Affiche la grille 

                
            }
            if (choix ==3){ // Jouer un désintégrateur 
                if (joueurCourant.nombreDesintegrateur==0){ // Pas de désintégrateur en sa possession
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
            
            
            

            
            
            if (choix ==1){ // Veut placer un jeton 
            System.out.println("Choisissez une colonne");
            int choixcol = sc.nextInt();
            while ( choixcol!=0 && choix != 1 && choixcol !=2 && choixcol!= 3 && choixcol!= 4 && choixcol !=5 && choixcol != 6 ){ // Choisi une colonne
                System.out.println("Choisissez une colonne");
                choixcol = sc.nextInt();
            } 
            while (grilleJeu.colonneRemplie(choixcol)!=false){ // Vérifie si la colonne est remplie 
                System.out.println("Choisissez une colonne non remplie");
                choix = sc.nextInt();
                while ( choixcol !=0 && choixcol != 1 && choixcol !=2 && choixcol!= 3 && choixcol != 4 && choixcol !=5 && choixcol != 6 ){
                    choixcol = sc.nextInt();
            }
            }
            
        
           
            Jeton J = joueurCourant.listeJetons[joueurCourant.nombresJetonsRestants-1];
            joueurCourant.nombresJetonsRestants--; // Décrémente le nombre de jeton 
            grilleJeu.ajouterJetonDansColonne(J, choixcol); // Ajoute jeton dans colonne
            grilleJeu.afficherGrilleSurConsole(); // affiche grille 
                
            }
            
            if (joueurCourant==ListeJoueurs[0]){ // chage de joueur 
                joueurCourant=ListeJoueurs[1];                
            }else{
                joueurCourant=ListeJoueurs[0];
            }
        }
    }
}

