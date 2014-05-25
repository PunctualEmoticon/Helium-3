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

import equipment.*;

/**
 *
 * @author David Hasegawa
 */
public class Vehicle {
    
    final private Drill drill;
    final private Shield shield;
    final private Kamikaze kamikaze;
    final private Laser laser;
    final private Missile missile;
    private int moveRadius;
    private int helium3;
    
    /**
     * Class constructor.  Sets this Vehicle's move radius to 4 and stored
     * helium-3 to 0.
     */
    public Vehicle() {
        drill = new Drill();
        shield = new Shield();
        kamikaze = new Kamikaze();
        laser = new Laser();
        missile = new Missile();
        moveRadius = 4;
        helium3 = 0;
    }
    
    /**
     * Attacks this Vehicle with the specified Weapon and performs the
     * appropriate actions (such as destroying this Vehicle, attacking another,
     * and so on).
     * 
     * @param weap the attacking weapon.
     */
    public boolean underAttackBy(Weapon weap) {
        return true;
    }
}
