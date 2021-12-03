/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.click;

/**
 *
 * @author camille
 */
public class Grille {
    Bouton [][] BoutonsJeu = new Bouton[4][4];
  

    public Grille(){

       for (int i=0;i<4;i++){
        for (int j=0;j<4;j++){
            BoutonsJeu[i][j] = new Bouton("noir");
            
        } 
    }
}
    public void AjouterBoutonDansGrille(){
        
    }
    
    public boolean GrilleEteinte () {
        return true;  
    }
    
    public void AllumerBoutonAleat(){
        
    }
    
}
