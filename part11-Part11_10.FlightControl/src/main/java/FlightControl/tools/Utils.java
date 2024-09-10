/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.tools;

/**
 *
 * @author mefferio
 */
public final class Utils {
    
    public static String sanitizedID(String ID){
        if (ID == null){
            ID = "";
        }
        return ID.trim().toUpperCase();
    }
}
