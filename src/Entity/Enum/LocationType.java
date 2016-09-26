/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Enum;

/**
 *
 * @author AsphaltPanthers
 */
public enum LocationType {
    THE_CATHEDRAL_OF_LEARNING("The Cathedral of Learning"),
    SQUIRREL_HILL("Squirrel Hill"),
    THE_POINT("The Point"),
    DOWNTOWN("Downtown"),
    LEAVE("");
    
    public String value;
    LocationType(String value) {
        this.value = value;
    }
}
