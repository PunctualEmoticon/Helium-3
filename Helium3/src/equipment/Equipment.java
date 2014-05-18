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

/**
 * Equipment is the abstract superclass for all the equipment a Vehicle may own.
 * It manages the upgrade level of all equipment.
 * @author David Hasegawa
 */
public abstract class Equipment {

    private int upgradeLevel;

    /**
     * Class constructor that sets the current upgrade level to 0.
     */
    public Equipment() {
        upgradeLevel = 0;
    }

    /**
     * Class constructor that sets the current upgrade level to the specified
     * value.
     *
     * @param upG
     */
    public Equipment(int upG) {
        upgradeLevel = upG;
    }

    /**
     * Returns the current upgrade level of this Equipment
     *
     * @return the current upgrade level.
     */
    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    /**
     * Sets the current upgrade level to the specified value.
     *
     * @param upG the new upgrade level.
     */
    public void setUpgradeLevel(int upG) {
        upgradeLevel = upG;
    }

    /**
     * Increments the current upgrade level by 1.
     */
    public void upgrade() {
        upgradeLevel++;
    }

    /**
     * Decrements the current upgrade level by 1.
     */
    public void downgrade() {
        upgradeLevel--;
    }
}
