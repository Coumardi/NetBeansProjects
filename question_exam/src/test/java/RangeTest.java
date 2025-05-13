/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

/**
 *
 * @author 13202
 */

import java.util.Iterator;

public class RangeTest {

    @Test
    public void testForTrueWhenItemsInRange() {
        Range ran = new Range(1, 5); 
        Iterator<Integer> it = ran.iterator();
        assertTrue(it.hasNext());
    }

    @Test 
    public void testForFalseWhenEmpty() {
        Range empRan = new Range(1, 1); // No values in range
        Iterator<Integer> it = empRan.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void testForAfterRemovingItem() {
        Range ran = new Range(1, 3);
        Iterator<Integer> it = ran.iterator();

        it.next(); 
        it.next();

        assertFalse(it.hasNext()); //  false after 2 items
    }

    @Test
    public void testForReturningItemInOrder() {
        Range ran = new Range(3, 6); 
        Iterator<Integer> it = ran.iterator();

        assertEquals(Integer.valueOf(3), it.next());
        assertEquals(Integer.valueOf(4), it.next());
        assertEquals(Integer.valueOf(5), it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testForAllElementThenHasNextShouldReturnFalse() {
        Range ran = new Range(1, 4); // 
        Iterator<Integer> it = ran.iterator();

        assertTrue(it.hasNext());
        assertEquals(Integer.valueOf(1), it.next());

        assertTrue(it.hasNext());
        assertEquals(Integer.valueOf(2), it.next());

        assertTrue(it.hasNext());
        assertEquals(Integer.valueOf(3), it.next());

        assertFalse(it.hasNext()); // no more items
    }
    
    @Test
   (expected = UnsupportedOperationException.class)
public void testRemoveThrowsException() {
    Range range = new Range(1, 5);
    Iterator<Integer> iterator = range.iterator();
    iterator.remove();  // throw the exception
}
}
