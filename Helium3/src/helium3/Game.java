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

import gui.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


/**
 *
 * @author Matt
 */
public class Game 
{
    private ArrayList<Player> players;
    private Graphic g;
    private Grid gr;
    NewFrame frame;
    
    public Game(ArrayList<String> a)
    {
        players  = new ArrayList<>();
        for(int i = 0; i< a.size(); i++)
        {
            Player player = new Player(a.get(i));
            players.add(player);
        }
    }
    
    public void newGame()
    {
        //code for david to doooooooo
        frame = new NewFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g=new Graphic(frame , players);
        g.newGameGraphics();
    }
    
    
    
    
    
    
    
    
    
    
    class click implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            int y = e.getY();
            int cellX = (x-6)/50;
            int cellY = (y-28)/50;
            Location loc = new Location(cellX,cellY);
            if(gr.getCell(loc).isOccupied())
            {
                Vehicle ve = gr.getCell(loc).getVehicle();
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) 
        {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) 
        {
            
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {
            
        }
        
    }
}
