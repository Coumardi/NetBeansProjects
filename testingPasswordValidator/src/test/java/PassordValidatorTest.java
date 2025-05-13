/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 13202
 */
public class PassordValidatorTest {
    
    PassordValidator valid = new PassordValidator();
    
    @Test
    public void testingCorrectCombiOfPassword(){
        
       String password = "cdf21234";
        
        assertTrue(valid.isValidPassword(password));
    
    }
    
    @Test
    public void testingequalNumberOfDigitAndLetter(){
        
        String password = "1e2r2f5b";
        
        assertTrue(valid.isValidPassword(password));
    
    
    }
    
    @Test
    public void testingShortPasswordLenght(){
        
        String password = "af2";
        
        assertThrows(IllegalArgumentException.class, () ->valid.isValidPassword(password)); // trying assertFalse
    
    
    }
    
    @Test 
    public void testingLongPassword() {
        
        String password = "dfghjlskdjj23ey0930898e8798978798";
        
        assertThrows(IllegalArgumentException.class, () -> valid.isValidPassword(password));
        
      
             
               
        }
    
    
    
    
    
    
    
    
    
    
   
    
}

