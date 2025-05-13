import org.junit.Test;
import static org.junit.Assert.*;

public class ThermostatCACCTest {
    
    // Mock class for ProgrammedSettings
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
    public void testC1DeterminesOutcome_True() {
        // C1 is true, C2 is false, C3 is true -> Overall should be true
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(65);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(false);      // No override (makes C2 false)
        thermostat.setOverTemp(70);         // Override temperature (not used)
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        ProgrammedSettings settings = new MockProgrammedSettings(75); // dTemp = 75
        
        // C1: 65 < 75-5 = TRUE
        // C2: false && anything = FALSE
        // C3: 20 > 15 = TRUE
        // Result: (TRUE || FALSE) && TRUE = TRUE
        assertTrue(thermostat.turnHeaterOn(settings));
    }
    
    @Test
    public void testC1DeterminesOutcome_False() {
        // C1 is false, C2 is false, C3 is true -> Overall should be false
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(75);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(false);      // No override (makes C2 false)
        thermostat.setOverTemp(70);         // Override temperature (not used)
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        ProgrammedSettings settings = new MockProgrammedSettings(75); // dTemp = 75
        
        // C1: 75 < 75-5 = FALSE
        // C2: false && anything = FALSE
        // C3: 20 > 15 = TRUE
        // Result: (FALSE || FALSE) && TRUE = FALSE
        assertFalse(thermostat.turnHeaterOn(settings));
    }
    
    @Test
    public void testC2DeterminesOutcome_True() {
        // C1 is false, C2 is true, C3 is true -> Overall should be true
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(75);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(true);       // Override is on
        thermostat.setOverTemp(85);         // Override temperature
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        ProgrammedSettings settings = new MockProgrammedSettings(70); // dTemp = 70
        
        // C1: 75 < 70-5 = FALSE
        // C2: true && 75 < 85-5 = TRUE
        // C3: 20 > 15 = TRUE
        // Result: (FALSE || TRUE) && TRUE = TRUE
        assertTrue(thermostat.turnHeaterOn(settings));
    }
    
    @Test
    public void testC2DeterminesOutcome_False() {
        // C1 is false, C2 is false, C3 is true -> Overall should be false
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(75);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(true);       // Override is on
        thermostat.setOverTemp(75);         // Override temperature (not enough difference)
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        ProgrammedSettings settings = new MockProgrammedSettings(70); // dTemp = 70
        
        // C1: 75 < 70-5 = FALSE
        // C2: true && 75 < 75-5 = FALSE
        // C3: 20 > 15 = TRUE
        // Result: (FALSE || FALSE) && TRUE = FALSE
        assertFalse(thermostat.turnHeaterOn(settings));
    }
    
    @Test
    public void testC3DeterminesOutcome_True() {
        // C1 is true, C2 is false, C3 is true -> Overall should be true
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(65);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(false);      // No override
        thermostat.setOverTemp(70);         // Override temperature (not used)
        thermostat.setTimeSinceLastRun(20); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        ProgrammedSettings settings = new MockProgrammedSettings(75); // dTemp = 75
        
        // C1: 65 < 75-5 = TRUE
        // C2: false && anything = FALSE
        // C3: 20 > 15 = TRUE
        // Result: (TRUE || FALSE) && TRUE = TRUE
        assertTrue(thermostat.turnHeaterOn(settings));
    }
    
    @Test
    public void testC3DeterminesOutcome_False() {
        // C1 is true, C2 is false, C3 is false -> Overall should be false
        Thermostat thermostat = new Thermostat();
        thermostat.setCurrentTemp(65);      // Current temperature
        thermostat.setThresholdDiff(5);     // Threshold difference
        thermostat.setOverride(false);      // No override
        thermostat.setOverTemp(70);         // Override temperature (not used)
        thermostat.setTimeSinceLastRun(10); // Time since last run
        thermostat.setMinLag(15);           // Minimum lag time
        
        ProgrammedSettings settings = new MockProgrammedSettings(75); // dTemp = 75
        
        // C1: 65 < 75-5 = TRUE
        // C2: false && anything = FALSE
        // C3: 10 > 15 = FALSE
        // Result: (TRUE || FALSE) && FALSE = FALSE
        assertFalse(thermostat.turnHeaterOn(settings));
    }
}