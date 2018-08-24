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
import javax.swing.JPanel;

/**
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 * 
 * The <code>Oval</code> class is used to encapsulate Oval.
 * 
 * Constructor Summary:
 * Oval()
 * 
 * border ovals :
 * **colored-border ovals
 * Oval(JPanel board ,
            int x , int y , int width , int height ,
            Color color ,
            boolean isBorder)
 * 
 * full-colored ovals:
 * ** full-colored ovals
 * Oval(JPanel board ,
                int x , int y , int width , int height ,
                Color color)
 *
 * Method Summary:
 * paint(Graphics g)
 */
public class Oval
                    extends Shape {
    
// Static Final Values

// *************************************************************

// Static Variables

// *************************************************************

// Final Fields

// *************************************************************

// Fields
    
    protected boolean
                        isBorder = false;

// *************************************************************

// Constructors
    
    /**
     * Constructs a new <code>Oval</code> object.
     */
    public Oval(){}
    
// Colored-Border
    
    /**
     * Constructs a new <code>Oval</code> object.
     * It is a colored-border of an oval in (x,y) coordinate System on board.
     * Its width and height is defined by parameters.
     * It is designed to draw a colored-border of an oval but if isBorder==false, it just construct a full-colored oval.
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     * @param isBorder 
     */
    public Oval(JPanel board ,
                int x , int y , int width , int height ,
                Color color ,
                boolean isBorder){
        
        this(board ,
                x , y , width , height ,
                color);
        
        this.isBorder = isBorder;
    }
    
// Full-Colored Ovals
    
    /**
     * Constructs a new <code>Oval</code> object.
     * It is a full-colored of a color oval in (x,y) coordinate system on board.
     * Its width, height is defined by parameters.
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color 
     */
    public Oval(JPanel board ,
                int x , int y , int width , int height ,
                Color color){
        
        super(board ,
                x , y , width , height ,
                color);
    }

// *************************************************************

// Methods
    
    /**
     * It draws oval base on type of it which is specified by isBorder.
     * @param g 
     */
    public void paint(Graphics g){
        
        super.paint(g);
        
        if(isBorder){
            g2.drawOval(x, y, width, height);
        } else{
            g2.fillOval(x, y, width, height);
        }
    }
}
