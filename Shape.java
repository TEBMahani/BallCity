/*
 * Copyright (C) 2018 alpha
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package mathematicianshape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 * 
 * The <code>Shape</code> class is used to encapsulate a common shape and play as a parent for specified shapes later.
 * 
 * Constructor Summary:
 * Shape()
 * Shape(JPanel board ,
            int x , int y , int width , int height ,
            Color color)
 *
 * Method Summary:
 * paint(Graphics g)
 * setColor(Color color)
 */
public class Shape {
    
// Static Final Values

// *************************************************************

// Static Variables

// *************************************************************

// Final Fields

// *************************************************************

// Fields
    
    protected int
                    x ,
                    y ,
                    width ,
                    height ;
    
    protected Color
                    color;
    protected Graphics2D
                        g2;
    
    protected JPanel
                    board;

// *************************************************************

// Constructors
    
    /**
     * Constructs a new <code>Shape</code> object.
     */
    public Shape(){}
    
    /**
     * Constructs a new <code>Shape</code> object.
     * It used to initials common fields of shapes. 
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color 
     */
    public Shape(JPanel board ,
                int x , int y , int width , int height ,
                Color color){
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        this.board = board;
        this.color = color;
    }

// *************************************************************

// Methods
    
    /**
     * It used to prepare graphic's environment for drawing children-shapes.
     * It sets color for children-shapes.
     * @param g 
     */
    public void paint(Graphics g){
        
        g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
    }
    
    /**
     * It sets color for color field.
     * @param color 
     */
    public void setColor(Color color){
        
        this.color = color;
    }
}
