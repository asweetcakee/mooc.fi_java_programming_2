/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author mefferio
 */
public class Utils {
    public static String sanitizedString(String string){
        return string != null ? string.trim().toLowerCase() : "";
    }
    
    public static boolean isDictionaryNullorEmpty(Dictionary dict){
        return dict == null || dict.isEmpty();
    }
}
