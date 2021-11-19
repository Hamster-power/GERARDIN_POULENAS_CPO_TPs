/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_poulenas;

/**
 *
 * @author Poulenas
 */
public class Grille {
    Cellule[][] cellulesJeu = new Cellule[6][7];
  

    public Grille(){

       for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
          cellulesJeu[i][j] = new Cellule();
            
        } 
    }
}
    public boolean ajouterJetonDansColonne (Jeton LeJeton, int nombre){ //ajouter un jeton dans une colonne 
        for (int i=0; i<6; i++){
            if (cellulesJeu[i][nombre-1].jetonCourant==null){
                cellulesJeu[i][nombre-1].affecterJeton(LeJeton);
                return true; 
            }
        }
        return false;
    }
        
    
    public boolean etreRempli(){ // Savoir si la grille est remplie
        for (int i=0; i<7; i++){
           if (colonneRemplie(i)!=true) {
               return false; 
           }
        }
        return true;
            
        
    }
    public void videGrille(){
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                cellulesJeu[i][j].jetonCourant=null;
            }
    }   
    }
    public void afficherGrilleSurConsole (){
        for (int i=5; i>=0; i--){
            for (int j=0; j<7; j++) {
                String a = cellulesJeu[i][j].lireCouleurDuJeton();
                if (a=="rouge"){
                    a = "\033[31m O\033[30m";
                } if ( a=="jaune"){
                    a ="\033[33m O\033[30m";
                }
                System.out.print(a+" | ");
                
                
            }
        System.out.println();
        }  
      
    }
    public boolean celluleOccupee (int nombre1, int nombre2){
        if (cellulesJeu[nombre1][nombre2].jetonCourant!=null){
            return true;
        }
        return false;
    }
    
    public String lireCouleurJeton (int nombre1, int nombre2){
         return cellulesJeu[nombre1][nombre2].jetonCourant.couleur;
    }   
    
    public boolean etreGagnantePourJoueur (Joueur LeJoueur){
        for (int i=0; i<6; i++){
            for (int j=0; j<4; j++){
                if (cellulesJeu[i][j].jetonCourant!=null){
                    if (cellulesJeu[i][j].jetonCourant.couleur==LeJoueur.couleur){
                        if (cellulesJeu[i][j].lireCouleurDuJeton()==cellulesJeu[i][j+1].lireCouleurDuJeton() && cellulesJeu[i][j+1].lireCouleurDuJeton()==cellulesJeu[i][j+2].lireCouleurDuJeton() && cellulesJeu[i][j+2].lireCouleurDuJeton()==cellulesJeu[i][j+3].lireCouleurDuJeton()){
                            return true;
                    }   
                }
                }
            }
        }
        for (int i=0; i<3; i++){
            for (int j=0; j<7; j++){
                if (cellulesJeu[i][j].jetonCourant!=null){
                    if (cellulesJeu[i][j].jetonCourant.couleur==LeJoueur.couleur){
                        if (cellulesJeu[i][j].lireCouleurDuJeton()==cellulesJeu[i+1][j].lireCouleurDuJeton() && cellulesJeu[i+1][j].lireCouleurDuJeton()==cellulesJeu[i+2][j].lireCouleurDuJeton() && cellulesJeu[i+2][j].lireCouleurDuJeton()==cellulesJeu[i+3][j].lireCouleurDuJeton()){
                            return true;
                        }
                    }
                }
            }
        }
        for (int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                if (cellulesJeu[i][j].jetonCourant!=null){
                    if (cellulesJeu[i][j].jetonCourant.couleur==LeJoueur.couleur){
                        if ( cellulesJeu[i][j].lireCouleurDuJeton()==cellulesJeu[i+1][j+1].lireCouleurDuJeton() && cellulesJeu[i+1][j+1].lireCouleurDuJeton()==cellulesJeu[i+2][j+2].lireCouleurDuJeton() && cellulesJeu[i+2][j+2].lireCouleurDuJeton()==cellulesJeu[i+3][j+3].lireCouleurDuJeton()){
                            return true;
                        }
                    }
                }
            }
        }
        for (int i=5; i>2; i--){
            for (int j=0; j<4; j++){
                if (cellulesJeu[i][j].jetonCourant!=null){
                    if (cellulesJeu[i][j].jetonCourant.couleur==LeJoueur.couleur){
                        if ( cellulesJeu[i][j].lireCouleurDuJeton()==cellulesJeu[i-1][j+1].lireCouleurDuJeton() && cellulesJeu[i-1][j+1].lireCouleurDuJeton()==cellulesJeu[i-2][j+2].lireCouleurDuJeton() && cellulesJeu[i-2][j+2].lireCouleurDuJeton()==cellulesJeu[i-3][j+3].lireCouleurDuJeton()){
                            return true;
                    
                    }
                }
                }
            }
        }
        return false;
                    
}
    public boolean colonneRemplie (int nombre){
         for (int j=0; j<6; j++){
             if (cellulesJeu[j][nombre].jetonCourant==null){
                 return false;
             }
         }
         return true;
    }
    public boolean placerTrouNoir (int nombre1, int nombre2){
        return cellulesJeu[nombre1][nombre2].placerTrouNoir();
        
    }
}
