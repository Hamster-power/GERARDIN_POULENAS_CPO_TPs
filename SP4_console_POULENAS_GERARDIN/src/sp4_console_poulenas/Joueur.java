/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_poulenas;

/**
 *
 * @author Poulenas
 */
public class Joueur {
    String nom;
    String couleur;
    Jeton[] listeJetons = new Jeton [21];
    int nombresJetonsRestants = 0;
    int nombreDesintegrateur =0;
    
    public Joueur (String nomJoueur){
    nom = nomJoueur;
    }
    public void affetcerCouleur(String couleurChoisie){
       couleur = couleurChoisie; 
    }
    public boolean ajouterJetons (Jeton leJeton){
        if (nombresJetonsRestants<22){
        listeJetons[nombresJetonsRestants]= leJeton;
        nombresJetonsRestants++;
        return true;
        }
        return false;
        
    }
    public void obtenirDesintegrateur(){ // incremente nombre de desintégrateur 
       nombreDesintegrateur++; 
    }
    public boolean utiliserDesintegrateur (){ // Décrémente le nombre de désintégrateur 
        if (nombreDesintegrateur>0){ 
            nombreDesintegrateur--;
            return true; // Utilisation OK
        }
        return false; // Il ne restait plus de désintégrateur 
    }
}
