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
    public String lireCouleur(){
        return couleur;
    }
    
    public boolean EtreAllume() {
        return true;
    }
    
    public void CliquerBouton() {
        
    }
    
    public boolean EtreUnBoutonPiege() {
       return true;
    }
    
}
