/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.time.Period;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 13202
 */
public class ProgrammedSettingsTest {
    
    public ProgrammedSettingsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSetting method, of class ProgrammedSettings.
     */
    @Test
    public void testSetSetting() {
        System.out.println("setSetting");
        Period period = null;
        DayType day = null;
        int temp = 0;
        ProgrammedSettings instance = new ProgrammedSettings();
        instance.setSetting(period, day, temp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSetting method, of class ProgrammedSettings.
     */
    @Test
    public void testGetSetting() {
        System.out.println("getSetting");
        Period period = null;
        DayType day = null;
        ProgrammedSettings instance = new ProgrammedSettings();
        int expResult = 0;
        int result = instance.getSetting(period, day);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
