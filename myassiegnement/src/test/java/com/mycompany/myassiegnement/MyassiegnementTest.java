/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.myassiegnement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 13202
 */
public class MyassiegnementTest {
    
    public MyassiegnementTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class Myassiegnement.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Myassiegnement.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPrimeNumber method, of class Myassiegnement.
     */
    @Test
    public void testIsPrimeNumber() {
        System.out.println("isPrimeNumber");
        int p = 0;
        Myassiegnement instance = new Myassiegnement();
        boolean expResult = false;
        boolean result = instance.isPrimeNumber(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterate method, of class Myassiegnement.
     */
    @Test
    public void testIterate() {
        System.out.println("iterate");
        Myassiegnement instance = new Myassiegnement();
        instance.iterate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Myassiegnement.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int numb = 0;
        Myassiegnement instance = new Myassiegnement();
        String expResult = "";
        String result = instance.toString(numb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
