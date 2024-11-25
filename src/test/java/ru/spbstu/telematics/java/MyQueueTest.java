package ru.spbstu.telematics.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class MyQueueTest {
    private MyQueue<String> myQueue;
    private Queue<String> standardQueue;

    @BeforeEach
    void setUp() {
        standardQueue = new PriorityQueue<>();
        myQueue = new MyQueue<>();
    }

    @Test
    void testAddAndPeek() {
        standardQueue.add("A");
        myQueue.add("A");

        assertEquals(standardQueue.peek(), myQueue.peek());
    }

    @Test
    void testOfferAndPeek() {
        standardQueue.offer("B");
        myQueue.offer("B");

        assertEquals(standardQueue.peek(), myQueue.peek());
    }

    @Test
    void testRemove() {
        standardQueue.add("C");
        myQueue.add("C");

        assertEquals(standardQueue.remove(), myQueue.remove());
    }

    @Test
    void testPoll() {
        standardQueue.add("D");
        myQueue.add("D");

        assertEquals(standardQueue.poll(), myQueue.poll());
    }

    @Test
    void testSize() {
        standardQueue.add("E");
        myQueue.add("E");

        assertEquals(standardQueue.size(), myQueue.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(standardQueue.isEmpty());
        assertTrue(myQueue.isEmpty());

        standardQueue.add("F");
        myQueue.add("F");

        assertFalse(standardQueue.isEmpty());
        assertFalse(myQueue.isEmpty());
    }

    @Test
    void testContains() {
        standardQueue.add("G");
        myQueue.add("G");

        assertTrue(standardQueue.contains("G"));
        assertTrue(myQueue.contains("G"));

        assertFalse(standardQueue.contains("H"));
        assertFalse(myQueue.contains("H"));
    }

    @Test
    void testRemoveObject() {
        standardQueue.add("I");
        standardQueue.add("J");
        myQueue.add("I");
        myQueue.add("J");

        assertTrue(standardQueue.remove("I"));
        assertTrue(myQueue.remove("I"));

        assertFalse(standardQueue.contains("I"));
        assertFalse(myQueue.contains("I"));
    }

    @Test
    void testClear() {
        standardQueue.add("K");
        myQueue.add("K");

        standardQueue.clear();
        myQueue.clear();

        assertTrue(standardQueue.isEmpty());
        assertTrue(myQueue.isEmpty());
    }

    @Test
    void testEquals() {
        standardQueue.add("L");
        myQueue.add("L");

        standardQueue.add("M");
        myQueue.add("M");

        assertArrayEquals(standardQueue.toArray(), myQueue.toArray());
    }

    @Test
    void testIterator() {
        standardQueue.add("N");
        standardQueue.add("O");
        myQueue.add("N");
        myQueue.add("O");

        Iterator<String> standardIterator = standardQueue.iterator();
        Iterator<String> myQueueIterator = myQueue.iterator();

        while (standardIterator.hasNext() && myQueueIterator.hasNext()) {
            assertEquals(standardIterator.next(), myQueueIterator.next());
        }
    }

    @Test
    void testPollOnEmptyQueue() {
        assertNull(standardQueue.poll());
        assertNull(myQueue.poll());
    }

    @Test
    void testPeekOnEmptyQueue() {
        assertNull(standardQueue.peek());
        assertNull(myQueue.peek());
    }

    @Test
    void testRemoveFromEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> standardQueue.remove());
        assertThrows(NoSuchElementException.class, () -> myQueue.remove());
    }

    @Test
    void testElementOnEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> standardQueue.element());
        assertThrows(NoSuchElementException.class, () -> myQueue.element());
    }

    @Test
    void testOfferWithNull() {
        assertThrows(NullPointerException.class, () -> standardQueue.add(null));
        assertThrows(NullPointerException.class, () -> myQueue.add(null));
    }

    @Test
    void testAddWithNull() {
        assertThrows(NullPointerException.class, () -> standardQueue.add(null));
        assertThrows(NullPointerException.class, () -> myQueue.add(null));
    }



    @Test
    void testAddAll() {
        List<String> list = Arrays.asList("P", "Q", "R");
        standardQueue.addAll(list);
        myQueue.addAll(list);

        assertEquals(standardQueue.size(), myQueue.size());
        assertTrue(standardQueue.containsAll(list));
        assertTrue(myQueue.containsAll(list));
    }

    @Test
    void testRemoveAll() {
        List<String> list = Arrays.asList("S", "T");
        standardQueue.add("S");
        standardQueue.add("T");
        myQueue.add("S");
        myQueue.add("T");

        assertTrue(standardQueue.removeAll(list));
        assertTrue(myQueue.removeAll(list));

        assertFalse(standardQueue.containsAll(list));
        assertFalse(myQueue.containsAll(list));
    }

    @Test
    void testRetainAll() {
        standardQueue.add("U");
        standardQueue.add("V");
        myQueue.add("U");
        myQueue.add("V");

        List<String> list = Arrays.asList("U");
        assertTrue(standardQueue.retainAll(list));
        assertTrue(myQueue.retainAll(list));

        assertEquals(1, standardQueue.size());
        assertEquals(1, myQueue.size());
        assertTrue(standardQueue.contains("U"));
        assertTrue(myQueue.contains("U"));
    }

    @Test
    void testContainsAll() {
        standardQueue.add("W");
        standardQueue.add("X");
        myQueue.add("W");
        myQueue.add("X");

        List<String> list = Arrays.asList("W", "X");
        assertTrue(standardQueue.containsAll(list));
        assertTrue(myQueue.containsAll(list));

        list = Arrays.asList("Y");
        assertFalse(standardQueue.containsAll(list));
        assertFalse(myQueue.containsAll(list));
    }


    @Test
    void testToArray() {
        standardQueue.add("Y");
        standardQueue.add("Z");
        myQueue.add("Y");
        myQueue.add("Z");

        Object[] standardArray = standardQueue.toArray();
        Object[] myQueueArray = myQueue.toArray();

        assertArrayEquals(standardArray, myQueueArray);
    }

    @Test
    void testToArrayWithType() {
        standardQueue.add("A");
        myQueue.add("A");

        String[] standardArray = standardQueue.toArray(new String[0]);
        String[] myQueueArray = myQueue.toArray(new String[0]);

        assertArrayEquals(standardArray, myQueueArray);
    }
}
