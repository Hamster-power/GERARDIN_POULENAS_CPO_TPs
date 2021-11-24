/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_poulenas;

import javax.swing.JButton;

/**
 *
 * @author camille
 */
public class CelluleGraphique extends JButton {
    Cellule celluleAssociee;
    
    
    
    public CelluleGraphique (Cellule uneCellule) {
        celluleAssociee = uneCellule;
    } 
    
    
}
