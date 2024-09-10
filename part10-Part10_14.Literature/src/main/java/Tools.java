/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Tools {
    static String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim();
    }
    
    static boolean ageIsNotNegative(int age){
        return age >= 0;
    }
}
