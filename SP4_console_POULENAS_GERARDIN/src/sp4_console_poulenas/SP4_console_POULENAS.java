/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_poulenas;

/**
 *
 * @author Poulenas
 * Poulenas Sandra
 * TDA 
 * Super puissance 4 
 * 25.10.2021
 */
public class SP4_console_POULENAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Joueur joueur1= new Joueur("Sandra");
        Joueur joueur2 = new Joueur("Camille");
        Partie PremierePartie = new Partie(joueur1, joueur2);
        PremierePartie.initialiserPartie();
        PremierePartie.debuterPartie();
     
        
    }
    
}
