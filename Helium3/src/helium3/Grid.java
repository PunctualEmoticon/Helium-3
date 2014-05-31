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

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

/**
 * The Grid class contains a matrix (two-dimensional array) of Cells. The matrix
 * is final and cannot be changed, but its elements can be.
 *
 * @author David Hasegawa
 */
public class Grid {

    final private Cell[][] mat;

    /**
     * Class constructor specifying the number of rows and columns of Cells to
     * be created. generateHelium3 is called to distribute helium-3 around this
     * Grid.
     *
     * @param rows the number of rows this Grid should have.
     * @param cols the number of columns this Grid should have.
     */
    public Grid(int rows, int cols) {
        mat = new Cell[rows][cols];

        //Fill the matrix with Cells instead of null.
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                mat[r][c] = new Cell();
            }
        }
        generateHelium3();
    }

    /**
     * Returns the Cell at the specified Location.
     *
     * @param loc the Location to get.
     * @return the Cell at the Location.
     */
    public Cell getCell(Location loc) {
        return mat[loc.getY()][loc.getX()];
    }
    
    /**
     * Moves the Vehicle located in startLoc to endLoc, while also disarming the
     * Vehicle's Shield and Weapons.  Returns the success of the move attempt.
     * If there is no Vehicle in startLoc or if endLoc is already occupied, this
     * method will return false.
     * 
     * @param startLoc the Location where the Vehicle to be moved currently is.
     * @param endLoc the Location where the Vehicle will end up.
     * @return true if the move was successfully performed, false otherwise.
     */
    public boolean moveVehicle(Location startLoc, Location endLoc) {
        Vehicle movingVehicle;
        if (!getCell(startLoc).isOccupied() || getCell(endLoc).isOccupied()) {
           return false;
        } else {
            movingVehicle = getCell(startLoc).getVehicle();
        }
        getCell(startLoc).setVehicle(null);
        getCell(endLoc).setVehicle(movingVehicle);
        
        movingVehicle.getLaser().disarm();
        movingVehicle.getMissile().disarm();
        movingVehicle.getShield().disarm();
        
        return true;
    }

    /**
     * Returns the number of rows (the height) of this Grid.
     *
     * @return this Grid's number of rows.
     */
    public int getNumRows() {
        return mat.length;
    }

    /**
     * Returns the number of columns (the width) of this Grid.
     *
     * @return this Grid's number of columns.
     */
    public int getNumCols() {
        return mat[0].length;
    }

    /**
     * Returns the number of Cells in this Grid.
     *
     * @return the number of Cells in this Grid.
     */
    public int getArea() {
        return getNumRows() * getNumCols();
    }

    /**
     * Checks a Location to see whether its coordinates are within this Grid.
     *
     * @param loc the Location to be checked.
     * @return whether or not loc is within this Grid.
     */
    public boolean isValid(Location loc) {
        int locX = loc.getX();
        int locY = loc.getY();
        return locX >= 0 && locX < getNumCols() && locY >= 0
                && locY < getNumRows();
    }

    /**
     * Returns all Locations in a square around loc within radius in this Grid,
     * assuming they're within bounds.  A radius of 1, for example, will return
     * 8 Locations (a 3x3 square, minus the center). Results are returned
     * left --&gt; right, then top --&gt; bottom.
     *
     * @param loc the center of the Locations to be returned.
     * @param radius the distance from loc to the edge of the square of returned
     * Locations.
     * @return all Locations in a square around loc within radius.
     */
    public List<Location> getLocationsAround(Location loc, int radius) {
        List<Location> result = new ArrayList<>();
        for (int row = loc.getY() - radius; row <= loc.getY() + radius; row++) {
            //Check if row is out of bounds
            if (row >= 0 && row < getNumRows()) {
                for (int col = loc.getX() - radius; col <= loc.getX() + radius;
                        col++) {
                    //Check if col is out of bounds
                    if (col >= 0 && col < getNumCols()) {
                        //Check if row and col specify loc
                        if (row != loc.getY() || col != loc.getX()) {
                            result.add(new Location(col, row));
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns all the Locations north of (above) loc in this Grid. Results are
     * returned starting at loc.
     *
     * @param loc the starting Location.
     * @return a List of Locations north of loc in this Grid.
     */
    public List<Location> getLocationsNorthOf(Location loc) {
        List<Location> result = new ArrayList<>();
        for (int row = loc.getY()-1; row >= 0; row--) {
            result.add(new Location(loc.getX(), row));
        }
        return result;
    }

    /**
     * Returns all the Locations south of (below) loc in this Grid. Results are
     * returned starting at loc.
     *
     * @param loc the starting Location.
     * @return a List of Locations south of loc in this Grid.
     */
    public List<Location> getLocationsSouthOf(Location loc) {
        List<Location> result = new ArrayList<>();
        for (int row = loc.getY() + 1; row < getNumRows(); row++) {
            result.add(new Location(loc.getX(), row));
        }
        return result;
    }

    /**
     * Returns all the Locations west of (left of) loc in this Grid. Results are
     * returned starting at loc.
     *
     * @param loc the starting Location.
     * @return a List of Locations west of loc in this Grid.
     */
    public List<Location> getLocationsWestOf(Location loc) {
        List<Location> result = new ArrayList<>();
        for (int col = loc.getX() - 1; col >= 0; col--) {
            result.add(new Location(col, loc.getY()));
        }
        return result;
    }

    /**
     * Returns all the Locations east of (right of) loc in this Grid. Results
     * are returned starting at loc.
     *
     * @param loc the starting Location.
     * @return a List of Locations east of loc in this Grid.
     */
    public List<Location> getLocationsEastOf(Location loc) {
        List<Location> result = new ArrayList<>();
        for (int col = loc.getX() + 1; col < getNumCols(); col++) {
            result.add(new Location(col, loc.getY()));
        }
        return result;
    }

    /**
     * Returns all the Locations northwest of (up and to the left of) loc in
     * this Grid. Results are returned starting at loc.
     *
     * @param loc the starting Location.
     * @return a List of Locations northwest of loc in this Grid.
     */
    public List<Location> getLocationsNorthWestOf(Location loc) {
        List<Location> result = new ArrayList<>();
        for (int shift = 0; loc.getX() - shift >= 0 && loc.getY() - shift >= 0;
                shift++) {
            result.add(new Location(loc.getX() - shift, loc.getY() - shift));
        }
        return result;
    }

    /**
     * Returns all the Locations northeast of (up and to the right of) loc in
     * this Grid. Results are returned starting at loc.
     *
     * @param loc the starting Location.
     * @return a List of Locations northeast of loc in this Grid.
     */
    public List<Location> getLocationsNorthEastOf(Location loc) {
        List<Location> result = new ArrayList<>();
        for (int shift = 0; loc.getX() + shift < getNumCols()
                && loc.getY() - shift >= 0; shift++) {
            result.add(new Location(loc.getX() + shift, loc.getY() - shift));
        }
        return result;
    }

    /**
     * Returns all the Locations southeast of (down and to the right of) loc in
     * this Grid. Results are returned starting at loc.
     *
     * @param loc the starting Location.
     * @return a List of Locations southeast of loc in this Grid.
     */
    public List<Location> getLocationsSouthEastOf(Location loc) {
        List<Location> result = new ArrayList<>();
        for (int shift = 0; loc.getX() + shift < getNumCols()
                && loc.getY() + shift < getNumRows(); shift++) {
            result.add(new Location(loc.getX() + shift, loc.getY() + shift));
        }
        return result;
    }

    /**
     * Returns all the Locations southwest of (down and to the left of) loc in
     * this Grid. Results are returned starting at loc.
     *
     * @param loc the starting Location.
     * @return a List of Locations southwest of loc in this Grid.
     */
    public List<Location> getLocationsSouthWestOf(Location loc) {
        List<Location> result = new ArrayList<>();
        for (int shift = 0; loc.getX() - shift >= 0
                && loc.getY() + shift < getNumRows(); shift++) {
            result.add(new Location(loc.getX() - shift, loc.getY() + shift));
        }
        return result;
    }

    /**
     * Calculates and returns the total value of helium-3 contained within all
     * the Cells in this Grid.
     *
     * @return the total value of helium-3 within this Grid.
     */
    public int getTotalHelium3() {
        int sum = 0;
        for (Cell[] row : mat) {
            for (Cell cel : row) {
                sum += cel.getHelium3Amount();
            }
        }
        return sum;
    }

    /**
     * Adds random amounts of helium-3 to this Grid, centered around 7–10
     * hotspots.
     */
    public void generateHelium3() {
        List<Location> hotspots = new ArrayList<>();
        int numHotspots = (int)(Math.random() * 4 + 7); //Between 7 and 10
        
        for (int i = 0; i < numHotspots; i++) {
            int row = (int)(Math.random() * getNumRows());
            int col = (int)(Math.random() * getNumCols());
            hotspots.add(new Location(col, row));
        }
        for (Location spot : hotspots) {
            depositHelium3(spot, 3000);
        }
    }
    
    /**
     * Deposits the given amount of helium-3 randomly around the given Location.
     * 
     * @param loc the center of the deposit.
     * @param amount the total value of the deposit.
     */
    public void depositHelium3(Location loc, int amount) {
        int radius = (int)(Math.random() * 2 + 1); //Between 1 and 2
        List<Location> locNeighbors = getLocationsAround(loc, radius);
        //Add center Location that getLocationsAround ignores to beginning
        locNeighbors.add(0, loc);
        
        int i = 0; //List index, leads to first deposit always in center
        while (amount > 0) {
            int depositAmount;
            //Deposits between 1 and either 1000 or all of amount, whichever is
            //less
            if (amount < 1000) {
                depositAmount = (int)(Math.random() * amount + 1);
            } else {
                depositAmount = (int)(Math.random() * 1000 + 1);
            }
            getCell(locNeighbors.get(i)).changeHelium3Amount(depositAmount);
            amount -= depositAmount;
            
            //i is randomly set to new locNeighbors element
            i = (int)(Math.random() * locNeighbors.size());
        }
    }
    
    /**
     * Returns a String of the Grid's Cell's helium-3 amounts, formatted in a
     * grid. If a Cell is occupied, then an asterisk will be added next to its
     * helium-3 number.
     *
     * @return a text version of this Grid.
     */
    @Override
    public String toString() {
        String result = "";
        for (int row = 0; row < getNumRows(); row++) {
            for (int col = 0; col < getNumCols(); col++) {
                result += mat[row][col].getHelium3Amount() + "";
                if (mat[row][col].isOccupied()) {
                    result += "*";
                }
                result += " ";
            }
            result += "\n";
        }
        return result;
    }
}
