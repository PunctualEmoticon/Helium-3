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

import equipment.*;
import java.util.List;

/**
 *
 * @author David Hasegawa
 */
public class Vehicle {
    
    final private Player owningPlayer;
    final private Drill drill;
    final private Shield shield;
    final private Kamikaze kamikaze;
    final private Laser laser;
    final private Missile missile;
    private int moveRadius;
    public boolean isSelected;
    public boolean hasPerformedAction;
    public boolean isMoving;
    public boolean missileTime;
    
    /**
     * Class constructor.  Sets this Vehicle's move radius to 4.
     * 
     * @param owner the Player that this Vehicle belongs to.
     */
    public Vehicle(Player owner) {
        owningPlayer = owner;
        drill = new Drill();
        shield = new Shield();
        kamikaze = new Kamikaze();
        laser = new Laser();
        missile = new Missile();
        moveRadius = 4;
        isSelected = false;
        //hasPerformedAction = false;
        isMoving= false;
        missileTime = false;        
    }
    
    /**
     * Attacks this Vehicle with the specified Weapon and performs the
     * appropriate actions (such as destroying this Vehicle, attacking another,
     * and so on).
     * 
     * @param gr
     * @param weap the attacking weapon.
     * @return whether or not this Vehicle is destroyed by weap.  True if
     * destroyed.
     */
    public boolean underAttackBy(Grid gr, Weapon weap) {
        boolean shieldBlocks = getShield().blocks(weap);
        
        //If the Shield doesn't block, drop helium-3 and destroy this Vehicle
        if (!shieldBlocks) {
            owningPlayer.getVehicleList().remove(this);
            
            //Remove this Vehicle from gr
            scanLoop:
            for (int row = 0; row < gr.getNumRows(); row++) {
                for (int col = 0; col < gr.getNumCols(); col++) {
                    Location currentLocation = new Location(col, row);
                    Cell currentCell = gr.getCell(currentLocation);
                                                          
                    if (currentCell.getVehicle() == this) {
                        gr.depositHelium3(currentLocation,
                            getDrill().getStoredHelium3());
                        
                        currentCell.setVehicle(null);
                        break scanLoop;
                    }
                }
            }
        }
        return shieldBlocks;
    }
    
    /**
     * Returns this Vehicle's owning Player.
     * @return this Vehicle's owner
     */
    public Player getPlayer()
    {
        return owningPlayer;
    }
    
    /**
     * Returns this Vehicle's Drill.
     * @return this Vehicle's Drill.
     */
    public Drill getDrill() {
        return drill;
    }
    
    /**
     * Returns this Vehicle's Kamikaze Weapon.
     * @return this Vehicle's Kamikaze.
     */
    public Kamikaze getKamikaze() {
        return kamikaze;
    }
    
    /**
     * Returns this Vehicle's Laser Weapon.
     * @return this Vehicle's Laser.
     */
    public Laser getLaser() {
        return laser;
    }
    
    /**
     * Return's this Vehicle's Missile Weapon.
     * @return this Vehicle's Missile.
     */
    public Missile getMissile() {
        return missile;
    }
    
    /**
     * Return's this Vehicle's Shield.
     * @return this Vehicle's Shield.
     */
    public Shield getShield() {
        return shield;
    }
    
    /**
     * Returns all the possible Locations this Vehicle can move to in one turn.
     * 
     * @param gr the Grid that this Vehicle is currently in.
     * @param loc the Location that this Vehicle is currently at.
     * @return a List of the possible Locations this Vehicle may move to in one
     * turn of only moving.
     */
    public List<Location> getMoveLocations(Grid gr, Location loc) {
        return gr.getLocationsAround(loc, moveRadius);
    }
    
    /**
     * Returns all the possible Locations this Vehicle can move to while also
     * arming a Weapon, arming a Shield, or mining in the same turn (radius 2).
     * 
     * @param gr the Grid that this Vehicle is currently in.
     * @param loc the Location that this Vehicle is currently at.
     * @return a List of all the possible Locations this Vehicle may move to
     * while arming a Weapon, arming a Shield, or mining.
     */
    public List<Location> getArmedMoveLocations(Grid gr, Location loc) {
        return gr.getLocationsAround(loc, 2);
    }
}
