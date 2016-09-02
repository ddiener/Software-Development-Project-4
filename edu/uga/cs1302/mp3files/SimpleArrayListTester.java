package edu.uga.cs1302.mp3files;

import static org.junit.Assert.*;
import java.util.ListIterator;
import org.junit.*;
import java.util.*;

public class SimpleArrayListTester {

    SimpleArrayList<String> strings = new SimpleArrayList<String>();
    @Before
	public void setUp() {
	strings.add("one");
	strings.add("two");
	strings.add("three");
	strings.add("four");
	strings.add("five");
    }
    
    //Test 1: This tests the method hasPrevious() which should return false in this instance.
    //TEST ILLEGAL MANUVER
    @Test
	public void illegalHasPreviousTester() {
	ListIterator<String> testIter = strings.listIterator(0);
	assertEquals(testIter.hasPrevious(), false);
    }
    
    //Test 2: Places iterator in middle of list, calls functioning method.
    @Test
	public void hasPreviousTester() {
	ListIterator<String> testIter = strings.listIterator(2);
	assertEquals(testIter.hasPrevious(), true);
    }
    
    //Test 3: This tests the previous index call which should return a -1 in this instance.
    //TEST ILLEGAL MANUVER
    @Test
	public void illegalPreviousIndexTester() {
	ListIterator<String> testIter = strings.listIterator(0);
	assertEquals(testIter.previousIndex(), -1);
    }
    
    //Test 4: This tests the previous index call with a legal argument.
    @Test
	public void previousIndexTester() {
	ListIterator<String> testIter = strings.listIterator(3);
	assertEquals(testIter.previousIndex(), 1);
    }
    
    
    //Test 5: This tests the has next call which should return true.
    @Test
	public void hasNextTester() {
	ListIterator<String> testIter = strings.listIterator(0);
	assertEquals(testIter.hasNext(), true);
    }
    
    //Test 6: This tests the has next call in an illegal circumstance.
    //ILLEGAL CASE
    @Test
	public void illegalHasNextTester() {
	ListIterator<String> testIter = strings.listIterator(5);
	assertEquals(testIter.hasNext(), false);
    }
    
    //Test 7: This tests the call to next.
    @Test
	public void nextTester() {
	ListIterator<String> testIter = strings.listIterator(0);
	assertEquals(testIter.next(), "one");
    }

    //Test 8: This tests the call to next under illegal cirumstances.
    //ILLEGAL CASE
    @Test (expected = NoSuchElementException.class )
	public void illegalNextTester() {
	ListIterator<String> testIter = strings.listIterator(5);
	testIter.next();
    }
    
    //Test 9: This tests the call to previous.
    @Test
	public void previousTester() {
	ListIterator<String> testIter = strings.listIterator(1);
	assertEquals(testIter.previous(), "two");
    }
    
    //Test 10: This tests the call to previous in exceptional circumstances.
    //ILLEGAL CASE
    @Test ( expected = NoSuchElementException.class )
	public void illegalPreviousTester() {
	ListIterator<String> testIter = strings.listIterator(0);
	testIter.previous();
    }
    
    //Test 11: This tests the call to next index.
    @Test 
	public void nextIndexTester() {
	ListIterator<String> testIter = strings.listIterator(1);
	assertEquals(testIter.nextIndex(), 3);
    }
    
    //Test 12: This tests the call to next index under exceptional cirumstances.
    //ILLEGAL CASE
    @Test 
	public void illegalNextIndex() {
	ListIterator<String> testIter = strings.listIterator(4);
	assertEquals(testIter.nextIndex(), 6);
    }
}
