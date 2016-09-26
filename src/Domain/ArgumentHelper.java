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
public class ArgumentHelper {
    public static int getSeed(String[] args) {
        return Integer.parseInt(args[0]);
    }
}
