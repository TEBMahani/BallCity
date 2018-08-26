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

/**
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 * 
 * The <code>Rocket</code> class is used to encapsulate a common rocket and play as a parent for specified rockets later.
 * 
 * Constructor Summary:
 * Rocket(Board board ,
                    int x , int y , int width , int height ,
                    int arcWidth , int arcHeight ,
                    Color color ,
                    int playerNumber)
 *
 * Method Summary:
 */
public class Rocket
                    extends RectangleShape{
    
// Static Final Values
    
    protected static final int
                            PLAYER1 = 1 ,
                            PLAYER2 = 2;

// *************************************************************

// Static Variables

// *************************************************************

// Final Fields

// *************************************************************

// Fields
    
    protected int
                playerNumber;

// *************************************************************

// Constructors
    
    /**
     * Constructs a new <code>Rocket</code> object.
     * It used to initials fields for rockets and set moveX=moveY=0 to make rockets don't move at first
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
    public Rocket(Board board ,
                    int x , int y , int width , int height ,
                    int arcWidth , int arcHeight ,
                    Color color ,
                    int playerNumber){
        
        super(board ,
                x , y , width , height ,
                arcWidth , arcHeight ,
                color);
        
        this.moveX = 0;
        this.moveY = 0;
        
        this.playerNumber = playerNumber;        
    }

// *************************************************************

// Methods
    
}
