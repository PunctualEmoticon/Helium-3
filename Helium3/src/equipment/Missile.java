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
 *
 * @author David Hasegawa
 */
public class Missile extends Weapon {

    public Missile() {
        super();
    }
    
    /**
     * Returns the Locations where this Missile may currently attack.  This is a
     * square around thisLoc, with a starting size of 11x11.  The size of this
     * square may be increased by upgrade this Missile (each upgrade increases
     * the square's side length by 4).
     * 
     * @param thisGrid the Grid that this Missile is currently in.
     * @param thisLoc the Location that this Missile is currently in.
     * @return a List of targetable Locations.
     */
    @Override
    public List<Location> getPossibleTargets(Grid thisGrid, Location thisLoc) {
        int radius = getUpgradeLevel() * 2 + 5;
        return thisGrid.getLocationsAround(thisLoc, radius);
    }
    
    /**
     * Attacks one square, assuming this Missile is armed.  If this Missile is
     * not armed, then calling this method does nothing.
     * 
     * @param thisGrid the Grid that this Missile is currently in.
     * @param attackLoc the Location to attack.
     */
    public void attack(Grid thisGrid, Location attackLoc) {
        if (!isArmed()) {
            return;
        }
        if (thisGrid.getCell(attackLoc).isOccupied()) {
            thisGrid.getCell(attackLoc).getVehicle().underAttackBy(this);
        }
    }
}
