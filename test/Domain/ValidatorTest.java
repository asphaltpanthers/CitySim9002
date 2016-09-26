/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author AsphaltPanthers
 */
public class ValidatorTest {
    @Test
    public void ifOneArgumentIsProvidedReturnTrue() {
        Assert.assertTrue(new Validator().validateNumberOfArguments(new String[] { "1" }));
    }
    
    @Test
    public void ifOneArgumentIsNotProvidedReturnFalse() {
        Assert.assertFalse(new Validator().validateNumberOfArguments(new String[] { "1", "2" }));
    }
    
    @Test
    public void ifArgumentIsAnIntegerReturnTrue() {
        Assert.assertTrue(new Validator().validateArgumentType(new String[] { "1" }));
    }
    
    @Test
    public void ifArgumentIsNotAnIntegerReturnFalse() {
        Assert.assertFalse(new Validator().validateArgumentType(new String[] { "test" }));
    }
    
    @Test
    public void ifNumberOfArgumentsAndArgumentTypeIsCorrect() {
        Validator mockValidator = mock(Validator.class);
        when(mockValidator.validateNumberOfArguments(any(String[].class))).thenReturn(true);
        when(mockValidator.validateArgumentType(any(String[].class))).thenReturn(true);
        when(mockValidator.validateArguments(any(String[].class))).thenCallRealMethod();
        
        Assert.assertTrue(mockValidator.validateArguments(new String[0]));
    }
    
    @Test
    public void ifNumberOfArgumentsIsIncorrect() {
        Validator mockValidator = mock(Validator.class);
        when(mockValidator.validateNumberOfArguments(any(String[].class))).thenReturn(false);
        when(mockValidator.validateArgumentType(any(String[].class))).thenReturn(true);
        when(mockValidator.validateArguments(any(String[].class))).thenCallRealMethod();
        
        Assert.assertFalse(mockValidator.validateArguments(new String[0]));
    }
    
    @Test
    public void ifArgumentTypeIsIncorrect() {
        Validator mockValidator = mock(Validator.class);
        when(mockValidator.validateNumberOfArguments(any(String[].class))).thenReturn(true);
        when(mockValidator.validateArgumentType(any(String[].class))).thenReturn(false);
        when(mockValidator.validateArguments(any(String[].class))).thenCallRealMethod();
        
        Assert.assertFalse(mockValidator.validateArguments(new String[0]));
    }
}
