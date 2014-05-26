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

/**
 * The Cell class represents one cell in a Grid, and stores its amount of
 * helium-3 and a pointer to the Vehicle that is occupying it (if there is one).
 *
 * @author David Hasegawa
 */
public class Cell {

    private int helium3;
    private Vehicle vehicle;

    /**
     * Class constructor that sets the helium-3 value to 0 and occupying Vehicle
     * to null.
     */
    public Cell() {
        helium3 = 0;
        vehicle = null;
    }

    /**
     * Class constructor that sets the helium-3 value to the specified value and
     * occupying Vehicle to null.
     *
     * @param he3 the helium-3 value to be stored
     */
    public Cell(int he3) {
        helium3 = he3;
        vehicle = null;
    }

    /**
     * Returns the current amount of helium-3 contained within this Cell.
     *
     * @return the stored helium-3 value.
     */
    public int getHelium3Amount() {
        return helium3;
    }

    /**
     * Sets the current amount of helium-3 contained within this Cell to the
     * specified amount.  Should be between roughly 0 and 1000.
     *
     * @param he3 the new value of helium-3.
     */
    public void setHelium3Amount(int he3) {
        helium3 = he3;
    }

    /**
     * Adds the specified value to the currently stored value of helium-3. Use
     * negative numbers to reduce the stored value.
     *
     * @param he3Change the amount to change the stored value by.
     */
    public void changeHelium3Amount(int he3Change) {
        helium3 += he3Change;
    }

    /**
     * Returns the Vehicle currently located in this Cell.
     *
     * @return the currently occupying Vehicle.
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets the occupying Vehicle pointer to the specified Vehicle (or null).
     * The currently occupying Vehicle's pointer is lost.
     *
     * @param car the new occupying Vehicle. Can be null.
     */
    public void setVehicle(Vehicle car) {
        vehicle = car;
    }

    /**
     * Returns whether or not there is currently a Vehicle located in this Cell.
     *
     * @return if this Cell has a Vehicle in it.
     */
    public boolean isOccupied() {
        return vehicle != null;
    }
}
