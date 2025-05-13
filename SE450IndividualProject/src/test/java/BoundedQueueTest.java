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
public class BoundedQueueTest {
    
    @Test
    public void testCapacityGreaterThanZero(){
        BoundedQueue bon = new BoundedQueue(7);
        
        assertTrue(bon.isEmpty());
        assertFalse(bon.isFull());
        
    
    }
    
    @Test
    public void testCapacityLessthanZer() {
        //BoundedQueue bon = new BoundedQueue(-4);
        assertThrows(IllegalArgumentException.class,() -> new BoundedQueue(-4));
    
    }
    
    @Test 
    public void testNormalEnqueue() {
        
        BoundedQueue qu = new BoundedQueue(5);
        qu.enQueue("L");
            assertFalse(qu.isEmpty());
    
    
    }
    @Test
    public void testNullEnqueue() {
        BoundedQueue Q = new BoundedQueue(2);
        assertThrows(NullPointerException.class,() -> Q.enQueue(null));
        
    }
   
    
    
    
}

 