package com.assignment.gfk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.assignment.gfk.exceptions.ApplicationException;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

@RunWith(JUnit4.class)
public class ComputeDiffOfDigitsInArabicAndRomanNumsTest {
   
	private ComputeDiffOfDigitsInArabicAndRomanNums cmpDiff;
	
	
	@Rule
    public TestRule benchmarkRun = new BenchmarkRule();
	
	@Before
	public void setup() {
		this.cmpDiff = new ComputeDiffOfDigitsInArabicAndRomanNums();
	}
	
	
	public void testComputeDiffOfCharactersWithNumbers() {
		assertEquals(3108, cmpDiff.computeDiffOfCharacters(1, 1000));
	} 
	
	@Test
	public void testComputeDiffOfCharactersWithCharacter() {
		assertNotSame(3108, cmpDiff.computeDiffOfCharacters('A', 1000));
	}
	
	
	@Test(expected=NoSuchElementException.class)
	public void testComputeDiffOfCharactersWithInvalidInputs() {
		cmpDiff.computeDiffOfCharacters(1000, 1);
	}
	
	@Test
	public void testComputeDiffOfCharactersWithNegativeValues() {
		assertEquals(-6, cmpDiff.computeDiffOfCharacters(-3, -1));
	}
	
	@BenchmarkOptions(callgc = false, benchmarkRounds = 2, warmupRounds = 0)
	@Test
	public void testProcessRequestMethodWithValidInputs() {

		 String input1 = "1 1000";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);

		 assertEquals("SUCCESS", cmpDiff.processRequest(cmpDiff));
	}
	
	@BenchmarkOptions(callgc = false, benchmarkRounds = 2, warmupRounds = 0)
	@Test
	public void testProcessRequestMethodWithWideRangeOfInputs() {
		 String input1 = "1 100000";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);
		 
		 assertEquals("SUCCESS", cmpDiff.processRequest(cmpDiff));
		 
	}
	
	
	@Test(expected=ApplicationException.class)
	public void testProcessRequestMethodWithInvalidInput() {

		 String input1 = "ABC 1000";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);

		 cmpDiff.processRequest(cmpDiff);
	}
	
}
