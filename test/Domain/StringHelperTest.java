/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author AsphaltPanthers
 */
public class StringHelperTest {
    @Test
    public void getErrorStringReturnsStaticString() {
        assertEquals("Please enter one integer argument, seed", StringHelper.getErrorString());
    }
    
    @Test
    public void getWelcomStringReturnsWelcomePlusSeed() {
        assertEquals("Welcome to CitySim! Your seed is 1.", StringHelper.getWelcomeString(1));
    }
}
