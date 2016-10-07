/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Enum.LocationType;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author AsphaltPanthers
 */
public class CityTest {
    @Test
    public void cityConstructorCreatesCityWithFourLocations() {
        City city = new City();
        assertEquals(4, city.getLocations().size());
        assertTrue(city.getLocations().stream().anyMatch(l -> l.getLocationType() == LocationType.DOWNTOWN));
        assertTrue(city.getLocations().stream().anyMatch(l -> l.getLocationType() == LocationType.SQUIRREL_HILL));
        assertTrue(city.getLocations().stream().anyMatch(l -> l.getLocationType() == LocationType.THE_CATHEDRAL_OF_LEARNING));
        assertTrue(city.getLocations().stream().anyMatch(l -> l.getLocationType() == LocationType.THE_POINT));
    }
    
    @Test
    public void addLocationAddsALocationToACity() {
        City city = new City();
        city.addLocation(new Location(LocationType.LEAVE));
        assertEquals(5, city.getLocations().size());
        assertTrue(city.getLocations().stream().anyMatch(l -> l.getLocationType() == LocationType.LEAVE));
    }
    
    @Test
    public void getRandomLocationReturnsALocation() {
        Random mockGenerator = mock(Random.class);
        when(mockGenerator.nextInt(any(int.class))).thenReturn(0);
        
        City city = new City();
        assertEquals(LocationType.DOWNTOWN, city.getRandomLocation(mockGenerator).getLocationType());
    }
}
