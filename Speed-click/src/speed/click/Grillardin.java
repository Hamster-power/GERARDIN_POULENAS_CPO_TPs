/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.click;

import java.util.Random;

/**
 *
 * @author Poulenas
 */
public class Grillardin {
        Bouton [][] BoutonsJeu = new Bouton[6][6];
        Random rand =new Random(); 
    public Grillardin (){ // Génère une grille de bouton plus grande que l'autre 
        for (int i=0;i<6;i++){
        for (int j=0;j<6;j++){
            BoutonsJeu[i][j] = new Bouton("noir");  
        } 
        }  
    }
    
    public boolean GrillardinEteinte () { //Vérifie si la grillardin est eteinte ou non 
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                if (BoutonsJeu[i][j].lireCouleurBouton()!="noir"){
                  return false;  
                }
            }
        }
        return true;  
    }
    
    public void AllumerBoutonAleatGrillardin(){ // Sert à allumer un bouton aléatoirement
        int l = rand.nextInt(6);
        int c = rand.nextInt(6);
        if (BoutonsJeu[l][c].couleur=="rouge"){
            l = rand.nextInt(6);
            c = rand.nextInt(6);
        }
        BoutonsJeu[l][c].couleur = "vert";
    }
    
    public void AllumerBoutonPiegeGrillardin(){ // Allume un bouton d'une couleur rouge 
        int l = rand.nextInt(6);
        int c = rand.nextInt(6);
        if (BoutonsJeu[l][c].lireCouleurBouton()!="noir"){ // Si le bouton n'est pas noir donc est vert 
            l = rand.nextInt(6);
            c = rand.nextInt(6); 
        } else {
            BoutonsJeu[l][c].couleur="rouge";
        }
    }
    
    public void EtteindreBoutonPiegeGrillardin(){ // Sert à etteindre un bouton piège
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                if (BoutonsJeu[i][j].lireCouleurBouton()=="rouge"){
                    BoutonsJeu[i][j].couleur="noir";
                }
            }
        }
    }
    
    
    
}
