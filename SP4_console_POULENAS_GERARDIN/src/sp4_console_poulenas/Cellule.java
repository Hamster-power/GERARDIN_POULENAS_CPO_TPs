/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_poulenas;

/**
 *
 * @author Poulenas
 */
public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    public Cellule (){
        jetonCourant=null;
    }
    public boolean affecterJeton(Jeton LeJeton){
        if (jetonCourant ==null){
            jetonCourant = LeJeton;
            return true;
        }
        return false;
    }
 
    public String lireCouleurDuJeton (){
        if (jetonCourant==null){
            return (" - ");
        }else {
        return jetonCourant.couleur;
        }
    }
    public boolean placerTrouNoir(){
        if (trouNoir==false){
            trouNoir=true;
            return true;
        }
      return false;  
    }
    public boolean prescenceTrouNoir(){
        if (trouNoir==true){
            return true;
        }
        return false;
    }
    public boolean activerTrouNoir(){
         if (jetonCourant!=null){
             jetonCourant=null;
             trouNoir=false;
             return true;
                     
         }
        return false;
    }
   
}
    
