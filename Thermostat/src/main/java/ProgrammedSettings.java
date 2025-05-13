
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class ProgrammedSettings {
    
    private final Map<String, Integer> settings = new HashMap<>();
    
    public void setSetting(Period period , DayType day, int temp){
        
        String key = period.toString() + "_" + day.toString();
        settings.put(key, temp);
        
        
    
    
    }
    public int getSetting(Period period, DayType day){
        String key = period.toString() + "_" + day.toString();
        return settings.getOrDefault(key, 65);
    
    }
}
