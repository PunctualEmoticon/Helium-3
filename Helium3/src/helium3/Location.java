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
 * An immutable class that holds two ints for a x and y coordinates, for
 * referring to an element in a Grid.
 *
 * @author David Hasegawa
 */
public class Location {

    private final int xCoordinate;
    private final int yCoordinate;

    /**
     * Class constructor specifying x and y coordinates to be held.
     *
     * @param xCor x-coordinate to be held
     * @param yCor y-coordinate to be held
     */
    public Location(int xCor, int yCor) {
        xCoordinate = xCor;
        yCoordinate = yCor;
    }

    /**
     * Returns an int representing an x-coordinate in a Grid.
     *
     * @return the x-coordinate
     */
    public int getX() {
        return xCoordinate;
    }

    /**
     * Returns an int representing a y-coordinate in a Grid.
     *
     * @return the y-coordinate
     */
    public int getY() {
        return yCoordinate;
    }
}
