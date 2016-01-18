/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.main;

import java.security.MessageDigest;
import java.util.stream.Stream;

/**
 *
 * @author bernd_000
 */
public class PasswordManager {
    public String saltPassword(char[] password, byte[] salt){ 
         //Typecast char arrays to string before concatenating 
         String strPassword = String.valueOf(password); 
         String strSalt = new String(salt); 
          
         //Salt password & return 
         return strPassword + strSalt; 
    } 
    
    public String hashPassword(byte[] saltedPassword){ 
        byte[] hashedPassword = new byte[0]; 
            
        //Hash password 
        try { 
            MessageDigest m = MessageDigest.getInstance("MD5"); 
            hashedPassword = m.digest(saltedPassword); 
        } catch(Exception ex){ 
            System.out.println("failed to hash password");
        } 
              
        //Make empty string to contain hashedPassword (convert from byte[] to string) 
        return byteArrayToString(hashedPassword); 
    } 

    public String byteArrayToString(byte[] array){ 
        //Make empty string to contain hashedPassword (convert from byte[] to string) 
        String string = ""; 
        //Loop trough array to format from hex to string 
        for(byte b : array) { 
            string += String.format("%02x", b); 
        }
        
        return string; 
    }
}
