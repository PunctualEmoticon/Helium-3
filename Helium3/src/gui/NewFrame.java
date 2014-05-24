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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Matt
 */
public class NewFrame extends JFrame{
    
    private Image dbImage;
    private Graphics dbg;
    
    private boolean isRunningHappeningNow;
    
    
    public NewFrame(){
        
    }
    
    @Override
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void paintComponent(Graphics g){
        g.setColor(new Color(255,255,255));
        for(int x = 0; x < 20; x++){
            for(int y = 0; y < 20; y++){
                g.fillRect(x*14, y*14, 12, 12);
            }
        }
    }
    
    
    
    public void makeRunHappen()
    {
       while(isRunningHappeningNow) 
       {
           
           
           
           try{
               Thread.sleep(100);
           }catch(Exception e){}
           repaint();
       }
    }
}
