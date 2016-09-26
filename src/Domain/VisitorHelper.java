/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Entity.Enum.VisitorType;
import Entity.Visitor;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AsphaltPanthers
 */
public class VisitorHelper {
    public ArrayList<Visitor> initVisitors(Random generator) {
        ArrayList<Visitor> visitors = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            visitors.add(new Visitor(getRandomVisitorType(generator)));
        }
        
        return visitors;
    }
    
    public VisitorType getRandomVisitorType(Random generator) {
        int randomNum = generator.nextInt(100);
        if (randomNum < 25) {
            return VisitorType.BLOGGER;
        }
        else if (randomNum >= 25 && randomNum < 50) {
            return VisitorType.BUSINESS_PERSON;
        }
        else if (randomNum >= 50 && randomNum < 75) {
            return VisitorType.PROFESSOR;
        }
        else {
            return VisitorType.STUDENT;
        }
    }
}
