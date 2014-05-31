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
 * A Shield is what protects a Vehicle from attack. It can be either armed or
 * disarmed, which determines whether it prevents the attack or not. If it is
 * armed, it may also be deflecting in a certain direction(s). If a Shield is
 * deflecting and is attacked by a Laser, the Laser is redirected in the
 * deflecting direction(s).
 *
 * @author David Hasegawa
 */
public class Shield extends Equipment {

    private boolean armed;
    private int deflectDirection;

    /**
     * Class constructor. Sets the armed status to false and deflect direction
     * to -1 (not deflecting).
     */
    public Shield() {
        armed = false;
        deflectDirection = -1;
    }

    /**
     * Returns whether or not this Shield is armed
     *
     * @return if this Shield is armed
     */
    public boolean isArmed() {
        return armed;
    }

    /**
     * Sets this Shield to be armed, even if it already is.
     */
    public void arm() {
        armed = true;
    }

    /**
     * Sets this Shield to be disarmed, even if it already is.
     */
    public void disarm() {
        armed = false;
    }

    /**
     * Sets this Shield to be armed or disarmed as specified.
     *
     * @param boo new armed status.
     */
    public void setArmed(boolean boo) {
        armed = boo;
    }

    /**
     * Returns the current deflect direction. -1 represents not deflecting.
     * Between 0 and 359 represents a single-direction deflect in that angle (in
     * degrees). Between 2000 and 2359 represents a two-direction deflect in
     * opposite directions.Between 4000 and 4359 represents a four-direction
     * deflect.  Between 8000 and 8359 represents an eight-direction deflect.
     *
     * @return the stored deflect direction.
     */
    public int getDeflectDirection() {
        return deflectDirection;
    }

    /**
     * Sets the new deflect direction. See the getDeflectDirection() Javadoc for
     * details on permissible values.
     *
     * @param newDir the new deflection setting.
     */
    public void setDeflectDirection(int newDir) {
        deflectDirection = newDir;
    }
    
    /**
     * Determines whether or not this Shield protects against a Weapon's attack.
     * Returning false means this Shield did not defend against sword.  If this
     * Shield does successfully defend, it is then disarmed.
     * 
     * @param sword The Weapon being defended against.
     * @return if this Shield protects against sword.
     */
    public boolean blocks(Weapon sword) {
        if (!armed) {
            return false;
        }
        armed = false;
        
        /*
        //Laser deflecting
        if (sword instanceof Laser && deflectDirection != -1) {
            Laser deflectLaser = new Laser();
            deflectLaser.arm();
            deflectLaser.attack(null, null, deflectDirection);
            deflectDirection = -1;
        }
        */
        
        return true;
    }
}
