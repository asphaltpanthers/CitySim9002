/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Entity.Enum.VisitorType;
import Entity.Visitor;
import java.util.Random;
import java.util.function.Consumer;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author AsphaltPanthers
 */
public class VisitorHelperTest {
    @Test
    public void initReturnsFiveVisitors() {
        VisitorHelper helper = mock(VisitorHelper.class);
        when(helper.getRandomVisitorType(any(Random.class))).thenReturn(VisitorType.BLOGGER);
        when(helper.initVisitors(any(Random.class))).thenCallRealMethod();
        
        assertEquals(5, helper.initVisitors(new Random(1)).size());
    }
    
    @Test
    public void initReturnsCorrectVisitorTypes() {
        VisitorHelper helper = mock(VisitorHelper.class);
        when(helper.getRandomVisitorType(any(Random.class))).thenReturn(VisitorType.BLOGGER);
        when(helper.initVisitors(any(Random.class))).thenCallRealMethod();
        
        helper.initVisitors(new Random(1)).stream().forEach((Visitor visitor) -> {
            assertEquals(VisitorType.BLOGGER, visitor.getVisitorType());
        });
    }
    
    @Test
    public void RandomVisitorReturnsBlogger() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(24);
        
        assertEquals(VisitorType.BLOGGER, new VisitorHelper().getRandomVisitorType(mockRandom));
    }
    
    @Test
    public void RandomVisitorReturnsBusinessPersonLowerBound() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(25);
        
        assertEquals(VisitorType.BUSINESS_PERSON, new VisitorHelper().getRandomVisitorType(mockRandom));
    }
    
    @Test
    public void RandomVisitorReturnsBusinessPersonUpperBound() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(49);
        
        assertEquals(VisitorType.BUSINESS_PERSON, new VisitorHelper().getRandomVisitorType(mockRandom));
    }
    
    @Test
    public void RandomVisitorReturnsProfessorLowerBound() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(50);
        
        assertEquals(VisitorType.PROFESSOR, new VisitorHelper().getRandomVisitorType(mockRandom));
    }
    
    @Test
    public void RandomVisitorReturnsProfessorUpperBound() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(74);
        
        assertEquals(VisitorType.PROFESSOR, new VisitorHelper().getRandomVisitorType(mockRandom));
    }
    
    @Test
    public void RandomVisitorReturnsStudent() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(75);
        
        assertEquals(VisitorType.STUDENT, new VisitorHelper().getRandomVisitorType(mockRandom));
    }
}
