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
import java.util.ArrayList;

/**
 *
 * @author David Hasegawa
 */
public class Laser extends Weapon {

    /**
     * Class constructor.
     */
    public Laser() {
        super();
    }

    @Override
    public List<Location> getPossibleTargets(Grid thisGrid, Location thisLoc) {
        List<Location> result = new ArrayList<>();

        for (Location listLoc : thisGrid.getLocationsNorthOf(thisLoc)) {
            result.add(listLoc);
        }
        for (Location listLoc : thisGrid.getLocationsNorthEastOf(thisLoc)) {
            result.add(listLoc);
        }
        for (Location listLoc : thisGrid.getLocationsEastOf(thisLoc)) {
            result.add(listLoc);
        }
        for (Location listLoc : thisGrid.getLocationsSouthEastOf(thisLoc)) {
            result.add(listLoc);
        }
        for (Location listLoc : thisGrid.getLocationsSouthOf(thisLoc)) {
            result.add(listLoc);
        }
        for (Location listLoc : thisGrid.getLocationsSouthWestOf(thisLoc)) {
            result.add(listLoc);
        }
        for (Location listLoc : thisGrid.getLocationsWestOf(thisLoc)) {
            result.add(listLoc);
        }
        for (Location listLoc : thisGrid.getLocationsNorthWestOf(thisLoc)) {
            result.add(listLoc);
        }

        return result;
    }

    /**
     * Attacks all Vehicles in the direction dir degrees. If this Laser
     * encounters a Vehicle that is not destroyed by it (like a shielded
     * Vehicle), then this Laser stops.
     * <p>
     * If dir is between
     * <ul>
     * <li>0 and 359: one laser is fired.
     * <li>2000 and 2359: two lasers are fired in opposite directions.
     * <li>4000 and 4359: four lasers are fired perpendicularly to each other.
     * <li>8000 and 8359: eight lasers are fired, in all directions.
     * </ul>
     *
     * @param gr the Grid this Laser is currently in.
     * @param loc the Location this Laser is currently in.
     * @param dir the number and direction of the lasers to be fired. 0 is up,
     * 90 is right, and so on.
     */
    public void attack(Grid gr, Location loc, int dir) {
        if (dir >= 0 && dir < 360) {

        } else if (dir >= 2000 && dir < 2360) {

        } else if (dir >= 4000 && dir < 4360) {

        } else if (dir >= 8000 && dir < 8360) {

        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Helper method for the attack method that fires a laser in only one
     * direction. Precondition: 0 &lt;= dir &lt; 360 and dir is a multiple of
     * 45.
     *
     * @param gr the Grid this Laser is currently in.
     * @param loc the Location this Laser is currently in.
     * @param dir the direction to attack towards. 0 is up, 90 is right, and so
     * on.
     */
    private void attackOneDir(Grid gr, Location loc, int dir) {
        List<Location> targets;
        
        if (dir == 0) {
            targets = gr.getLocationsNorthOf(loc);
        } else if (dir == 45) {
            targets = gr.getLocationsNorthEastOf(loc);
        } else if (dir == 90) {
            targets = gr.getLocationsEastOf(loc);
        } else if (dir == 135) {
            targets = gr.getLocationsSouthEastOf(loc);
        } else if (dir == 180) {
            targets = gr.getLocationsSouthOf(loc);
        } else if (dir == 225) {
            targets = gr.getLocationsSouthWestOf(loc);
        } else if (dir == 270) {
            targets = gr.getLocationsWestOf(loc);
        } else if (dir == 315) {
            targets = gr.getLocationsNorthWestOf(loc);
        } else {
            throw new UnsupportedOperationException(
                    "Laser.attackOneDir: Invalid direction");
        }
        
        for (Location targetLoc : targets) {
            if (gr.getCell(targetLoc).isOccupied()) {
                //if statement attacks and checks if loop should continue
                //if Vehicle is not destroyed, break.
                if (!gr.getCell(targetLoc).getVehicle().underAttackBy(this)) {
                    break;
                }
            }
        }
    }
}
