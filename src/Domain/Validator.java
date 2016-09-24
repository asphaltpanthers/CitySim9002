/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author AsphaltPanthers
 */
public class Validator {
    public static boolean validateArguments(String[] args) {
        return validateNumberOfArguments(args);
    }
    
    public static boolean validateNumberOfArguments(String[] args) {
        return args.length == 1;
    }
}
