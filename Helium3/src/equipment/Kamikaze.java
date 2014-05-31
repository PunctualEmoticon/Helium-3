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
import helium3.Cell;
import java.util.List;
import java.util.ArrayList;

/**
 * A Kamikaze attacks all adjacent Cells within a distance specified by its
 * upgrade level.  Unlike other weapons, a Kamikaze does not need to be armed
 * before attacking.
 * 
 * @author David Hasegawa
 */
public class Kamikaze extends Weapon {

    /**
     * Class constructor.
     */
    public Kamikaze() {
        super();
    }

    /**
     * Returns all the Locations that can be attacked by this Kamikaze, which
     * are the Locations in a square around thisLoc.  The size of the square is
     * determined by this Kamikaze's upgrade level.  An upgrade level of 0 gives
     * a 3x3 square, of 1 gives a 5x5 square, and so on.
     * 
     * @param thisGrid the Grid that this Kamikaze is in.
     * @param thisLoc the Location that this Kamikaze is in.
     * @return a List of the Locations this Kamikaze can attack.
     */
    @Override
    public List<Location> getPossibleTargets(Grid thisGrid, Location thisLoc) {
        List<Location> result =
                thisGrid.getLocationsAround(thisLoc, getUpgradeLevel() + 1);
        result.add(thisLoc);
        return result;
    }

    /**
     * Attacks all the targets returned by getPossibleTargets.
     *
     * @param thisGrid the Grid that this Kamikaze is currently in.
     * @param thisLoc the Location that this Kamikaze is currently in.
     */
    public void attack(Grid thisGrid, Location thisLoc) {
        List<Location> locsToAttack = getPossibleTargets(thisGrid, thisLoc);
        for (Location attackLoc : locsToAttack) {
            Cell attackCell = thisGrid.getCell(attackLoc);
            if (attackCell.isOccupied()) {
                attackCell.getVehicle().underAttackBy(thisGrid, this);
            }
        }
    }
}
