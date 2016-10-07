/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Enum.LocationType;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AsphaltPanthers
 */
public class City {
    private final ArrayList<Location> locations;
    
    public City() {
        locations = new ArrayList<>();
        
        locations.add(new Location(LocationType.DOWNTOWN));
        locations.add(new Location(LocationType.SQUIRREL_HILL));
        locations.add(new Location(LocationType.THE_CATHEDRAL_OF_LEARNING));
        locations.add(new Location(LocationType.THE_POINT));
    }
    
    public boolean addLocation(Location location) {
        return locations.add(location);
    }
    
    public Location getRandomLocation(Random generator) {
        return locations.get(generator.nextInt(locations.size()));
    }
    
    public ArrayList<Location> getLocations() {
        return locations;
    }
}
