/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.click;

/**
 *
 * @author camille
 */
public class Bouton {
    String couleur;
    public Bouton (String uneCouleur){
        couleur = uneCouleur;
    }
    public String lireCouleurBouton(){
        return couleur;
    }
    
    public boolean EtreAllume(Bouton LeBouton) {
        if (LeBouton.couleur == "blanc"){
            return true;
        }
        return false;
    }
    
    public boolean EtreCliquer() {
        return true;
        
    }
    
    public boolean EtreUnBoutonPiege() {
       return true;
    }
    
}
