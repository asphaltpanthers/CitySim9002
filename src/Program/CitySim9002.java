/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Domain.Validator;

/**
 *
 * @author AsphaltPanthers
 */
public class CitySim9002 {
    public static String errorMessage = "Please enter one integer argument, seed";
    
    public static int main(String[] args) {
        if (new Validator().validateArguments(args)) {
            return 0;
        }
        else {
            System.out.println(errorMessage);
            return -1;
        }
    }
}
