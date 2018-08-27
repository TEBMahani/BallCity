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
package ballcity;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Ball City Game   Version 0.1
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 * 
 * * The <code>RocketUpDown</code> is used to encapsulate a RocketUpDown
 * which is a rocket that moves only up and down in frame.
 * It is a rocket which moves vertically in page and directs the ball.
 * 
 * Constructor Summary:
 * ** full-colored roundRocket
 * RocketUpDown(Board board ,
                    int x , int y , int width , int height ,
                    int arcWidth , int arcHeight ,
                    Color color)
 * 
 * Method Summary:
 * keyPressed(KeyEvent keyEvent)
 * keyReleased(KeyEvent keyEvent)
 * keyTyped(KeyEvent keyEvent)
 * move()
 * 
 * Inherited Methods: 
 *  From RectangleShape:
 *  paint(Graphics g)
 * 
 *  From Rocket class:
 *  -
 * 
 *  Ftom Shape class:  
 * getBounds()
 * getHeight()
 * getWidth()
 * getX()
 * getY()
 * isValidMove()
 * move()
 * paint(Graphics g)
 * setColor(Color color)
 */
public class RocketUpDown
                    extends Rocket
                    implements KeyListener{

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
     * Constructs a new <code>RocketUpDown</code> object.
     * It initials fields of rocket.
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param arcWidth
     * @param arcHeight
     * @param color
     * @param playerNumber 
     */
    public RocketUpDown(Board board ,
                    int x , int y , int width , int height ,
                    int arcWidth , int arcHeight ,
                    Color color ,
                    int playerNumber){
        
        super(board ,
                x , y , width , height ,
                arcWidth , arcHeight ,
                color ,
                playerNumber);
    }

// *************************************************************

// Methods
    
    /**
     * It specifies amount of moving of rocket vertically to up or down base on which player presses his/her keys.
     * @param keyEvent 
     */
    public void keyPressed(KeyEvent keyEvent){
        
        if(playerNumber == PLAYER1){
            if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
                moveY = -3;
            } else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
                moveY = 3;
            }
        } else{
            if(keyEvent.getKeyCode() == KeyEvent.VK_W){
                moveY = -3;
            } else if(keyEvent.getKeyCode() == KeyEvent.VK_S){
                moveY = 3;
            }
        }
    }
    
    /**
     * It prevents rocket runnig to the end of page and makes sure it stops moving when
     * player stops pressing keys
     * @param keyEvent 
     */
    public void keyReleased(KeyEvent keyEvent){
        
        moveY = 0;
    }
    
    /**
     * I just implemeted it because I didn't want to implement KeyAdapter.
     * @param keyEvent 
     */
    public void keyTyped(KeyEvent keyEvent){}
    
    /**
     * It moves rocket.
     * Before it moves rocket makes sure rocket keeps distance of edges of frame which we call them margins.
     */
    public void move(){
        
        if((y+moveY)>board.getFrame().getHeight()-(height+board.getRocketHeightMarginUpDown()) ||
                (y+moveY)<board.getRocketHeightMarginUpDown()){
            moveY = 0;
        }
        
        y += moveY;
    }
}
