/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Enum.LocationType;
import Entity.Enum.VisitorType;
import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author AsphaltPanthers
 */
public class VisitorTest {
    @Test
    public void visitorTourReturnsVisitorDescription() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(0).thenReturn(4);
        
        Visitor visitor = new Visitor(1, VisitorType.BLOGGER);
        assertEquals("Visitor 1 is a Blogger.", visitor.tour(mockRandom).get(0));
    }
    
    @Test
    public void visitorCannotLeaveCityOnFirstIteration() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(4);
        
        Visitor visitor = new Visitor(1, VisitorType.BLOGGER);
        
        try {
            visitor.tour(mockRandom);
            fail();
        } catch (Exception e) { }
    }
    
    @Test
    public void locationsAreNotAddedToCityAfterTheSecondInteration() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(0).thenReturn(0).thenReturn(4);
        
        Visitor visitor = new Visitor(1, VisitorType.BLOGGER);
        
        visitor.tour(mockRandom);
        assertEquals(5, visitor.getCity().getLocations().size());
    }
    
    @Test
    public void visitorTourStatesWhichLocationTheyWillVisit() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(0).thenReturn(4);
        
        Visitor visitor = new Visitor(1, VisitorType.BLOGGER);
        assertEquals("Visitor 1 is going to Downtown!", visitor.tour(mockRandom).get(1));
    }
    
    @Test
    public void visitorTourCallsVisitorAppraisal() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(0).thenReturn(4);
        
        Visitor visitor = new Visitor(1, VisitorType.BLOGGER) {
            @Override
            public String getAppraisalString(Location location, boolean liked) {
                return "test";
            }
        };
        
        ArrayList<String> tour = visitor.tour(mockRandom);
        
        boolean appraiseLocationIsCalled = false;
        for (String message : tour) {
            if (message.equals("test") && appraiseLocationIsCalled) {
                fail();
            } 
            else if (message.equals("test") && !appraiseLocationIsCalled) {
                appraiseLocationIsCalled = true;
            }
        }
        assertTrue(appraiseLocationIsCalled);
    }
    
    @Test
    public void visitorTourEndsWithAsterisks() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(0).thenReturn(4);
        
        Visitor visitor = new Visitor(1, VisitorType.BLOGGER);
        assertEquals("***", visitor.tour(mockRandom).get(4));
    }
    
    @Test
    public void studentLikesSquirrelHill() {
        assertTrue(new Visitor(1, VisitorType.STUDENT).appraiseLocation(new Location(LocationType.SQUIRREL_HILL)));
    }
    
    @Test
    public void studentLikesDowntown() {
        assertTrue(new Visitor(1, VisitorType.STUDENT).appraiseLocation(new Location(LocationType.DOWNTOWN)));
    }
    
    @Test
    public void studentLikesThePoint() {
        assertTrue(new Visitor(1, VisitorType.STUDENT).appraiseLocation(new Location(LocationType.THE_POINT)));
    }
    
    @Test
    public void studentDoesNotLikeTheCathedral() {
        assertFalse(new Visitor(1, VisitorType.STUDENT).appraiseLocation(new Location(LocationType.THE_CATHEDRAL_OF_LEARNING)));
    }
    
    @Test
    public void businessPersonLikesSquirrelHill() {
        assertTrue(new Visitor(1, VisitorType.BUSINESS_PERSON).appraiseLocation(new Location(LocationType.SQUIRREL_HILL)));
    }
    
    @Test
    public void businessPersonLikesDowntown() {
        assertTrue(new Visitor(1, VisitorType.BUSINESS_PERSON).appraiseLocation(new Location(LocationType.DOWNTOWN)));
    }
    
    @Test
    public void businessPersonDoesNotLikeThePoint() {
        assertFalse(new Visitor(1, VisitorType.BUSINESS_PERSON).appraiseLocation(new Location(LocationType.THE_POINT)));
    }
    
    @Test
    public void businessPersonDoesNotLikeTheCathedral() {
        assertFalse(new Visitor(1, VisitorType.BUSINESS_PERSON).appraiseLocation(new Location(LocationType.THE_CATHEDRAL_OF_LEARNING)));
    }
    
    @Test
    public void professorLikesSquirrelHill() {
        assertTrue(new Visitor(1, VisitorType.PROFESSOR).appraiseLocation(new Location(LocationType.SQUIRREL_HILL)));
    }
    
    @Test
    public void professorLikesDowntown() {
        assertTrue(new Visitor(1, VisitorType.PROFESSOR).appraiseLocation(new Location(LocationType.DOWNTOWN)));
    }
    
    @Test
    public void professorLikesThePoint() {
        assertTrue(new Visitor(1, VisitorType.PROFESSOR).appraiseLocation(new Location(LocationType.THE_POINT)));
    }
    
    @Test
    public void professorLikesTheCathedral() {
        assertTrue(new Visitor(1, VisitorType.PROFESSOR).appraiseLocation(new Location(LocationType.THE_CATHEDRAL_OF_LEARNING)));
    }
    
    @Test
    public void bloggerDoesNotLikeSquirrelHill() {
        assertFalse(new Visitor(1, VisitorType.BLOGGER).appraiseLocation(new Location(LocationType.SQUIRREL_HILL)));
    }
    
    @Test
    public void bloggerDoesNotLikeDowntown() {
        assertFalse(new Visitor(1, VisitorType.BLOGGER).appraiseLocation(new Location(LocationType.DOWNTOWN)));
    }
    
    @Test
    public void bloggerDoesNotLikeThePoint() {
        assertFalse(new Visitor(1, VisitorType.BLOGGER).appraiseLocation(new Location(LocationType.THE_POINT)));
    }
    
    @Test
    public void bloggerDoesNotLikeTheCathedral() {
        assertFalse(new Visitor(1, VisitorType.BLOGGER).appraiseLocation(new Location(LocationType.THE_CATHEDRAL_OF_LEARNING)));
    }
    
    @Test
    public void getPositiveAppraisal() {
        Visitor visitor = new Visitor(1, VisitorType.BLOGGER);
        assertEquals("Visitor 1 did like Downtown!", visitor.getAppraisalString(new Location(LocationType.DOWNTOWN), true));
    }
    
    @Test
    public void getNegativeAppraisal() {
        Visitor visitor = new Visitor(1, VisitorType.BLOGGER);
        assertEquals("Visitor 1 did not like Downtown.", visitor.getAppraisalString(new Location(LocationType.DOWNTOWN), false));
    }
}
