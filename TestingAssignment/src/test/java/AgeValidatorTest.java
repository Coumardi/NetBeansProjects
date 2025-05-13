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
public class AgeValidatorTest {
    
    private final AgeValidator ageValidator = new AgeValidator();

	// testing age below zero
	
	@Test
	public void testAgeBelowZero() {
		assertFalse (ageValidator.isValidAge(-1));
		
	}
	
	// testing age at zero
	
	@Test
	public void testAgeBelowAtZero() {
		assertTrue (ageValidator.isValidAge(0));
		
	}
	
	// testing age at 40
	
	@Test
	public void testAgeInRange() {
		assertTrue (ageValidator.isValidAge(40));
		
	}
	
	// testing age at 150
	
	@Test
	public void testAgeAt150() {
		assertTrue (ageValidator.isValidAge(150));
		
	}
	
	@Test
	public void testAgeAbove150() {
		assertFalse (ageValidator.isValidAge(160));
		
	}
        
        @Test 
        public void testAge300() {
            assertFalse(ageValidator.isValidAge(300));
        
        }
    
    
  
    
}
