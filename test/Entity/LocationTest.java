/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Enum.LocationType;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author AsphaltPanthers
 */
public class LocationTest {
    @Test
    public void locationConstructorCreatesALocationWithALocationType() {
        Location location = new Location(LocationType.DOWNTOWN);
        assertEquals(LocationType.DOWNTOWN, location.getLocationType());
    }
}
