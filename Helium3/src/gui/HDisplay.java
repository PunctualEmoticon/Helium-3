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
import helium3.Player;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author Matt
 */
public class HDisplay
{
    JFrame frame;
    JPanel pane ;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3,jLabel4,jLabel5;
    
    
    public HDisplay()
    {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Helium 3 obtained");

        jLabel2.setText("");

        jLabel3.setText("");

        jLabel4.setText("");

        jLabel5.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );
    }
    
    public void update(ArrayList<Player> a)
    {
        frame.setSize(300,300);
        frame.setVisible(true);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        
        if(a.size() == 2){
        jLabel2.setText(a.get(0).getName() + a.get(0).getHe());

        jLabel3.setText(a.get(1).getName() + a.get(1).getHe());
        }
        
        if(a.size() == 3){
        jLabel2.setText(a.get(0).getName() + a.get(0).getHe());

        jLabel3.setText(a.get(1).getName() + a.get(1).getHe());
        
        jLabel4.setText(a.get(2).getName() + a.get(2).getHe());

        }
        
        if(a.size() == 3){
        jLabel2.setText(a.get(0).getName() + a.get(0).getHe());

        jLabel3.setText(a.get(1).getName() + a.get(1).getHe());
        
        jLabel4.setText(a.get(2).getName() + a.get(2).getHe());

        jLabel5.setText(a.get(3).getName() + a.get(3).getHe());
        }
        
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
    }
}
