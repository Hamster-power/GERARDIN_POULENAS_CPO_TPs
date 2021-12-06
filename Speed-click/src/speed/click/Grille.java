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
  

    public Grille(){

       for (int i=0;i<4;i++){
        for (int j=0;j<4;j++){
            BoutonsJeu[i][j] = new Bouton("noir");
            
        } 
    }
}

    public boolean GrilleEteinte () {
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (BoutonsJeu[i][j].lireCouleurBouton()!="noir"){
                  return false;  
                }
            }
        }
        return true;  
    }
    
    public void AllumerBoutonAleat(){
        int l = rand.nextInt(4);
        int c = rand.nextInt(4);
        BoutonsJeu[l][c].couleur = "vert";
        
        
    }
    public void afficherBoutonSurGrille(){
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
    public boolean EtreBienClique (int n1, int n2){
        if (BoutonsJeu[n1][n2].couleur=="vert"){
            return true;
        }
        return false;
    }
    
    public void ChangerBoutonAllume(int n1, int n2){
        if(EtreBienClique(n1, n2)==true){
            BoutonsJeu[n1][n2].couleur="noir";
            AllumerBoutonAleat();
        }
    }
}
