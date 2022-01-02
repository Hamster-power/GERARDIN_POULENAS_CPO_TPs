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
    public void afficherBoutonSurGrillardin (){ //Affiche la grille sur la console 
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++) {
                String g = BoutonsJeu[i][j].lireCouleurBouton();
                if (g == "noir"){
                    g ="\033[030m O\033[30m";
                }else if (g == "vert"){
                    g ="\033[032m O\033[30m";
                }
                else if (g=="rouge"){
                    g = "\033[031m O\033[30m";
                }
                System.out.print(g+" | ");
            }
            System.out.println();
        }   
}
    
    public boolean CliqueCorrectGrillardin (int n1, int n2){ // Vérifie si le joueur clique sur le bouton allumé en vert
        if (BoutonsJeu[n1][n2].couleur=="vert"){ 
            return true;
        }
        return false;
    }
    
    
    public boolean CliqueRougeGrillardin (int n1, int n2){ // Renvoie vraie si le bouton est rouge 
        if (BoutonsJeu[n1][n2].couleur=="rouge"){
            return true;
        }
        return false;
    }
    
     public void ChangerBoutonAllume(int n1, int n2){ // Change le bonton allumé lorsque le joueur à cliqué sur le bon bouton
        if(CliqueCorrectGrillardin(n1, n2)==true){
            BoutonsJeu[n1][n2].couleur="noir"; // Bouton redeviens noir 
            AllumerBoutonAleatGrillardin(); //allume un autre bouton 
        }
    }
     
     
    public void EtteindreGrillardin(){ // Etteint la grille à la fin de la partie
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                BoutonsJeu[i][j].couleur="noir"; // Tous boutons redeviennent noir 

        }
        }
    }
     
     
     
}
