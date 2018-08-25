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
import java.awt.Rectangle;
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
 * getBounds()
 * IsValidMove()
 * move()
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
    protected int
                    moveX ,
                    moveY ;
    
    protected Color
                    color;
    protected Graphics2D
                        g2;
    
    protected Board
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
    public Shape(Board board ,
                int x , int y , int width , int height ,
                Color color){
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        this.moveX = 1;
        this.moveY = 1;
        
        this.board = board;
        this.color = color;
    }

// *************************************************************

// Methods
    
    /**
     * Create a rectangle object of java.awt.Rectangle package which specifies bounds of shape and return it
     * @return 
     */
    public Rectangle getBounds(){
        return new Rectangle(x , y , width , height);
    }
    
    /**
     * Verify if shape moves inside of frame or not.
     * @return if shape is moving inside of frame it returns true, otherwise it returns false.
     */
    public boolean IsValidMove(){
        if(((x+moveX)>board.getFrame().getWidth()-width) ||
                ((x+moveX)<0) ||
                ((y+moveY)>board.getFrame().getHeight()-height) ||
                (y+moveY)<0){
            return false;
        } else{
            return true;
        }        
    }
    
    /**
     * Specify a default move for shape
     */
    public void move(){
        if(!IsValidMove()){
            if(((x+moveX)>board.getFrame().getWidth()-width)){
                moveX = -1;
            } else if((x+moveX)<0){
                moveX = 1;
            }
            if(((y+moveY)>board.getFrame().getHeight()-height)){
                moveY = -1;
            } else if((y+moveY)<0){
                moveY = 1;
            }
        }
        
        x += moveX;
        y += moveY;
    }
    
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
