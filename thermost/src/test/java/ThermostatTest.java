/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

// Create this file as ThermostatCACCTest.java
import org.junit.Test;
import static org.junit.Assert.*;

public class ThermostatTest {
    
    private class MockProgrammedSettings implements ProgrammedSettings {
        private int temperature;
        
        public MockProgrammedSettings(int temp) {
            this.temperature = temp;
        }
        
        @Override
        public int getSetting(Period period, DayType day) {
            return temperature;
        }
    }
    
    @Test
    public void testConditionTrue() {
        
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(65);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(false);      // No override (makes C2 false)
        thermostat.setOverTemp(70);         // Override temperature (not used)
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setPeriod(Period.MORNING);
        
        ProgrammedSettings settings = new MockProgrammedSettings(75); // dTemp = 75
        
        //  65 < 75-5 = TRUE
        //  false && anything = FALSE
        // 20 > 15 = TRUE
        // (TRUE || FALSE) && TRUE = TRUE
        assertTrue(thermostat.turnHeaterOn(settings));
        assertTrue(thermostat.getHeaterOn());
    }
    
    @Test
    public void testConditionFalse() {
       
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(75);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(false);      // No override (makes C2 false)
        thermostat.setOverTemp(70);         // Override temperature (not used)
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setPeriod(Period.MORNING);
        
        ProgrammedSettings settings = new MockProgrammedSettings(75); // dTemp = 75
        
        //  75 < 75-5 = FALSE
        //  false && anything = FALSE
        //  20 > 15 = TRUE
        // (FALSE || FALSE) && TRUE = FALSE
        assertFalse(thermostat.turnHeaterOn(settings));
        assertFalse(thermostat.getHeaterOn());
    }
    
    @Test
    public void testConTrue() {
        
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(75);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(true);       // Override is on
        thermostat.setOverTemp(85);         // Override temperature
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
       
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setPeriod(Period.MORNING);
        
        ProgrammedSettings settings = new MockProgrammedSettings(70); // dTemp = 70
        
        // 75 < 70-5 = FALSE
        // true && 75 < 85-5 = TRUE
        //  20 > 15 = TRUE
        // (FALSE || TRUE) && TRUE = TRUE
        assertTrue(thermostat.turnHeaterOn(settings));
        assertTrue(thermostat.getHeaterOn());
    }
    
    @Test
    public void testConFalse() {
        // C1 is false, C2 is false, C3 is true -> Overall should be false
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(75);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(true);       // Override is on
        thermostat.setOverTemp(75);         // Override temperature (not enough difference)
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setPeriod(Period.MORNING);
        
        ProgrammedSettings settings = new MockProgrammedSettings(70); // dTemp = 70
        
        //  75 < 70-5 = FALSE
        //  true && 75 < 75-5 = FALSE
        //  20 > 15 = TRUE
        //  (FALSE || FALSE) && TRUE = FALSE
        assertFalse(thermostat.turnHeaterOn(settings));
        assertFalse(thermostat.getHeaterOn());
    }
    
    @Test
    public void testC_True() {
        
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(65);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(false);      // No override
        thermostat.setOverTemp(70);         // Override temperature (not used)
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setPeriod(Period.MORNING);
        
        ProgrammedSettings settings = new MockProgrammedSettings(75); // dTemp = 75
        
        // 65 < 75-5 = TRUE
        //  false && anything = FALSE
        //  20 > 15 = TRUE
        //  (TRUE || FALSE) && TRUE = TRUE
        assertTrue(thermostat.turnHeaterOn(settings));
        assertTrue(thermostat.getHeaterOn());
    }
    
    @Test
    public void testCFalse() {
        
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(65);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(false);      // No override
        thermostat.setOverTemp(70);         // Override temperature (not used)
        thermostat.setTimeSinceLastRun(10); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setPeriod(Period.MORNING);
        
        ProgrammedSettings settings = new MockProgrammedSettings(75); // dTemp = 75
        
        //  65 < 75-5 = TRUE
        // false && anything = FALSE
        // 10 > 15 = FALSE
        // (TRUE || FALSE) && FALSE = FALSE
        assertFalse(thermostat.turnHeaterOn(settings));
        assertFalse(thermostat.getHeaterOn());
    }
}