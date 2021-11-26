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
    boolean desintegrateur;
    public Cellule (){
        jetonCourant=null;
    }
    public boolean affecterJeton(Jeton LeJeton){
        if (jetonCourant ==null){ 
            jetonCourant = LeJeton;
        if (prescenceTrouNoir()){ //Si préscence d'un trou noir
                activerTrouNoir(); // Active le trou noir 
            }
            return true;
        
        }
        return false;
    }
 
    public String lireCouleurDuJeton (){
        if (jetonCourant==null){
            return (" - "); //Abscnece de jeton dans la cellule
        }else {
        return jetonCourant.couleur; // Si jeton, retourner sa couleur
        }
    }
    public boolean placerTrouNoir(){ // Sert à placer le toru noir sur la grille
        if (trouNoir==false){
            trouNoir=true;
            return true;
        }
      return false;  
    }
    public boolean prescenceTrouNoir(){ // Sert à tester la présence d'un trou noir
        if (trouNoir==true){
            return true;
        }
        return false;
    }
    public boolean activerTrouNoir(){ // Sert à activer le toru noir 
         if (jetonCourant!=null){
             jetonCourant=null; // Supprime le jeton 
             trouNoir=false; // Supprime le trou noir
             return true;
                     
         }
        return false;
    }
    public Jeton recupererJeton(){
        return jetonCourant;
    }
    public boolean placerDesintegrateur(){
        if (desintegrateur==false){ //Absnce désintégrateur
            desintegrateur=true; // Ajout désintégrateur
            return true; 
        }
        return false; // Déjà un désintégrateur
    }
    public boolean prescenceDesintegrateur (){
        if (desintegrateur==true){
            return true;
        }
        return false; 
    }
    public boolean recupererDesintegrteur (){
        if (desintegrateur==true){
        desintegrateur=false;
        }
        return false;
    }
    public boolean supprimerJeton(){
        if (jetonCourant!=null){ // Il y a un jeton
            jetonCourant=null;//Supprime jeton
            return true;
        }
        return false; //Abscence jeton 
    }
   
}
    
