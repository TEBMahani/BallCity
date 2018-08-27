/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballcity;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * Ball City Game   Version 0.1
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 * 
 * The <code>Main</code> class is used to encapsulate a JFrame which game plays on it.
 * The main() method exist in this class and the game starts from here.
 * 
 * Constructor Summary:
 * Main()
 *
 * Method Summary:
 * main(String[] args)
 * 
 * Inherited Methods:
 * -
 */

public class Main
                    extends JFrame{

// Static Final Values

// *************************************************************

// Static Variables

// *************************************************************

// Final Fields

// *************************************************************

// Fields

// *************************************************************

// Constructors
    
    /**
     * Constructs a new <code>Main</code> object.
     * It specify JFrame's fields.
     */
    public Main(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700 , 800);
        setResizable(false);
        add(new Board(this));
        setVisible(true);      
    }

// *************************************************************

// Methods
    
    /**
     * This creates a <code>Main</code> object which is a child of JFrame.
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        
        new Main();
    }
    
}
