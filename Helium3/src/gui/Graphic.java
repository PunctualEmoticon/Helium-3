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
import javax.swing.*;

/**
 *
 * @author matts_000
 */
public class Graphic
{
    JFrame frame;
    
    public Graphic(JFrame a)
    { 
        frame= a;
    }
    
    public void newGameGraphics()
    {
        //starts a window with grid in it. Charcters placed in starting positions
        frame.setSize(1000,1000);
        frame.setVisible(true);
        
    }
    
    public void move(Location ab, Location ba)
    {
        //moves sprite from location a to b on grid
    }
    
    public void las(Location ab, Location ba)
    {
        //shoots lazer from lcation ab to ba
    }
    
    public void missile(Location ab, Location ba)
    {
        //shoots missle from ab to ba
    }
    
    public void shield(Location ab)
    {
        //puts sheild around vehicle
    }
    
    public void drill(Location ab)
    {
        //drill on outside of vehicle, less color for helium 3
    }
    
    public void kamikaze(Location ab)
    {
        //thing blows up
    }
    
    public void remove(Location ab)
    {
        //remove vehicle from space if destroyed
    }
}
