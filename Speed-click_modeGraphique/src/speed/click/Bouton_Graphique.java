/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.click;

import javax.swing.JButton;

/**
 *
 * @author Poulenas
 */
public class Bouton_Graphique extends JButton{
  Bouton BoutonAssociee  ; // Attribut 
  
  public Bouton_Graphique(Bouton UnBouton){ // Constructeur avce paramètre 
      BoutonAssociee = UnBouton; 
  }
    
}
