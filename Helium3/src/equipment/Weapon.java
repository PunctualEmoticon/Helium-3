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
package equipment;

import helium3.Grid;
import helium3.Location;
import java.util.List;

/**
 * The abstract class Weapon is the superclass to all of a Vehicle's weapons and
 * a subclass of Equipment.  It manages the armed status of all Weapons.
 * 
 * @author David Hasegawa
 */
public abstract class Weapon extends Equipment {
    
    private boolean armed;
    
    /**
     * Class constructor.  Sets the armed status to false.
     */
    public Weapon() {
        armed = false;
    }
    
    /**
     * Returns whether this Weapon is currently ready to fire or not.
     * 
     * @return whether this Weapon is armed or not.
     */
    public boolean isArmed() {
        return armed;
    }
    
    /**
     * Sets this Weapon's armed status to true.
     */
    public void arm() {
        armed = true;
    }
    
    /**
     * Sets this Weapon's armed status to false.
     */
    public void disarm() {
        armed = false;
    }
    
    /**
     * Sets this Weapon's current arm status to the specified value.
     * @param leg the new arming status.
     */
    public void setArmed(boolean leg) {
        armed = leg;
    }
    
    /**
     * Returns a List of all the Locations this Weapon may attack from its
     * current location (passed in thisLoc).
     * 
     * @param thisGrid the current Grid this Weapon is in (on the Vehicle).
     * @param thisLoc the current Location of the Weapon (on the Vehicle).
     * @return all the possible Locations this Weapon may attack.
     */
    public abstract List<Location> getPossibleTargets(Grid thisGrid,
            Location thisLoc);
}
