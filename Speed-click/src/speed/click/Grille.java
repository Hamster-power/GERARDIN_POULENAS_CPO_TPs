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
    Bouton [][] BoutonsJeu = new Bouton[4][4];
    Random rand =new Random(); 
  

    public Grille(){ // Génère une grille de bouton

       for (int i=0;i<4;i++){
        for (int j=0;j<4;j++){
            BoutonsJeu[i][j] = new Bouton("noir");
            
        } 
    }
}

    public boolean GrilleEteinte () { //Vérifie si la grille est eteinte ou non 
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (BoutonsJeu[i][j].lireCouleurBouton()!="noir"){
                  return false;  
                }
            }
        }
        return true;  
    }
    
    public void AllumerBoutonAleat(){ // Sert à allumer un bouton aléatoirement
        int l = rand.nextInt(4);
        int c = rand.nextInt(4);
        BoutonsJeu[l][c].couleur = "vert";
        
        
    }
    public void afficherBoutonSurGrille(){ //Affiche la grille sur la console 
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++) {
                String g = BoutonsJeu[i][j].lireCouleurBouton();
                if (g == "vert "){
                    g ="\\033[0;32m O\033[30m";
                }
                System.out.print(g+" | ");
            }
            System.out.println();
        }
    
}
    public boolean CliqueCorrect (int n1, int n2){ // Vérifie si le joueur clique sur le bouton allumé
        if (BoutonsJeu[n1][n2].couleur=="vert"){
            return true;
        }
        return false;
    }
    
    public void ChangerBoutonAllume(int n1, int n2){ // Change le bonton allumé lorsque le joueur à cliqué sur le bon bouton
        if(CliqueCorrect(n1, n2)==true){
            BoutonsJeu[n1][n2].couleur="noir";
            AllumerBoutonAleat();
        }
    }
    
    public void EtteindreGrille(){ // Etteint la grille à la fin de la partie
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                BoutonsJeu[i][j].couleur="noir";

        }
        }
    }
}
