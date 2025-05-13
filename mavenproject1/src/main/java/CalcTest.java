/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
import org.junit.Test;
import static org.junit.Assert.*;
public class CalcTest {
    
    @Test public void testAdd()
    {
        assertTrue("Calc sum incorrect", 
                5== Calc.add(2, 3));
    
    }
    
}
