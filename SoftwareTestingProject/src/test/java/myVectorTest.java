/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import org.junit.jupiter.api.Test;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 13202
 */
public class myVectorTest {
    
    @Test
    public void testingVectorWithOnlyInteger(){
        
        Vector vec1 = new Vector();
        vec1.add(1);
        vec1.add(2);
        vec1.add(3);
        
        
        Vector vec2 = new Vector();
        vec2.add(4);
        vec2.add(5);
        vec2.add(6);
        
        Vector vec3 = new Vector();
        
        vec3.add(1);
        vec3.add(2);
        vec3.add(3);
        vec3.add(4);
        vec3.add(5);
        vec3.add(6);
        
        
        assertEquals(vec3, myVector.union(vec1 ,vec2));
        
        
            
    }
    
    @Test
    public void testingVectorWithEmpty(){
        
        Vector vec1 = new Vector();
        vec1.add("");
        vec1.add("");
        vec1.add("");
        
        
        Vector vec2 = new Vector();
        vec2.add(3);
        vec2.add(4);
        vec2.add(5);
        
        Vector vec3 = new Vector();
        
        vec3.add(1);
        vec3.add(2);
        vec3.add(3);
        vec3.add(4);
        vec3.add(5);
        vec3.add(6);
        
        
        assertNotEquals(vec3, myVector.union(vec1 ,vec2));
    }
    
       
}
