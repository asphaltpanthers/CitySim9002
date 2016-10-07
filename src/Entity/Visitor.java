/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Enum.LocationType;
import Entity.Enum.VisitorType;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AsphaltPanthers
 */
public class Visitor {
    private final int num;
    private final VisitorType type;
    private final City city;
    
    public Visitor(int num, VisitorType type) {
        this.num = num;
        this.type = type;
        this.city = new City();
    }
    
    public ArrayList<String> tour(Random generator) {
        ArrayList<String> visits = new ArrayList<>();
        
        visits.add("Visitor " + num + " is a " + type.value + ".");
        
        boolean firstIteration = true;
        do {
            Location visiting = city.getRandomLocation(generator);
            if (visiting.getLocationType() == LocationType.LEAVE) {
                visits.add("Visitor " + num + " has left the city.");
                break;
            }
            else {
                visits.add("Visitor " + num + " is going to " + visiting.getLocationType().value + "!");
                visits.add(getAppraisalString(visiting, appraiseLocation(visiting)));
            }
            if (firstIteration) {
                city.addLocation(new Location(LocationType.LEAVE));
                firstIteration = false;
            }
        } while (true);
        
        visits.add("***");
        
        return visits;
    }
    
    public boolean appraiseLocation(Location location) {
        if (type == VisitorType.STUDENT) {
            return location.getLocationType() == LocationType.SQUIRREL_HILL ||
                    location.getLocationType() == LocationType.DOWNTOWN ||
                    location.getLocationType() == LocationType.THE_POINT;
        }
        if (type == VisitorType.BUSINESS_PERSON) {
            return location.getLocationType() == LocationType.SQUIRREL_HILL ||
                    location.getLocationType() == LocationType.DOWNTOWN;
        }
        return type == VisitorType.PROFESSOR;
    }
    
    public String getAppraisalString(Location location, boolean liked) {
        if (liked) {
            return "Visitor " + num + " did like " + location.getLocationType().value + "!";
        }
        return "Visitor " + num + " did not like " + location.getLocationType().value + ".";
    }
    
    public VisitorType getVisitorType() {
        return type;
    }
    
    public City getCity() {
        return city;
    }
}
