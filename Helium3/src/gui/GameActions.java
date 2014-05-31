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

import helium3.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
/**
 *
 * @author Matt
 */
public class GameActions 
{
    Vehicle veh;
    Grid gr;
    JFrame frame;
    NewFrame game1;
    
    public GameActions(Vehicle v, Grid g, NewFrame game)
    {
        veh = v;
        gr = g;
        game1 = game;
    }
    
    public void gameMenu()
    {
        JLabel jLabel1 = new javax.swing.JLabel();
        JButton jButton1 = new javax.swing.JButton();
        JButton jButton2 = new javax.swing.JButton();
        JButton jButton3 = new javax.swing.JButton();
        JButton jButton4 = new javax.swing.JButton();
        JButton jButton5 = new javax.swing.JButton();
        JButton jButton6 = new javax.swing.JButton();
        frame = new JFrame("In Game Menu");
        frame.setSize(500,500);

        

        jLabel1.setText("Select your action");

        jButton1.setText("Move");
        jButton1.addActionListener(new move());

        jButton2.setText("Mine");
        jButton2.addActionListener(new mine());
        jButton3.setText("Arm Sheild");
        jButton3.addActionListener(new sheild());
        jButton4.setText("Arm Missile");
        jButton4.addActionListener(new misArm());
        if(veh.getMissile().isArmed())
        {
            jButton4.setText("Fire Missle");
            jButton4.addActionListener(new misFire());
        }
        jButton5.setText("Arm Lazer");
        jButton5.addActionListener(new lazArm());
        if(veh.getLaser().isArmed())
        {
            jButton5.setText("Fire Laser");
            jButton5.addActionListener(new lazFire());
        }
        jButton6.setText("Kamikaze");
        jButton6.addActionListener(new kamakazi());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        frame.setVisible(true);
    }
     
    class misArm implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            veh.getMissile().arm();
            frame.setVisible(false);
            veh.isSelected = false;
            game1.repaint();
        }
        
    }
    class misFire implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo
            
            frame.setVisible(false);
            veh.isSelected = false;
            game1.repaint();
        }
        
    }
    class move implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo
            veh.isMoving = true;
            game1.repaint();
            //gr.moveVehicle(getLoc(), new Location(5,5));
            frame.setVisible(false);
            game1.addMouseListener(new clickMove());
            //veh.isSelected = false;
            
            game1.repaint();
        }
        
    }
    class lazArm implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            veh.getLaser().arm();
            frame.setVisible(false);
            veh.isSelected = false;
            game1.repaint();
        }
        
    }
    class lazFire implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            veh.getLaser().attack(gr, getLoc(), Integer.parseInt(JOptionPane.showInputDialog("Enter a direction. \n N = 0 \n NE = 45 \n ect.")));
            frame.setVisible(false);
            veh.isSelected = false;
            game1.repaint();
            //todo
        }
        
    }
    class kamakazi implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            veh.getKamikaze().attack(gr, getLoc());
            frame.setVisible(false);
            veh.isSelected = false;
            game1.repaint();
        }
        
    }
    class mine implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            veh.getDrill().mine(gr, getLoc());
            frame.setVisible(false);
            veh.isSelected = false;
            game1.repaint();
        }
        
    }
    class sheild implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            veh.getShield().arm();
            frame.setVisible(false);
            veh.isSelected = false;
            game1.repaint();
        }
        
    }
    
    public Location getLoc()
    {
        for(int i = 0; i < gr.getNumRows(); i++)
        {
            
            for(int j = 0; j< gr.getNumCols(); j++)
            {
                Location loc = new Location(i,j);
                if(gr.getCell(loc).isOccupied())
                {
                    if(gr.getCell(loc).getVehicle()==veh)
                    {
                        return loc;
                    }
                }
            }
        } 
        return null;
    }
    class clickMove extends MouseAdapter
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
            if(!gr.getCell(loc).isOccupied())
            {
                gr.moveVehicle(getLoc(), loc);
                veh.isMoving = false;
                veh.isSelected = false;
                game1.repaint();
                game1.removeMouseListener(this);
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
     
    class clickMis extends MouseAdapter
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {
         
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            veh.missileTime = true;
            game1.repaint();
            int x = e.getX();
            int y = e.getY();
            int cellX = x/35;
            int cellY = (y-20)/35;
            System.out.println(cellX + " " + cellY);
            Location loc = new Location(cellX,cellY);
            if(gr.getCell(loc).isOccupied())
            {
                for(int i = 0; i < veh.getMissile().getPossibleTargets(gr, loc).size(); i++)
                {
                    if(veh.getMissile().getPossibleTargets(gr, loc).get(i) == loc)
                    {
                        veh.getMissile().attack(gr, loc);
                        game1.repaint();
                        game1.removeMouseListener(this);
                        veh.missileTime = false;
                        game1.repaint();
                    }
                }
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
