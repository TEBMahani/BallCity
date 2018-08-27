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
import java.util.Random;

/**
 * Ball City Game   Version 0.1
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 * 
 * The <code>Ball</code> class is used to encapsulate ball object.
 * This ball can move on board of game and identify when it is collided to rockets and change its direct.
 * 
 * Constructor Summary:
 * Ball(Board board ,
                int x , int y , int width , int height ,
                Color color)
 *
 * Method Summary:
 * isCollided(int rocketIdentifier)
 * makeA_B()
 * makeDirectMaking()
 * makeNewBall()
 * move()
 * nextInt(int bound)
 * 
 * Inherited Methods:
 *  From OvalShape class:
 *  paint(Graphics g)
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
public class Ball
                    extends OvalShape{
    
// Static Final Values

// *************************************************************

// Static Variables

// *************************************************************

// Final Fields

// *************************************************************

// Fields

    private int
                A ,
                B ,
                directMaking;
    
    private Random
                    random;
    
// *************************************************************

// Constructors
    
    /**
     * Constructs a new <code>Ball</code> object.
     * It uses Oval class as parent to make its objects.
     * It uses random numbers and y=Ax+B formula to define way which ball should start running.
     * @param board
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color 
     */
    public Ball(Board board ,
                int x , int y , int width , int height ,
                Color color){
        
        super(board ,
                x , y , width , height ,
                color);

       makeA_B();        
    }

// *************************************************************

// Methods
    
    /**
     * It has a rocketIdentifier due to distinguish which rocket do you want to verify
     * that it is collided to it.
     * If rocket and ball are collided together, it returns true.
     * @param rocketIdentifier
     * @return 
     */
    public boolean isCollided(int rocketIdentifier){
        
        switch(rocketIdentifier){
            case Board.ROCKET_LEFT_RIGHT_PLAYER1 :
                return board.getRocketLeftRightPlayer1().getBounds().intersects(getBounds());
            case Board.ROCKET_LEFT_RIGHT_PLAYER2 :
                return board.getRocketLeftRightPlayer2().getBounds().intersects(getBounds());
            case Board.ROCKET_UP_DOWN_PLAYER1 :
                return board.getRocketUpDownPlayer1().getBounds().intersects(getBounds());
            case Board.ROCKET_UP_DOWN_PLAYER2 :
                return board.getRocketUpDownPlayer2().getBounds().intersects(getBounds());
        }
        return false;
    }
    
    /**
     * It defines a random direct way for ball to run
     */
    private void makeA_B(){
        
        random = new Random();
        
        A = 1;        
        B = nextInt(10);
        directMaking = nextInt(4);
        switch(directMaking){
            case 0 :
                    moveX = 1;
                    moveY = 1;
                    break;
            case 1 :
                    moveX = 1;
                    moveY = -1;
                    break;
            case 2 :
                    moveX = -1;
                    moveY = 1;
                    break;
            case 3 :
                    moveX = -1;
                    moveY = -1;
                    break;
        }
        
        y = (A*x)+B;
    }
    
    /**
     * It uses to specify moveX & moveY should increase or decrease randomly
     * @return 
     */
    public int makeDirectMaking(){
        
        return nextInt(2)==0 ? 1 : (-1);
    }
    
    /**
     * It defines new (x,y) in coordinate system and moveX and moveY to ball start moving on board after it's out of board.
     */
    public void makeNewBall(){
        
        x = board.getFrame().getWidth()/2;
        y = board.getFrame().getHeight()/2;
        makeA_B();
    }
    
    /**
     * It defines how ball should run, whether it is collided to any rocket or not.
     */
    public void move(){
        
        if(isCollided(Board.ROCKET_LEFT_RIGHT_PLAYER1)){
            moveY = -1;
            if(x == board.getRocketWidthMarginLeftRight()){
                moveX = 1;
            } else if(x == (board.getFrame().getWidth()-board.getRocketWidthMarginLeftRight())){
                moveX = -1;
            } else{
                moveX = makeDirectMaking();
            }
        } else if(isCollided(Board.ROCKET_LEFT_RIGHT_PLAYER2)){
            moveY = 1;
            if(x == board.getRocketWidthMarginLeftRight()){
                moveX = 1;
            } else if(x == (board.getFrame().getWidth()-board.getRocketWidthMarginLeftRight())){
                moveX = -1;
            } else{
                moveX = makeDirectMaking();
            }
        } else if(isCollided(Board.ROCKET_UP_DOWN_PLAYER1)){
            moveX = -1;
            if(y == board.getRocketHeightMarginUpDown()){
                moveY = 1;
            } else if(y == (board.getFrame().getHeight()-board.getRocketHeightMarginUpDown())){
                moveY = -1;
            } else{
                moveY = makeDirectMaking();
            }
        } else if(isCollided(Board.ROCKET_UP_DOWN_PLAYER2)){
            moveX = 1;
            if(y == board.getRocketHeightMarginUpDown()){
                moveY = 1;
            } else if(y == (board.getFrame().getHeight()-board.getRocketHeightMarginUpDown())){
                moveY = -1;
            } else{
                moveY = makeDirectMaking();
            }
        } else if(!isValidMove()){
            makeNewBall();
        }
        
        x += moveX;
        y += moveY;
    }
    
    /**
     * It makes a random int number which (0<=randomNumber<bound) and return it
     * @param bound
     * @return 
     */
    private int nextInt(int bound){
        
        return random.nextInt(bound);
    }
}
