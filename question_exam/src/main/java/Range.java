/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Range implements Iterable<Integer> {
    private int start, end;
    
    /**
     * Constructor to create a range from start (inclusive) to end (exclusive)
     */
    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }
    
    /**
     * Inner class that implements the Iterator interface
     */
    private class RangeIterator implements Iterator<Integer> {
        private int cursor;
        
        public RangeIterator() {
            this.cursor = start;
        }
        
        @Override
        public boolean hasNext() {
            return this.cursor < end;
        }
        
        @Override
        public Integer next() {
            if(this.hasNext()) {
                int current = cursor;
                cursor++;
                return current;
            }
            throw new NoSuchElementException();
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Range range = new Range(1, 5);
        
        // Using for-each loop (which uses iterator internally)
        System.out.println("Using for-each loop:");
        for(Integer num : range) {
            System.out.print(num + " ");
        }
        
        // Using iterator explicitly
        System.out.println("\n\nUsing iterator explicitly:");
        Iterator<Integer> it = range.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
