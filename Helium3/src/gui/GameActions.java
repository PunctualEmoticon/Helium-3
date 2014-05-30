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
    
    public GameActions(Vehicle v, Grid g)
    {
        veh = v;
        gr = g;
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
        }
        
    }
    class misFire implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo
            frame.setVisible(false);
        }
        
    }
    class move implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo
            frame.setVisible(false);
        }
        
    }
    class lazArm implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            veh.getLaser().arm();
            frame.setVisible(false);
        }
        
    }
    class lazFire implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            //todo
        }
        
    }
    class kamakazi implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            veh.getKamikaze().attack(gr, getLoc());
            frame.setVisible(false);
        }
        
    }
    class mine implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            veh.getDrill().mine(gr, getLoc());
            frame.setVisible(false);
        }
        
    }
    class sheild implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            veh.getShield().arm();
            frame.setVisible(false);
        }
        
    }
    
    public Location getLoc()
    {
        for(int i = 0; i < gr.getNumRows(); i++)
        {
            int x, y;
            for(int j = 0; j< gr.getNumCols(); j++)
            {
                Location loc = new Location(i,j);
                if(gr.getCell(loc).isOccupied())
                {
                    if(gr.getCell(loc).getVehicle().equals(veh))
                    {
                        return loc;
                    }
                }
            }
        } 
        return null;
    }
        
    
}
