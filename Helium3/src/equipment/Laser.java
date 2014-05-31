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
     * Attacks all Vehicles in the direction dir degrees (in multiples of 45
     * degrees).  If this Laser encounters a Vehicle that is not destroyed by it
     * (like a shielded Vehicle), then this Laser stops.
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
        if (!isArmed()) {
            return;
        }
        if (dir >= 0 && dir < 360) {
            attackOneDir(gr, loc, processDir(dir));
            
        } else if (dir >= 2000 && dir < 2360) {
            dir -= 2000;
            if (dir >= 180) {  //Slightly more efficient than while loop.
                dir -= 180;
            }
            attackOneDir(gr, loc, processDir(dir));
            attackOneDir(gr, loc, processDir(dir + 180));
            
        } else if (dir >= 4000 && dir < 4360) {
            dir -= 4000;
            while (dir >= 90) {
                dir -= 90;
            }
            
            for (int i = 0; i < 360; i += 90) {
                attackOneDir(gr, loc, processDir(dir + i));
            }

        } else if (dir >= 8000 && dir < 8360) {
            //Doesn't really matter what dir is, because lasers are fired in all
            //directions.
            for (int i = 0; i < 360; i += 45) {
                attackOneDir(gr, loc, i);
            }

        } else {
            throw new UnsupportedOperationException(
                    "Laser.attack: Invalid Direction");
        }
    }
    
    /**
     * Helper method that takes a number and rounds to the nearest multiple of
     * 45 that is greater than or equal to 0 and less than 360.
     * 
     * @param num the number to process.
     * @return num rounded and between 0 and 360.
     */
    private int processDir(int num) {
        //Loops to make num be greater than or equal to 0 and less than 360.
        while (num < 0) {
            num += 360;
        }
        while (num >= 360) {
            num -= 360;
        }
        
        if (num % 45 != 0) {
            if (num % 45 <= (45 / 2)) {
                num -= num % 45;
            } else {
                num += 45 - num % 45;
            }
        }
        return num;
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
                if (!gr.getCell(targetLoc).getVehicle().underAttackBy(
                        gr, this)) {
                    break;
                }
            }
        }
    }
}
