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
package gui;

import helium3.Grid;
import helium3.Location;
import helium3.Player;
import helium3.Vehicle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Matt
 */
public class NewFrame extends JFrame{
    
    private Image dbImage;
    private Graphics dbg;
    private Image back;
    private Image gtank;
    private Image rtank;
    private Image ptank;
    private Image ytank;
    private boolean isRunningHappeningNow;
    private Image mis;
    private Grid gr;
    private Image gshield;
    private Image rshield;
    private Image pshield;
    private Image yshield;
    private Image gdrill;
    private Image rdrill;
    private Image ydrill;
    private Image pdrill;
    private Image ylaz;
    private Image rlaz;
    private Image plaz;
    private Image glaz;
    
    public NewFrame(){
        
        try{
        back = ImageIO.read(this.getClass().getResource("/resources/Moon Grid.png"));
        gtank = ImageIO.read(this.getClass().getResource("/resources/GreenTank.png"));
        rtank = ImageIO.read(this.getClass().getResource("/resources/RedTank.png"));
        ptank = ImageIO.read(this.getClass().getResource("/resources/PrplTank.png"));
        ytank = ImageIO.read(this.getClass().getResource("/resources/YeloTank.png"));
        gshield = ImageIO.read(this.getClass().getResource("/resources/shieldGreen.png"));
        rshield = ImageIO.read(this.getClass().getResource("/resources/shieldRed.png"));
        pshield = ImageIO.read(this.getClass().getResource("/resources/shieldPrpl.png"));
        yshield = ImageIO.read(this.getClass().getResource("/resources/shieldYelo.png"));
        gdrill = ImageIO.read(this.getClass().getResource("/resources/TankGreenDrill.png"));
        rdrill = ImageIO.read(this.getClass().getResource("/resources/TankRedDrill.png"));
        pdrill = ImageIO.read(this.getClass().getResource("/resources/TankPrplDrill.png"));
        ydrill = ImageIO.read(this.getClass().getResource("/resources/TankYeloDrill.png"));
        ylaz = ImageIO.read(this.getClass().getResource("/resources/YeloLazer.png"));
        rlaz = ImageIO.read(this.getClass().getResource("/resources/RedLazer.png"));
        plaz = ImageIO.read(this.getClass().getResource("/resources/PrplLazer.png"));
        glaz = ImageIO.read(this.getClass().getResource("/resources/GreenLazer.png"));
        mis = ImageIO.read(this.getClass().getResource("/resources/missile.png"));
        }catch(Exception e){System.out.println("could not find image");}
    }
    
    @Override
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 3, 25, this);
    }
    public void paintComponent(Graphics g){
        
        g.drawImage(back, 0, 0, this);
        g.drawImage(gtank, 50, 50, this);
        g.drawImage(gtank, 214, 345, this);
    }
    
    
    
    public void makeRunHappen(ArrayList<Player> a)
    {
        gr = new Grid(20, 20);
        if (a.size() >= 1) {
            gr.getCell(new Location(0, 2)).setVehicle(a.get(0).getVehicleList().get(0));
            gr.getCell(new Location(1, 2)).setVehicle(a.get(0).getVehicleList().get(1));
            gr.getCell(new Location(2, 2)).setVehicle(a.get(0).getVehicleList().get(2));
            gr.getCell(new Location(0, 2)).setVehicle(a.get(0).getVehicleList().get(0));
            gr.getCell(new Location(0, 2)).setVehicle(a.get(0).getVehicleList().get(0));
        }
        
       while(isRunningHappeningNow) 
       {
           
           
           
           try{
               Thread.sleep(100);
           }catch(Exception e){}
           repaint();
       }
    }
    
    
    public int locToPixX(int x)
    {
        return (x*35)+6;
    }
    
    public int locToPixY(int y)
    {
        return (y*35)+28;
    }
    
    class click implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            int y = e.getY();
            int cellX = x/35;
            int cellY = y/35;
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
