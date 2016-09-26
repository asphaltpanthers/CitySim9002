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
public enum VisitorType {
    STUDENT("Student"),
    PROFESSOR("Professor"),
    BUSINESS_PERSON("Business Person"),
    BLOGGER("Blogger");
    
    public String value;
    VisitorType(String value) {
        this.value = value;
    }
}
