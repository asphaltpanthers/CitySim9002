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
public class StringHelper {
    public static String getErrorString() {
        return "Please enter one integer argument, seed";
    }
    
    public static String getWelcomeString(int seed) {
        return "Welcome to CitySim! Your seed is " + seed + ".";
    }
}
