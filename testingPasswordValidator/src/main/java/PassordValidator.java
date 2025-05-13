/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class PassordValidator {
    // validate the password 
    // a valid password is not:
    // not null 
    // has a lenght between 8 and 20 characters
    // contain at least one letter
    // contains at least one digit
    
    
    public boolean isValidPassword(String password) {
        
        if(password == null){
            throw new IllegalArgumentException("Password connot be null");
            
        
        }
        
        int length = password.length();
        if(length < 8 || length >20){
            
            throw new IllegalArgumentException("Password must be between 8 and 20 character long");
            
        
        }
        
        boolean hasLetter = false;
        boolean hasDigit = false;
        
        for(int i =0; i < password.length(); i++){
            char c = password.charAt(i);
            if(Character.isLetter(c)){
                hasLetter = true;
            
            
            } else if (Character.isDigit(c)){
                hasDigit = true;
            
            }
        
        
        }
        if(!hasLetter || !hasDigit){
            throw new IllegalArgumentException("Password must contain at least one letter and one didit");
            
        
        
        }
        return true;
    
    
    }
}
