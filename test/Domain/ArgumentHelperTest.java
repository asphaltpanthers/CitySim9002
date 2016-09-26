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
public class ArgumentHelperTest {
    @Test
    public void getSeedReturnsSeed() {
        assertEquals(1, ArgumentHelper.getSeed(new String[] { "1" }));
    }
}
