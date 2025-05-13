/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import package softwareTestingAssignment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TriangleTypeTest {
    
   

    @org.junit.jupiter.api.Test
    public void testIfOnsizeequalZero() {
        
        TriangleType triangl = new TriangleType();
        
        assertEquals(Triangle.INVALID(triangl.triangle(0, 0, 0)));
        assertEquals(Triangle.INVALID (triangl.triangle(1, 2, 0)));
        assertEquals(Triangle.INVALID (triangl.triangle(0, 1, 2)));
        assertEquals(Triangle.INVALID (triangl.triangle(1, 0, 2)));
        
        // check equatorial triagle
        assertEquals(Triangle.EQUILATERAL (triangl.triangle(2, 2 , 2)));
        
        //cheick isoscel triangle 
        assertEqual(Triangle.ISOSCELES (triangl.triangle (2, 2, 5)));
        
        
        
    }
    
}
