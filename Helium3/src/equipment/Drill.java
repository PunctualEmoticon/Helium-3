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
import helium3.Cell;
import helium3.Location;
import java.lang.Math;

/**
 * A drill extracts helium-3 from the squares surrounding it and records the
 * stored helium-3 within itself.
 * 
 * @author David Hasegawa
 */
public class Drill extends Equipment {
    
    private int helium3;
    
    /**
     * Class constructor.
     */
    public Drill() {
        super();
        helium3 = 0;
    }
    
    /**
     * Extracts 100 helium-3 from the surrounding square of Cells in the given
     * Grid and returns the extracted amount.  The size of the extraction square
     * depends on the Drill's upgrade level.  Each upgrade increases the radius
     * by 1.
     * 
     * @param gr the Grid to extract from.
     * @param loc the center of the Drill's extraction.
     * @return the total value of helium-3 extracted.
     */
    public int mine(Grid gr, Location loc) {
        int sum = 0;
        final int extractAmount = 100; //positive number
        final int radius = super.getUpgradeLevel() + 1;
        
        //Nested loop for checking cells around loc
        for (int row = loc.getY() - radius; row < loc.getY() + radius; row++) {
            for (int col = loc.getX() - radius; col < loc.getX() + radius;
                    col++) {
                Location currentLoc = new Location(col, row);
                
                //Check because loc could be near the edge of the Grid
                if (gr.isValid(currentLoc)) {
                    Cell currentCell = gr.getCell(currentLoc);
                    
                    currentCell.changeHelium3Amount(-extractAmount);
                    sum += extractAmount;
                    //Check if Cell has run out of helium-3
                    if (currentCell.getHelium3Amount() < 0) {
                        int changeAmount =
                                Math.abs(currentCell.getHelium3Amount());
                        currentCell.changeHelium3Amount(changeAmount);
                        sum -= changeAmount;
                    }
                }
            }
        }
        helium3 += sum;
        System.out.println(sum);
        return sum;
    }
        
}
