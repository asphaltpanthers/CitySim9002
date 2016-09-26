/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Domain.ArgumentHelper;
import Domain.StringHelper;
import Domain.Validator;
import Domain.VisitorHelper;
import Entity.Visitor;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AsphaltPanthers
 */
public class CitySim9002 {
    public static void main(String[] args) {
        if (new Validator().validateArguments(args)) {
            int seed = ArgumentHelper.getSeed(args);
            System.out.println(StringHelper.getWelcomeString(seed));
            
            Random generator = new Random(seed);
            
            ArrayList<Visitor> visitors = new VisitorHelper().initVisitors(generator);
            visitors.stream().forEach((Visitor visitor) -> {
                visitor.tour(generator).stream().forEach(System.out::println);
            });
        }
        else {
            System.out.println(StringHelper.getErrorString());
        }
    }
}
