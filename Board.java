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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Ball City Game   Version 0.1
 * 
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 *
 * The <code>Board</code> class is a subclass of JPanel which is used to
 * encapsulate a JPanel with shapes which draws on it.
 * Shapes can move on this board.
 *
 * Constructor Summary:
 * Board()
 * Board(JFrame frame)
 *
 * Method Summary:
 * addNotify()
 * getBall()
 * getFrame()
 * getRocketHeightMarginLeftRight()
 * getRocketHeightMarginUpDown()
 * getRocketLeftRightPlayer1()
 * getRocketLeftRightPlayer2()
 * getRocketUpDownPlayer1()
 * getRocketUpDownPlayer2()
 * getRocketWidthMarginLeftRight()
 * getRocketWidthMarginUpDown()
 * keyPressed(KeyEvent keyEvent)
 * keyReleased(KeyEvent keyEvent)
 * keyTyped(KeyEvent keyEvent)
 * move()
 * paint(Graphics g)
 * run()
 * setRocketHeightMarginLeftRight(int rocketHeightMarginLeftRight)
 * setRocketHeightMarginUpDown(int rocketHeightMarginUpDown)
 * setRocketWidthMarginLeftRight(int rocketWidthMarginLeftRight)
 * setRocketWidthMarginUpDown(int rocketWidthMarginUpDown)
 * 
 * Inherited Methods:
 * -
 */
public class Board
                    extends JPanel
                    implements KeyListener ,
                                Runnable{

// Static Final Values
    
    private static final int
                            PLAYER1 = 1 ,
                            PLAYER2 = 2;
    
    public static final int
                            ROCKET_LEFT_RIGHT_PLAYER1 = 1 ,
                            ROCKET_LEFT_RIGHT_PLAYER2 = 2 ,
                            ROCKET_UP_DOWN_PLAYER1 = 3,
                            ROCKET_UP_DOWN_PLAYER2 = 4;

// *************************************************************

// Static Variables

// *************************************************************

// Final Fields

// *************************************************************

// Fields
    
    private int
                rocketWidthMarginUpDown , rocketHeightMarginLeftRight ,
                rocketHeightMarginUpDown , rocketWidthMarginLeftRight;

    private BufferedImage
                            backGround;
    private Graphics2D
                        g2;
    private JFrame
                    frame;
    private Thread
                    animatorThread;

    private Shape                    
                    ball ,
                    rocketLeftRightPlayer1 ,
                    rocketLeftRightPlayer2 ,
                    rocketUpDownPlayer1 ,
                    rocketUpDownPlayer2;
    private Player
                    player1 ,
                    player2;

// *************************************************************

// Constructors

    /**
     * Constructs a new <code>Board</code> object.
     */
    public Board(){}

    /**
     * Constructs a new <code>Board</code> object.
     * It creates these objects:
     *  ball ,
     *  player1 ,
     *  player2 ,
     *  rocketLeftRightPlayer1 ,
     *  rocketLeftRightPlayer2
     *  rocketUpDownPlayer1 ,
     *  rocketUpDownPlayer2  
     * @param frame
     */
    public Board(JFrame frame){

        this.frame = frame;
        frame.addKeyListener(this);
        
        int
                ballDim = 10;
        int
                rocketArcHeightUpDown , rocketArcWidthLeftRight ,
                rocketArcWidthUpDown , rocketArcHeightLeftRight ,
                rocketHeightUpDown , rocketWidthLeftRight ,
                rocketWidthUpDown , rocketHeightLeftRight ;
        rocketArcHeightUpDown = rocketArcWidthLeftRight = 5;
        rocketArcWidthUpDown = rocketArcHeightLeftRight = 5;
        rocketHeightUpDown = rocketWidthLeftRight = 70;
        rocketWidthUpDown = rocketHeightLeftRight = 10;
        
        rocketWidthMarginUpDown = rocketHeightMarginLeftRight = 20;
        rocketHeightMarginUpDown = rocketWidthMarginLeftRight = 20;
        
//Creates Full-Colored Oval

        //Creates a yellow full-colored circle with ovalDim as its dim,
                                    // which sits on first right-top of frame.
        ball = new Ball(this ,
                        (frame.getWidth()/2) , (frame.getHeight()/2) , ballDim , ballDim ,
                        Color.white);
        //Creates a Player object for player1 which calculates and draws scores and levels of player1 in the same color of its rockets.
        player1 = new Player(this ,
                            0 , frame.getHeight()-10 ,
                            PLAYER1);
        //Creates a Player object for player2 which calculates and draws scores and levels of player1 in the same color of its rockets.
        player2 = new Player(this ,
                            0 , 13 ,
                            PLAYER2);
//Creates Rockets of players

        //Create a rocket for palyer1 which moves to left and right
        rocketLeftRightPlayer1 = new RocketLeftRight(this ,
                                                    frame.getWidth()-(rocketWidthLeftRight+rocketWidthMarginLeftRight) , frame.getHeight()-(rocketHeightLeftRight+rocketHeightMarginLeftRight) , rocketWidthLeftRight , rocketHeightLeftRight ,
                                                    rocketArcWidthLeftRight , rocketArcHeightLeftRight ,
                                                    Color.yellow ,
                                                    PLAYER1);
        //Create a rocket for palyer2 which moves to left and right
        rocketLeftRightPlayer2 = new RocketLeftRight(this ,
                                                    0+rocketWidthMarginLeftRight , 0+rocketHeightMarginLeftRight , rocketWidthLeftRight , rocketHeightLeftRight ,
                                                    rocketArcWidthLeftRight , rocketArcHeightLeftRight ,
                                                    Color.magenta ,
                                                    PLAYER2);
        //Create a rocket for palyer1 which moves to up and down
        rocketUpDownPlayer1 = new RocketUpDown(this ,
                                                frame.getWidth()-(rocketWidthUpDown+rocketWidthMarginUpDown) , frame.getHeight()-(rocketHeightUpDown+rocketHeightMarginUpDown) , rocketWidthUpDown , rocketHeightUpDown ,
                                                rocketArcWidthUpDown , rocketArcHeightUpDown , 
                                                Color.yellow ,
                                                PLAYER1);
        //Create a rocket for palyer2 which moves to up and down
        rocketUpDownPlayer2 = new RocketUpDown(this ,
                                            0+rocketWidthMarginUpDown , 0+rocketHeightMarginUpDown , rocketWidthUpDown , rocketHeightUpDown ,
                                            rocketArcWidthUpDown , rocketArcHeightUpDown ,
                                            Color.magenta ,
                                            PLAYER2);

        try {
            backGround = ImageIO.read(new File("images/background.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// *************************************************************

// Methods
    
    /**
     * Notifies this component that it now has a parent component.
     * When this method is invoked, the chain of parent components is
     * set up with <code>KeyboardAction</code> event listeners.
     * This method is called by the toolkit internally and should
     * not be called directly by programs.
     * Create a thread for this object and start it.
     *
     * @see #registerKeyboardAction
     */
    public void addNotify(){
        
        super.addNotify();
        
        animatorThread = new Thread(this);
        animatorThread.start();
    }
    
    /**
     * Returns the Ball object which we created in this class
     * @return 
     */
    public Shape getBall(){
        
        return ball;
    }
    
    /**
     * Returns JFrame which this Board is added to it
     * @return 
     */
    public JFrame getFrame(){
        return frame;
    }
    
    /**
     * Returns rocket of player1 which moves to left and right
     * @return 
     */
    public Shape getRocketLeftRightPlayer1(){
        
        return rocketLeftRightPlayer1;
    }
    
    /**
     * Returns rocket of player2 which moves to left and right
     * @return 
     */
    public Shape getRocketLeftRightPlayer2(){
        
        return rocketLeftRightPlayer2;
    }
    
    /**
     * Returns rocket of player1 which moves to up and down
     * @return 
     */
    public Shape getRocketUpDownPlayer1(){
        
        return rocketUpDownPlayer1;
    }
    
    /**
     * Returns rocket of player2 which moves to up and down
     * @return 
     */
    public Shape getRocketUpDownPlayer2(){
        
        return rocketUpDownPlayer2;
    }
    
    /**
     * Returns margin of height of both left_right rockets of player1 & player2 from both sides of frame
     * @return 
     */
    public int getRocketHeightMarginLeftRight(){
        
        return rocketHeightMarginLeftRight;
    }
    
    /**
     * Returns margin of height of both up_down rockets of player1 & player2 from both sides of frame
     * @return 
     */
    public int getRocketHeightMarginUpDown(){
        
        return rocketHeightMarginUpDown;
    }
    
    /**
     * Returns margin of width of both left_right rockets of player1 & player2 from both sides of frame
     * @return 
     */
    public int getRocketWidthMarginLeftRight(){
        
        return rocketWidthMarginLeftRight;
    }
    
    /**
     * Returns margin of width of both up_down rockets of player1 & player2 from both sides of frame
     * @return 
     */
    public int getRocketWidthMarginUpDown(){
        
        return rocketWidthMarginUpDown;
    }
    
    /**
     * Invoke keyPressed method of all of classes.
     * @param keyEvent 
     */
    public void keyPressed(KeyEvent keyEvent){
        
        ((RocketUpDown)rocketUpDownPlayer1).keyPressed(keyEvent);
        ((RocketUpDown)rocketUpDownPlayer2).keyPressed(keyEvent);
        
        ((RocketLeftRight)rocketLeftRightPlayer1).keyPressed(keyEvent);
        ((RocketLeftRight)rocketLeftRightPlayer2).keyPressed(keyEvent);
    }
    
    /**
     * Invoke keyReleased method of all of classes
     * @param keyEvent 
     */
    public void keyReleased(KeyEvent keyEvent){
        
        ((RocketUpDown)rocketUpDownPlayer1).keyReleased(keyEvent);
        ((RocketUpDown)rocketUpDownPlayer2).keyReleased(keyEvent);
        
        ((RocketLeftRight)rocketLeftRightPlayer1).keyReleased(keyEvent);
        ((RocketLeftRight)rocketLeftRightPlayer2).keyReleased(keyEvent);
    }
    
    /**
     * I just had to implement it because I did not want to use KeyAdapter! ;)
     * @param keyEvent 
     */
    public void keyTyped(KeyEvent keyEvent){}
    
    /**
     * Invoke move() method of all of the shapes and calculateScoreLevel(int playerNumber) method of players
     */
    public void move(){
        
        ball.move();
        
        rocketUpDownPlayer1.move();
        rocketUpDownPlayer2.move();
        
        rocketLeftRightPlayer1.move();
        rocketLeftRightPlayer2.move();
        
        player1.calculateScoreLevel(PLAYER1);
        player2.calculateScoreLevel(PLAYER2);
    }

    /**
     * It puts an image as background of this JPanel.
     * It draws all of shapes and players which we created in constructor.
     * @param g
     */
    public void paint(Graphics g){

        super.paint(g);

        g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(backGround,
                        0, 0 ,
                        null);

        ball.paint(g);     
        
        rocketUpDownPlayer1.paint(g);
        rocketUpDownPlayer2.paint(g);
        
        rocketLeftRightPlayer1.paint(g);
        rocketLeftRightPlayer2.paint(g);
        
        player1.paint(g);
        player2.paint(g);
    }
    
    /**
     * Starting the thread causes the board's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * Invokes repaint() and move() methods which causes changed position of shape on board and update the page.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see     java.lang.Thread#run()
     */
    public void run(){
        
        while(true){
            repaint();
            move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * sets margin of height of both left_right rockets of player1 & player2 from both sides of frame
     * @param rocketHeightMarginLeftRight 
     */
    public void setRocketHeightMarginLeftRight(int rocketHeightMarginLeftRight){
        
        this.rocketHeightMarginLeftRight = rocketHeightMarginLeftRight;
    }
    
    /**
     * sets margin of height of both up_down rockets of player1 & player2 from both sides of frame
     * @param rocketHeightMarginUpDown 
     */
    public void setRocketHeightMarginUpDown(int rocketHeightMarginUpDown){
        
        this.rocketHeightMarginUpDown = rocketHeightMarginUpDown;
    }    
    
    /**
     * sets margin of width of both left_right rockets of player1 & player2 from both sides of frame
     * @param rocketWidthMarginLeftRight 
     */
    public void setRocketWidthMarginLeftRight(int rocketWidthMarginLeftRight){
        
        this.rocketWidthMarginLeftRight = rocketWidthMarginLeftRight;
    }
    
    /**
     * sets margin of width of both up_down rockets of player1 & player2 from both sides of frame
     * @param rocketWidthMarginUpDown 
     */
    public void setRocketWidthMarginUpDown(int rocketWidthMarginUpDown){
        
        this.rocketWidthMarginUpDown = rocketWidthMarginUpDown;
    }
}