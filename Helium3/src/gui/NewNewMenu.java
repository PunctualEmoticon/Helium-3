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

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import helium3.*;    //Probably unneccessary or too broad, fix as needed

/**
 *
 * @author Matt
 */
public class NewNewMenu
{

    JFrame mainMenu;
    JPanel pane;
    JButton start;
    JButton quit;
    JButton player4;

    // Makes a new menu

    public NewNewMenu()
    {
    }

    //Method that acts.
    public void go()
    {
       java.awt.GridBagConstraints gridBagConstraints;
        mainMenu = new JFrame();
        pane = new javax.swing.JPanel();
        start = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();

        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.getContentPane().setLayout(new java.awt.GridBagLayout());

        pane.setOpaque(false);

        start.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        start.setText("New Game");
        start.addActionListener(new newGameListener());
          

        quit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quit.setText("Quit Game");
        quit.addActionListener(new exitGameListener());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 0, 0));
        jLabel1.setText("Main Menu");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 0, 0));
        jLabel3.setText("David Hasagawa");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 0, 0));
        jLabel4.setText("Matthew Speck");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 0, 0));
        jLabel5.setText("Written By:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(pane);
        pane.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quit)
                    .addComponent(start))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(178, 178, 178))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(150, 150, 150)
                .addComponent(start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(36, 36, 36))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        mainMenu.getContentPane().add(pane, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/back.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        mainMenu.getContentPane().add(jLabel2, gridBagConstraints);
        mainMenu.setSize(500,500);
        mainMenu.setVisible(true);
    }

    //draws backround

    class DrawBack extends JPanel 
    {
        @Override
        public void paint(Graphics g)
        {
            Image back = new ImageIcon("C:\\images\\back.jpg").getImage();
            g.drawImage(back, 0, 0, this);
        }
    }

    //starts new game process

    class newGameListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            //pane.setVisible(false);
            //pane.remove(start);
            //pane.remove(quit);
            start = new JButton(" Two player");
            start.addActionListener(new gameStarter2());
            quit = new JButton("Three player");
            quit.addActionListener(new gameStarter3());
            player4 = new JButton("Four player");
            player4.addActionListener(new gameStarter4());
            //pane.add(start);
            //pane.add(quit);
            //pane.add(player4);
            //pane.setVisible(true);
        }

    }

    class gameStarter2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            mainMenu.setVisible(false);
            ArrayList names = new ArrayList();
            names.add(JOptionPane.showInputDialog("Enter player one name"));
            names.add(JOptionPane.showInputDialog("Enter player two name"));
        }
    }

    class gameStarter3 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            mainMenu.setVisible(false);
            ArrayList names = new ArrayList();
            names.add(JOptionPane.showInputDialog("Enter player one name"));
            names.add(JOptionPane.showInputDialog("Enter player two name"));
            names.add(JOptionPane.showInputDialog("Enter player three name"));
        }
    }

    class gameStarter4 implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            mainMenu.setVisible(false);
            ArrayList names = new ArrayList();
            names.add(JOptionPane.showInputDialog("Enter player one name"));
            names.add(JOptionPane.showInputDialog("Enter player two name"));
            names.add(JOptionPane.showInputDialog("Enter player three name"));
            names.add(JOptionPane.showInputDialog("Enter player three name"));
        }
    }

    //exits app

    class exitGameListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            System.exit(0);
        }
    }
}