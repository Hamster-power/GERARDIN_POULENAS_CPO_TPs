/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.click;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Poulenas
 */
public class Bouton_Graphique extends JButton{
  Bouton BoutonAssociee  ; // Attribut 
  ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/image/noir.jpg"));
  
  public Bouton_Graphique(Bouton UnBouton){ // Constructeur avce paramètre 
      BoutonAssociee = UnBouton; 
  }
  
  @Override
  public void paintComponent(Graphics G){ // Méthode déjà existante dans java 
      super.paintComponent(G); 
      setIcon(img_vide); // On attribue l'image noir.jpg
  }
    
}
