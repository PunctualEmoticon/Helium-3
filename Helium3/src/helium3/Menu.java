/*
 The MIT License (MIT)

 Copyright (c) 2014 David Hasegawa, Matthew Speck, Francisco Eduardo Cepeda
 Aguilar

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package helium3;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author Matt
 */
public class Menu 
{
    JFrame mainMenu;
    JPanel pane;
    // Makes a new menu
    public Menu()
    {
    }
    
    //Method that acts.
    public void go()
    {
        // New Window
        mainMenu = new JFrame();
        pane = new JPanel();
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
        DrawBack draw = new DrawBack();
        pane.setBackground(new Color(0,0,0,0));
        
        
        //button creation
        JButton start = new JButton("New Game");
        start.addActionListener(new newGameListener());
        JButton quit = new JButton("Quit Game");
        //quit.addActionListener(new quitGameListener());
        pane.add(start);
        pane.add(quit);
        //Settiing buttons to be on frame
        mainMenu.getContentPane().add(BorderLayout.WEST, pane);
        mainMenu.getContentPane().add(draw);
        mainMenu.setSize(500,500);
        mainMenu.setVisible(true);
        draw.repaint();       
    }
    //draws backround
    class DrawBack extends JPanel
    {
        @Override
        public void paint(Graphics g)
        {
            Image back = new ImageIcon("C:\\images\\back.jpg").getImage();
            g.drawImage(back,0,0,this);
        }
    }
    //starts new game process
    class newGameListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            pane.setVisible(false);
        }
        
    }
    //exits app
    class exitGameListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
           
        }
    }
}
