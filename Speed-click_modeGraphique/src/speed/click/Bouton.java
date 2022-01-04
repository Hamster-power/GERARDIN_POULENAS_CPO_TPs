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
    String couleur; // Attributs 
    public Bouton (String uneCouleur){ // Constructeur 
        couleur = uneCouleur; 
    }
    public String lireCouleurBouton(){ // Lit couleur du bouton 
        return couleur;
    }
    
    public boolean EtreAllume(Bouton LeBouton) { // Vérifie si un bouton est allumé oou non ( vert ou pas)
        if (LeBouton.couleur == "vert"){
            return true; // Retourne vrai si bouton vert
        }
        return false;
    }
    
    public boolean EtreUnBoutonPiege() {// Vérifie si le bonton est piège (autre que noir ou vert)
        if (couleur!="noir" && couleur!="vert"){
        return true; // Retrourne vrai si bouton rouge ou bleu 
    }
        return false;
    }
    
}
