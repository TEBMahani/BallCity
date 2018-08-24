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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author TEBMahani(Tayebeh Esmaeili Beigi Mahani)
 *
 * The <code>Board</code> class is a subclass of JPanel which is used to encapsulate a JPanel with shapes which draws on it.
 *
 * Constructor Summary:
 * Board()
 * Board(JFrame frame)
 *
 * Method Summary:
 * paint(Graphics g)
 */
public class Board
                    extends JPanel{

// Static Final Values

// *************************************************************

// Static Variables

// *************************************************************

// Final Fields

// *************************************************************

// Fields

    protected BufferedImage
                            backGround;
    protected Graphics2D
                        g2;
    protected JFrame
                    frame;

    private Shape
                    borderOval ,

                    border3DRectangle ,
                    borderRectangle ,
                    borderRoundRectangle ,

                    oval ,

                    rect3D ,
                    rectangle ,
                    roundRect;

// *************************************************************

// Constructors

    /**
     * Constructs a new <code>Board</code> object.
     */
    public Board(){}

    /**
     * Constructs a new <code>Board</code> object.
     * It creates these objects and paints them on this JPanel:
     *  borderOval
     *
     *  border3DRectangle ,
     *  borderRectangle ,
     *  borderRoundRectangle ,
     *
     *  oval ,
     *
     *  rect3D ,
     *  rectangle ,
     *  roundRect
     * @param frame
     */
    public Board(JFrame frame){

        this.frame = frame;

        int
                rectangleArcHeight = 20 ,
                rectangleArcWidth = 10 ,
                rectangleHeight = 50 ,
                rectangleWidth = 30;
        int
                ovalHeight = 50 ,
                ovalWidth = 30;

// Creates Colored-Border Ovals

        // Creates a red border-colored circle with ovalWidth as its dim
                                            // under pink full-colored oval.
        borderOval = new Oval(this ,
                                0 , ovalHeight , ovalWidth , ovalWidth ,
                                Color.red ,
                                true);

// Creates Colored-Border Rectangles

        // Creates a darkGreen border_colored 3DRectangle with rectangleWidth as its width
                                                        // and rectangleHeight as its height
                                                        // which sits on green full-colored rectangle.
        border3DRectangle = new Rectangle(this ,
                                            0 , frame.getHeight()-(3*rectangleHeight)-3 , rectangleWidth , rectangleHeight ,
                                            true ,
                                            Color.green.darker() ,
                                            true);
        // Creates a red boarder-color rectangle with rectangleWidth+1 as its width (+1 is to be greater than its contained rectangle)
                                               // and rectangleHeight+1 as its height (+1 is to be greater than its contained rectangle)
                                               //in last left-down of frame
                                               // which contains cyan full-colored rectangle.
        borderRectangle = new Rectangle(this ,
                                        0 , frame.getHeight()-rectangleHeight-2 , rectangleWidth+1 , rectangleHeight+1 ,
                                        Color.red ,
                                        true);
        // Creates a white border-color roundRectangle with rectangleWidth as its width
                                                     // and rectangleHeight as its height
                                                     // which sits on white full-colored roundRectangle.
        borderRoundRectangle = new Rectangle(this ,
                                            frame.getWidth()-rectangleWidth , frame.getHeight()-(2*rectangleHeight) , rectangleWidth , rectangleHeight ,
                                            rectangleArcWidth , rectangleArcHeight ,
                                            Color.white ,
                                            true);

//Creates Full-Colored Oval

        //Creates a pink full-colored oval with ovalWidth as its width,
                                    // and ovalHeight as its height
                                    // which sits on first right-top of frame.
        oval = new Oval(this ,
                        0 , 0 , ovalWidth , ovalHeight ,
                        Color.pink);

// Creates Full-Colored Rectangles

        //Creates a green full-colored 3DRectangle with rectangleWidth as its width
                                                 // and rectangleHeight as its height
                                                 // which sits on cyan full-colored rectangle.
        rect3D = new Rectangle(this ,
                                0 , frame.getHeight()-(2*rectangleHeight)-2 , rectangleWidth , rectangleHeight ,
                                true ,
                                Color.green);
        // Creates a cyan full-colored rectangle with rectangleWidth as its width
                                               // and rectangleHeight as its height
                                               // which sits into red boarder-color rectangle.
        rectangle = new Rectangle(this ,
                                    0+1 , frame.getHeight()-rectangleHeight-1 , rectangleWidth , rectangleHeight ,
                                    Color.cyan);
        //Creates a white full-colored roundRectangle with rectangleWidth as its width
                                                    // and rectangleHeight as its height
                                                    // which sits in last right-down of frame.
        roundRect = new Rectangle(this ,
                                    frame.getWidth()-rectangleWidth , frame.getHeight()-rectangleHeight-1 , rectangleWidth , rectangleHeight ,
                                    rectangleArcWidth , rectangleArcHeight ,
                                    Color.white);

        try {
            backGround = ImageIO.read(new File("images/background.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// *************************************************************

// Methods

    /**
     * It puts an image as background of this JPanel.
     * It draws all of shapes which we created in constructor.
     * @param g
     */
    public void paint(Graphics g){

        super.paint(g);

        g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(backGround,
                        0, 0 ,
                        null);

        borderOval.paint(g);

        border3DRectangle.paint(g);
        borderRectangle.paint(g);
        borderRoundRectangle.paint(g);

        oval.paint(g);

        rect3D.paint(g);
        rectangle.paint(g);
        roundRect.paint(g);
    }
}