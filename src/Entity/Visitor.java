/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Domain.StringHelper;
import Entity.Enum.LocationType;
import Entity.Enum.VisitorType;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AsphaltPanthers
 */
public class Visitor {
    public int num;
    public VisitorType type;
    
    public Visitor(int num, VisitorType type) {
        this.num = num;
        this.type = type;
    }
    
    public ArrayList<String> tour(Random generator) {
        ArrayList<String> visits = new ArrayList<>();
        
        visits.add("Visitor " + num + " is a " + type.value + ".");
        
        City city = new City();
        boolean firstIteration = true;
        do {
            Location visiting = city.getRandomLocation(generator);
            if (visiting.name == LocationType.LEAVE) {
                visits.add("Visitor " + num + " has left the city.");
                break;
            }
            else {
                visits.add("Visitor " + num + " is going to " + visiting.name.value + "!");
                visits.add(appraiseLocation(visiting));
            }
            if (firstIteration) {
                city.addLocation(new Location(LocationType.LEAVE));
                firstIteration = false;
            }
        } while (true);
        
        visits.add("***");
        
        return visits;
    }
    
    public String appraiseLocation(Location location) {
        if (type == VisitorType.STUDENT) {
            if (location.name == LocationType.SQUIRREL_HILL ||
                    location.name == LocationType.DOWNTOWN ||
                    location.name == LocationType.THE_POINT) {
                return StringHelper.getAppraisalString(num, location, true);
            }
            else {
                return StringHelper.getAppraisalString(num, location, false);
            }
        }
        if (type == VisitorType.BUSINESS_PERSON) {
            if (location.name == LocationType.SQUIRREL_HILL ||
                    location.name == LocationType.DOWNTOWN) {
                return StringHelper.getAppraisalString(num, location, true);
            }
            else {
                return StringHelper.getAppraisalString(num, location, false);
            }
        }
        if (type == VisitorType.PROFESSOR) {
            return StringHelper.getAppraisalString(num, location, true);
        }
        else {
            return StringHelper.getAppraisalString(num, location, false);
        }
    }
}
