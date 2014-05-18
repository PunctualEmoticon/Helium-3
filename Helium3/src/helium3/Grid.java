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
 * The Grid class contains a matrix (two-dimensional array) of Cells.  The
 * matrix is final and cannot be changed, but its elements can be.
 * 
 * @author David Hasegawa
 */
public class Grid {

    final private Cell[][] mat;

    /**
     * Class constructor specifying the number of rows and columns of Cells to
     * be created. Each cell has a helium-3 value of 0.
     *
     * @param rows
     * @param cols
     */
    public Grid(int rows, int cols) {
        mat = new Cell[rows][cols];

        //Fill the matrix with Cells instead of null.
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                mat[r][c] = new Cell();
            }
        }
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
     * @param loc the Location to be checked.
     * @return 
     */
    public boolean isValid(Location loc) {
        int locX = loc.getX();
        int locY = loc.getY();
        return locX >= 0 && locX < getNumCols() && locY >= 0
                && locY < getNumRows();
    }
    
    /**
     * Calculates and returns the total value of helium-3 contained within all
     * the Cells in this Grid.
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
     * Returns a String of the Grid's Cell's helium-3 amounts, formatted in a
     * grid.  If a Cell is occupied, then an asterisk will be added next to its
     * helium-3 number.
     * @return 
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
