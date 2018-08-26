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
 * The <code>RectangleShape</code> class is used to encapsulate rectangles.
 *
 * Constructor Summary:
 * RectangleShape()
 *
 * border rectangles :
 * ** colored-border 3DRectangle
 * RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    boolean isRaised ,
                    Color color ,
                    boolean isBorder)
 * ** colored-border rectangle
 * RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    Color color ,
                    boolean isBorder)
 * ** colored-border roundRectangle
 * RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    int arcWidth , int arcHeight ,
                    Color color ,
                    boolean isBorder)
 *
 * full-colored rectangles :
 * ** full-colored 3DRectangle
 * RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    boolean isRaised ,
                    Color color)
 * ** full-colored rectangle
 * RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    Color color)
 * ** full-colored roundRectangle
 * RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    int arcWidth , int arcHeight ,
                    Color color)
 *
 * Method Summary:
 * paint(Graphics g)
 */
public class RectangleShape
                        extends Shape{
    
// Static Final Values

// *************************************************************

// Static Variables

// *************************************************************

// Final Fields

// *************************************************************

// Fields
    
    protected int
                    arcWidth ,
                    arcHeight;
    
    protected boolean
                        isRounded = false ,
                        isBorder = false ,
                        isRaised = false;

// *************************************************************

// Constructors
    /**
     * Constructs a new <code>Rectangle</code> object.
     */
    public RectangleShape(){}
    
// Colored-Border Rectangles
    
    /**
     * Constructs a new <code>RectangleShape</code> object.
     * This is a colored-border of a color 3DRectangle in (x,y) coordinate system on board.
     * Its width, height is defined by parameters.
     * It designed to draw a colored-border of a 3DRectangle but
     *  if isBorder==false it would be a full-colored 3DRectangle,
     *  if isRaised==false it would be a colored-border of rectangle,
     *  if isBorder && isRaised==false it would be a full-colored rectangle!
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param isRaised
     * @param color
     * @param isBorder 
     */
    public RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    boolean isRaised ,
                    Color color ,
                    boolean isBorder){
        
        this(board ,
                x , y, width , height ,
                isRaised ,
                color);
        
        this.isBorder = isBorder;
    }
    
    /**
     * Constructs a new <code>RectangleShape</code> object.
     * This is a colored-border of a color rectangle in (x,y) coordinate system on board.
     * Its width, height is defined by parameters.
     * It designed to draw a colored-border of a rectangle but if isBorder==false it would be a full-colored rectangle!
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     * @param isBorder 
     */
    public RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    Color color ,
                    boolean isBorder){
        
        this(board ,
                x , y , width , height ,
                color);
        
        this.isBorder = isBorder;
    }
    
    /**
     * Constructs a new <code>RectangleShape</code> object.
     * This is a colored-border of a color roundRectangle in (x,y) coordinate system on board.
     * Its width, height, arcWidth, arcHeight is defined by parameters.
     * It designed to draw a colored-border of a roundRectangle but if isBorder==false it would be a full-colored roundRectangle!
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param arcWidth
     * @param arcHeight
     * @param color
     * @param isBorder 
     */
    public RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    int arcWidth , int arcHeight ,
                    Color color ,
                    boolean isBorder){
        
        this(board ,
                x , y , width , height ,
                arcWidth , arcHeight ,
                color);
        
        this.isBorder = isBorder;
    }
    
// Full-Colored Rectangles
    
    /**
     * Constructs a new <code>RectangleShape</code> object.
     * This is a full-colored 3DRectangle in (x,y) coordinate system on board.
     * Its width, height is defined by parameters.
     * It designed to draw a 3DRectangle, but if isRaised==false, it would be a full-colored rectangle!
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param isRaised
     * @param color 
     */
    public RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    boolean isRaised ,
                    Color color){
        
        this(board ,
                x , y , width , height ,
                color);
        
        this.isRaised = isRaised;
    }
    
    /**
     * Constructs a new <code>RectangleShape</code> object.
     * This object is a full-colored rectangle in (x,y) coordinate system on board.
     * Its width and height is defined by parameters.
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color 
     */
    public RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    Color color){
        
        super(board ,
                x , y , width , height ,
                color);
    }
    
    /**
     * Constructs a new <code>RectangleShape</code> object.
     * This is a full-colored roundRectangle in (x,y) coordinate system on board.
     * Its width, height, arcWidth and arc height is defined by parameters.
     * It sets isRounded = true.
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param arcWidth
     * @param arcHeight
     * @param color 
     */
    public RectangleShape(Board board ,
                    int x , int y , int width , int height ,
                    int arcWidth , int arcHeight ,
                    Color color){
        
        this(board ,
                x ,y , width , height ,
                color);
        
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.isRounded = true;
    }
    
// *************************************************************

// Methods
    
    /**
     * It draws rectangle base on type of it which is defined by isBorder or isRounded or isRaised.
     * If(isBorder == true) it draws a colored-border of rectangle base on following condition:
     *  If(isRounded == true) it draws a colored-border of roundRectangle.
     *  If(isRaised == true) it draws a colored-border of 3DRectangle.
     *  else means (isRounded && isRaised == false) and it draws a colored-border of rectangle.
     * 
     * else means (isBorder == false) so it draws a full-colored of rectangle base on following condition:
     *  If(isRounded == true) it draws a full-colored of a roundRectangle.
     *  If(isRaised == true) it draws a full-colored 3DRectangle.
     *      which inside color of rectangle is brighter than the color you specify to it
     *          and the edges of the rectangle will be highlighted so that it appears
     *          as if the edges were beveled and lit from the upper left corner,
     *          and its edge color is darker than the color you specify to it.
     *  else means (isRounded && isRaised == false) and it draws a full-colored of a rectangle.
     * @param g 
     */
    public void paint(Graphics g){
        
        super.paint(g);
        
        if(isBorder){
            if(isRounded){
                g2.drawRoundRect(x, y, width, height,
                                    arcWidth, arcHeight);
            } else if(isRaised){
                g2.draw3DRect(x, y, width, height,
                                isRaised);
            } else{
                g2.drawRect(x, y, width, height);
            }
        } else{
            if(isRounded){
                g2.fillRoundRect(x, y, width, height,
                                    arcWidth, arcHeight);
            } else if(isRaised){
                g2.fill3DRect(x, y, width, height,
                                isRaised);
            } else{
                g2.fillRect(x, y, width, height);
            }
        }
    }
}
