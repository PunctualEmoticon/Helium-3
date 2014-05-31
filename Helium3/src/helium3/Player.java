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

/**
 * A Player object represents one player of the game.  Each Player has a name
 * and a List of Vehicles that belong to it.
 * 
 * @author David Hasegawa
 */
public class Player {

    private final List<Vehicle> vehicleList;
    private final String name;

    /**
     * Class constructor. Creates 5 Vehicles for this Player.
     *
     * @param newName this Player's name.
     */
    Player(String newName) {
        name = newName;
        vehicleList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vehicleList.add(new Vehicle(this));
        }
    }
    
    /**
     * Returns the name of this Player.
     * @return this Player's name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the stored List of Vehicles.
     * @return this Player's List of Vehicles.
     */
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }
    
    public int getHe() {
        int sum = 0;
        for (Vehicle veh : vehicleList) {
            sum += veh.getDrill().getStoredHelium3();
        }
        return sum;
    }

}
