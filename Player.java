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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Ball City Game   Version 0.1
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 * 
 * The <code>Player</code> class is used to encapsulate player objects.
 * 
 * Constructor Summary:
 * Player()
 * Player(Board board ,
                    int x , int y ,
                    int playerNumber)
 *
 * Method Summary:
 * calculateScoreLevel(int playerNumber)
 * paint(Graphics g)
 * 
 * Inherited Methods:
 * -
 */
public class Player {
    
// Static Final Values
    
    private static final int
                            PLAYER1 = 1 ,
                            PLAYER2 = 2;

// *************************************************************

// Static Variables

// *************************************************************

// Final Fields

// *************************************************************

// Fields
    
    private int
                x , y;
    private int
                level ,
                playerNumber ,
                score;
    
    private Graphics2D
                        g2;
    
    private Board
                board;

// *************************************************************

// Constructors
    
    /**
     * Constructs a new <code>Player</code> object.
     */
    public Player(){}
    
    /**
     * Constructs a new <code>Player</code> object.
     * It initials fields of player and specify which player it is by playerNumber field.
     * @param board
     * @param x
     * @param y
     * @param playerNumber 
     */
    public Player(Board board ,
                    int x , int y ,
                    int playerNumber){
        
        this.x = x;
        this.y = y;
        
        this.level = 1;
        this.score = 0;
        
        this.playerNumber = playerNumber;
        
        this.board = board;   
    }

// *************************************************************

// Methods
    
    /**
     * It calculates score and level of every player base on ball is collided to rockets or ran out of page.
     * @param playerNumber 
     */
    public void calculateScoreLevel(int playerNumber){
        
        if(this.playerNumber == playerNumber){
            switch(playerNumber){
                case PLAYER1 :
                    if((((Ball)board.getBall()).isCollided(Board.ROCKET_LEFT_RIGHT_PLAYER1)) ||
                            (((Ball)board.getBall()).isCollided(Board.ROCKET_UP_DOWN_PLAYER1))){
                        score++;
                        level = score>0 ? (score/10)+1 : 0;
                    } else if((((Ball)board.getBall()).getX()>board.getFrame().getWidth()-board.getRocketWidthMarginUpDown()) ||
                            (((Ball)board.getBall()).getY()>board.getFrame().getHeight()-board.getRocketHeightMarginLeftRight())){
                        score--;
                        level = score>0 ? (score/10)+1 : 0;
                    }
                    break;
                case PLAYER2 :
                    if((((Ball)board.getBall()).isCollided(Board.ROCKET_LEFT_RIGHT_PLAYER2)) ||
                            (((Ball)board.getBall()).isCollided(Board.ROCKET_UP_DOWN_PLAYER2))){
                        score++;
                        level = score>0 ? (score/10)+1 : 0;
                    } else if((((Ball)board.getBall()).getX()<board.getRocketWidthMarginUpDown()/2) ||
                            (((Ball)board.getBall()).getY()<board.getRocketHeightMarginLeftRight()/2)){
                        score--;
                        level = score>0 ? (score/10)+1 : 0;
                    }
                    break;
            }
        } else{
            System.err.println("Invoking wrong calculateScoreLevel method of Player class by playerNumber");
        }
    }
    
    /**
     * It draws score and level of every player in the same color of their rockets.
     * @param g 
     */
    public void paint(Graphics g){
        
        g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        if(playerNumber == PLAYER1){
            g2.setColor(Color.yellow);
        } else{
            g2.setColor(Color.magenta);
        }
        
        g2.drawString("Level : " + level, (x+2) , y);
        g2.drawString("Score : " + score , (x+75), y);
    }
}
