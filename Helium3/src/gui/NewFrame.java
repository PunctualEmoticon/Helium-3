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
import java.awt.event.MouseAdapter;
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
    
    NewFrame frame;
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
    private Image sel;
    private Image gmis;
    private Image rmis;
    private Image ymis;
    private Image pmis;
    int turn;
    int currentPlayer;
    private ArrayList<Player> arr;
    
    public NewFrame(){
        
        try{
        back = ImageIO.read(this.getClass().getResource("/resources/Moon Grid.png"));
        gtank = ImageIO.read(this.getClass().getResource("/resources/GreenTank.png"));
        rtank = ImageIO.read(this.getClass().getResource("/resources/RedTank.png"));
        ptank = ImageIO.read(this.getClass().getResource("/resources/PrplTank.png"));
        ytank = ImageIO.read(this.getClass().getResource("/resources/YeloTank.png"));
        gshield = ImageIO.read(this.getClass().getResource("/resources/GreenShield.png"));
        rshield = ImageIO.read(this.getClass().getResource("/resources/RedShield.png"));
        pshield = ImageIO.read(this.getClass().getResource("/resources/PrplShield.png"));
        yshield = ImageIO.read(this.getClass().getResource("/resources/YeloShield.png"));
        gdrill = ImageIO.read(this.getClass().getResource("/resources/TankGreenDrill.png"));
        rdrill = ImageIO.read(this.getClass().getResource("/resources/TankRedDrill.png"));
        pdrill = ImageIO.read(this.getClass().getResource("/resources/TankPrplDrill.png"));
        ydrill = ImageIO.read(this.getClass().getResource("/resources/TankYeloDrill.png"));
        ylaz = ImageIO.read(this.getClass().getResource("/resources/YeloLazer.png"));
        rlaz = ImageIO.read(this.getClass().getResource("/resources/RedLazer.png"));
        plaz = ImageIO.read(this.getClass().getResource("/resources/PrplLazer.png"));
        glaz = ImageIO.read(this.getClass().getResource("/resources/GreenLazer.png"));
        gmis = ImageIO.read(this.getClass().getResource("/resources/GreenMissile.png"));
        rmis = ImageIO.read(this.getClass().getResource("/resources/RedMissile.png"));
        ymis = ImageIO.read(this.getClass().getResource("/resources/YeloMissile.png"));
        pmis = ImageIO.read(this.getClass().getResource("/resources/PrplMissile.png"));
        mis = ImageIO.read(this.getClass().getResource("/resources/missile.png"));
        sel = ImageIO.read(this.getClass().getResource("/resources/select.png"));
        }catch(Exception e){System.out.println("could not find image");}
    }
    
    @Override
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 3, 25, this);
        //System.out.println(gr);  //For diagnostics, can be removed
    }
    public void paintComponent(Graphics g){
        
        g.drawImage(back, 0, 0, this);
        
        
        for(int r = 0; r < gr.getNumRows();r++)
        {
            for(int c = 0; c < gr.getNumCols(); c++)
            {
                Location loc = new Location(r,c);
                if(gr.getCell(loc).getBoundedHelium3Amount()>1)
                {
                    g.setColor(Color.black);
                    g.drawRect(locToPixX(r), locToPixY(c), 35, 35);
                    g.setColor(new Color(0,0,gr.getCell(loc).getBoundedHelium3Amount()/5,125));
                    g.fillRect(locToPixX(r)+1, locToPixY(c)+1,33, 33);
                }
                
                if(gr.getCell(loc).isOccupied())
                {
                    if(gr.getCell(loc).getVehicle().getPlayer()== arr.get(0))
                    {
                        if(gr.getCell(loc).getVehicle().getLaser().isArmed())
                        {
                            g.drawImage(glaz,locToPixX(r),locToPixY(c), this);
                        }
                        else if(gr.getCell(loc).getVehicle().getMissile().isArmed())
                        {
                            g.drawImage(gmis,locToPixX(r),locToPixY(c), this);
                        }
                        else if(gr.getCell(loc).getVehicle().getShield().isArmed())
                        {
                            g.drawImage(gshield,locToPixX(r),locToPixY(c), this);
                        }
                        else
                        {
                            g.drawImage(gtank,locToPixX(r),locToPixY(c), this);   
                        }
                        if(gr.getCell(loc).getVehicle().isSelected)
                        {
                            g.drawImage(sel, locToPixX(r), locToPixY(c), this);
                        }
                        if(gr.getCell(loc).getVehicle().isMoving)
                        {
                            g.setColor(Color.red);
                            for(int i = 0; i <gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).size(); i++)
                            {
                                g.drawRect(locToPixX(gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).get(i).getX())+2,
                                        locToPixY(gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).get(i).getY()) +2, 34, 34);
                            }
                        }
                        if(gr.getCell(loc).getVehicle().missileTime)
                        {
                            g.setColor(Color.red);
                            for(int i = 0; i <gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).size(); i++)
                            {
                                g.drawRect(locToPixX(gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).get(i).getX())+2,
                                        locToPixY(gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).get(i).getY()) +2, 34, 34);
                            }
                        }
                    }
                    else if(gr.getCell(loc).getVehicle().getPlayer()== arr.get(1))
                    {
                        if(gr.getCell(loc).getVehicle().getLaser().isArmed())
                        {
                            g.drawImage(ylaz,locToPixX(r),locToPixY(c), this);
                        }
                        else if(gr.getCell(loc).getVehicle().getMissile().isArmed())
                            
                        {
                            g.drawImage(ymis,locToPixX(r),locToPixY(c), this);
                        }
                         else if(gr.getCell(loc).getVehicle().getShield().isArmed())
                        {
                            g.drawImage(yshield,locToPixX(r),locToPixY(c), this);
                        }
                        else
                        {
                            g.drawImage(ytank,locToPixX(r),locToPixY(c), this);   
                        }
                        if(gr.getCell(loc).getVehicle().isSelected)
                        {
                            g.drawImage(sel, locToPixX(r), locToPixY(c), this);
                        }
                      
                        if(gr.getCell(loc).getVehicle().isMoving)
                        {
                            g.setColor(Color.red);
                            for(int i = 0; i <gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).size(); i++)
                            {
                                g.drawRect(locToPixX(gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).get(i).getX())+2,
                                        locToPixY(gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).get(i).getY()) +2, 34, 34);
                            }
                        }
                        if(gr.getCell(loc).getVehicle().missileTime)
                        {
                            g.setColor(Color.red);
                            for(int i = 0; i <gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).size(); i++)
                            {
                                g.drawRect(locToPixX(gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).get(i).getX())+2,
                                        locToPixY(gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).get(i).getY()) +2, 34, 34);
                            }
                        }
                        
                    }
                    else if(gr.getCell(loc).getVehicle().getPlayer()== arr.get(2))
                    {
                        if(gr.getCell(loc).getVehicle().getLaser().isArmed())
                        {
                            g.drawImage(plaz,locToPixX(r),locToPixY(c), this);
                        }
                        else if(gr.getCell(loc).getVehicle().getMissile().isArmed())
                        {
                            g.drawImage(pmis,locToPixX(r),locToPixY(c), this);
                        }
                         else if(gr.getCell(loc).getVehicle().getShield().isArmed())
                        {
                            g.drawImage(pshield,locToPixX(r),locToPixY(c), this);
                        }
                        else
                        {
                            g.drawImage(ptank,locToPixX(r),locToPixY(c), this);   
                        }
                        if(gr.getCell(loc).getVehicle().isSelected)
                        {
                            g.drawImage(sel, locToPixX(r), locToPixY(c), this);
                        }
                        if(gr.getCell(loc).getVehicle().isMoving)
                        {
                            g.setColor(Color.red);
                            for(int i = 0; i <gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).size(); i++)
                            {
                                g.drawRect(locToPixX(gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).get(i).getX())+2,
                                        locToPixY(gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).get(i).getY()) +2, 34, 34);
                            }
                        }
                        if(gr.getCell(loc).getVehicle().missileTime)
                        {
                            g.setColor(Color.red);
                            for(int i = 0; i <gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).size(); i++)
                            {
                                g.drawRect(locToPixX(gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).get(i).getX())+2,
                                        locToPixY(gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).get(i).getY()) +2, 34, 34);
                            }
                        }
                    }
                    else
                    {
                        if(gr.getCell(loc).getVehicle().getLaser().isArmed())
                        {
                            g.drawImage(rlaz,locToPixX(r),locToPixY(c), this);
                        }
                        else if(gr.getCell(loc).getVehicle().getMissile().isArmed())
                        {
                            g.drawImage(rmis,locToPixX(r),locToPixY(c), this);
                        }
                         else if(gr.getCell(loc).getVehicle().getShield().isArmed())
                        {
                            g.drawImage(rshield,locToPixX(r),locToPixY(c), this);
                        }
                        else
                        {
                            g.drawImage(rtank,locToPixX(r),locToPixY(c), this);   
                        }
                        if(gr.getCell(loc).getVehicle().isSelected)
                        {
                            g.drawImage(sel, locToPixX(r), locToPixY(c), this);
                        }
                        if(gr.getCell(loc).getVehicle().isMoving)
                        {
                            g.setColor(Color.red);
                            for(int i = 0; i <gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).size(); i++)
                            {
                                g.drawRect(locToPixX(gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).get(i).getX())+2,
                                        locToPixY(gr.getCell(loc).getVehicle().getMoveLocations(gr, loc).get(i).getY()) +2, 34, 34);
                            }
                        }
                        if(gr.getCell(loc).getVehicle().missileTime)
                        {
                            g.setColor(Color.red);
                            for(int i = 0; i <gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).size(); i++)
                            {
                                g.drawRect(locToPixX(gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).get(i).getX())+2,
                                        locToPixY(gr.getCell(loc).getVehicle().getMissile().getPossibleTargets(gr, loc).get(i).getY()) +2, 34, 34);
                            }
                        }
                    }
                }
            }
        }
    }
    
    
    
    public void makeRunHappen(ArrayList<Player> a, NewFrame b)
    {
        frame = b;
        isRunningHappeningNow= true;
        gr = new Grid(20, 20);
        arr = a;
        int turnCounter = 0;
        turn=1;
        currentPlayer=0;
                
        if(arr.size()==2)
        {
            JOptionPane.showMessageDialog(null ,arr.get(0).getName() + " is Green \n"
            + arr.get(1).getName() + " is Yellow");
            
        }
        if(arr.size()== 3)
        {
            JOptionPane.showMessageDialog(null ,arr.get(0).getName() + " is Green \n"
            + arr.get(1).getName() + " is Yellow \n" + arr.get(2).getName() + " is Purple");
        }
        if(arr.size() == 4)
        {
            JOptionPane.showMessageDialog(null ,arr.get(0).getName() + " is Green \n"
            + arr.get(1).getName() + " is Yellow \n" + arr.get(2).getName() + " is Purple \n" 
            + arr.get(3).getName() + " is Red");
        }
        
        //Set Players' Vehicle positions.
        if (a.size() >= 1) {
            //First Player is in the top left
            gr.getCell(new Location(0, 2)).setVehicle(a.get(0).getVehicleList().get(0));
            gr.getCell(new Location(1, 2)).setVehicle(a.get(0).getVehicleList().get(1));
            gr.getCell(new Location(2, 2)).setVehicle(a.get(0).getVehicleList().get(2));
            gr.getCell(new Location(2, 1)).setVehicle(a.get(0).getVehicleList().get(3));
            gr.getCell(new Location(2, 0)).setVehicle(a.get(0).getVehicleList().get(4));
        }
        if (a.size() >= 2) {
            //Second Player is in the bottom right
            gr.getCell(new Location(gr.getNumCols() - 1, gr.getNumRows() - 3)).setVehicle(a.get(1).getVehicleList().get(0));
            gr.getCell(new Location(gr.getNumCols() - 2, gr.getNumRows() - 3)).setVehicle(a.get(1).getVehicleList().get(1));
            gr.getCell(new Location(gr.getNumCols() - 3, gr.getNumRows() - 3)).setVehicle(a.get(1).getVehicleList().get(2));
            gr.getCell(new Location(gr.getNumCols() - 3, gr.getNumRows() - 2)).setVehicle(a.get(1).getVehicleList().get(3));
            gr.getCell(new Location(gr.getNumCols() - 3, gr.getNumRows() - 1)).setVehicle(a.get(1).getVehicleList().get(4));
        }
        if (a.size() >= 3) {
            //Third Player is in the top right
            gr.getCell(new Location(gr.getNumCols() - 1, 2)).setVehicle(a.get(2).getVehicleList().get(0));
            gr.getCell(new Location(gr.getNumCols() - 2, 2)).setVehicle(a.get(2).getVehicleList().get(1));
            gr.getCell(new Location(gr.getNumCols() - 3, 2)).setVehicle(a.get(2).getVehicleList().get(2));
            gr.getCell(new Location(gr.getNumCols() - 3, 1)).setVehicle(a.get(2).getVehicleList().get(3));
            gr.getCell(new Location(gr.getNumCols() - 3, 0)).setVehicle(a.get(2).getVehicleList().get(4));
        }
        if (a.size() >= 4) {
            //Fourth Player is in the bottom left
            gr.getCell(new Location(0, gr.getNumRows() - 3)).setVehicle(a.get(3).getVehicleList().get(0));
            gr.getCell(new Location(1, gr.getNumRows() - 3)).setVehicle(a.get(3).getVehicleList().get(1));
            gr.getCell(new Location(2, gr.getNumRows() - 3)).setVehicle(a.get(3).getVehicleList().get(2));
            gr.getCell(new Location(2, gr.getNumRows() - 2)).setVehicle(a.get(3).getVehicleList().get(3));
            gr.getCell(new Location(2, gr.getNumRows() - 1)).setVehicle(a.get(3).getVehicleList().get(4));
        }
        this.addMouseListener(new click());
       /*while(isRunningHappeningNow) 
       {
           
           this.addMouseListener(new click());              //gave up on this game loop,looks like its up to players
        
           for(int i = 0; i < 21;i++)
           {
               for(int j = 0; j < arr.size(); j++)
               {
                   for(int k = 0; k < arr.get(j).getVehicleList().size();k++)
                   {
                       
                   }
               }
           }
           isRunningHappeningNow = false;
           try{
               Thread.sleep(100);
           }catch(Exception e){}
           this.repaint();
       }*/
    }
    
    
    public int locToPixX(int x)
    {
        return (x*35);
    }
    
    public int locToPixY(int y)
    {
        return (y*35);
    }
    
    class click extends MouseAdapter
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {
         
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            int x = e.getX();
            int y = e.getY();
            int cellX = x/35;
            int cellY = (y-20)/35;
            System.out.println(cellX + " " + cellY);
            Location loc = new Location(cellX,cellY);
            if(gr.getCell(loc).isOccupied())
            {
                Vehicle vehicle = gr.getCell(loc).getVehicle();
                turn++;
                vehicle.isSelected=true;
                    //vehicle.hasPerformedAction = true;
                GameActions act = new GameActions(vehicle,gr, frame);
                act.gameMenu();
                repaint();
                    
                    
                
            }
              
        }

        @Override
        public void mouseReleased(MouseEvent e) 
        {
            return;
        }

        @Override
        public void mouseEntered(MouseEvent e) 
        {
            return;
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {
           return; 
        }
    }
}
