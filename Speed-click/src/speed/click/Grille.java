/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.click;

import java.util.Random;

/**
 *
 * @author camille
 */
public class Grille {
    Bouton [][] BoutonsJeu = new Bouton[5][5]; // Crée une grille de 25 boutons 
    Random rand =new Random(); 
  

    public Grille(){ // Génère une grille de bouton

       for (int i=0;i<5;i++){
        for (int j=0;j<5;j++){
            BoutonsJeu[i][j] = new Bouton("noir"); // Ce qui vient crée les boutons 
            
        } 
    }
}

    public boolean GrilleEteinte () { //Vérifie si la grille est eteinte ou non 
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if (BoutonsJeu[i][j].lireCouleurBouton()!="noir"){
                  return false;  // Retourne faux si il y'a des boutons non noirs
                }
            }
        }
        return true;  
    }
    
    public void AllumerBoutonAleat(){ // Sert à allumer un bouton aléatoirement
        int l = rand.nextInt(5);
        int c = rand.nextInt(5);
        if (BoutonsJeu[l][c].couleur=="rouge"){ // Retire des coordonées si le bouton est rouge
            l = rand.nextInt(5);
            c = rand.nextInt(5);
        }
        BoutonsJeu[l][c].couleur = "vert";
    }
    
    
    public void AllumerBoutonPiege(){ // Allume un bouton d'une couleur rouge 
        int l = rand.nextInt(5);
        int c = rand.nextInt(5);
        if (BoutonsJeu[l][c].lireCouleurBouton()!="noir"){ // Si le bouton n'est pas noir donc est vert 
            l = rand.nextInt(5);
            c = rand.nextInt(5); 
        } else {
            BoutonsJeu[l][c].couleur="rouge";
        }
    }
    
    public void EtteindreBoutonPiege(){ // Sert à etteindre un bouton piège
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if (BoutonsJeu[i][j].lireCouleurBouton()=="rouge"){ 
                    BoutonsJeu[i][j].couleur="noir"; // Bouton devient noir s'il était rouge 
                }
            }
        }
    }
    

    
    public void afficherBoutonSurGrille(){ //Affiche la grille sur la console 
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++) {
                String g = BoutonsJeu[i][j].lireCouleurBouton(); // g sera donc la couelur du jeton 
                if (g == "noir"){
                    g ="\033[030m O\033[30m"; // Rond noir
                }else if (g == "vert"){
                    g ="\033[032m O\033[30m"; // rond vert 
                }
                else if (g=="rouge"){
                    g = "\033[031m O\033[30m"; // rond rouge 
                }
                System.out.print(g+" | ");
            }
            System.out.println(); 
        }
    
}
    public boolean CliqueCorrect (int n1, int n2){ // Vérifie si le joueur clique sur le bouton allumé en vert
        if (BoutonsJeu[n1][n2].couleur=="vert"){ 
            return true;
        }
        return false;
    }
    
    public boolean CliqueRouge (int n1, int n2){ // Renvoie vraie si le bouton est rouge 
        if (BoutonsJeu[n1][n2].couleur=="rouge"){
            return true;
        }
        return false;
    }
    
    public void ChangerBoutonAllume(int n1, int n2){ // Change le bonton allumé lorsque le joueur à cliqué sur le bon bouton
        if(CliqueCorrect(n1, n2)==true){
            BoutonsJeu[n1][n2].couleur="noir"; // Bouton redeviens noir 
            AllumerBoutonAleat(); //allume un autre bouton 
        }
    }
    
    public void EtteindreGrille(){ // Etteint la grille à la fin de la partie
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                BoutonsJeu[i][j].couleur="noir"; // Tous boutons redeviennent noir 

        }
        }
    }
}
