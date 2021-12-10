/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package speed.click;


/**
 *
 * @author camille
 */
public class SpeedClick {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Joueur joueurCourant = new Joueur();
        Partie PremierePartie = new Partie(joueurCourant);
        //PremierePartie.DemarrerChrono();
        //while (PremierePartie.nbSecondes <5) {
            //System.out.println(PremierePartie.nbSecondes );}
        
        //PremierePartie.monChrono.stop();
        PremierePartie.InitialiserPartie();
        PremierePartie.DebuterPartie();
    }
    
}
