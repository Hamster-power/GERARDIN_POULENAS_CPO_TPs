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
  ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/image/noir.jpg")); // Crée référence vers les 3 images 
  ImageIcon img_verte = new javax.swing.ImageIcon(getClass().getResource("/image/vert.jpg"));
  ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/image/rouge.jpg"));
  
  public Bouton_Graphique(Bouton UnBouton){ // Constructeur avce paramètre 
      BoutonAssociee = UnBouton; 
  }
  
  @Override
  public void paintComponent(Graphics G){ // Méthode déjà existante dans java 
      super.paintComponent(G); 
      if(BoutonAssociee.EtreAllume(BoutonAssociee)==true ){ // Si présence d'un bouton vert
          setIcon(img_verte); // Case devient verte
      } else if (BoutonAssociee.EtreUnBoutonPiege()==true){ // Si présence d'un bouton rouge 
          setIcon(img_rouge); // Case devient rouge 
      }
      setIcon(img_vide); // On attribue l'image noir.jpg
  }
    
}
