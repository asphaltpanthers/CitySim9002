/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Enum.LocationType;

/**
 *
 * @author AsphaltPanthers
 */
public class Location {
    private final LocationType name;
    
    public Location(LocationType name) {
        this.name = name;
    }
    
    public LocationType getLocationType() {
        return name;
    }
}
