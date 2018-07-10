package com.assignment.gfk;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.assignment.gfk.exceptions.ApplicationException;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

@RunWith(JUnit4.class)
public class CountOfDOWAsBeginingOfMonthTest {
   
	private CountOfDOWAsBeginingOfMonth cntDowBegMon = new CountOfDOWAsBeginingOfMonth();
	
	@Rule
    public TestRule benchmarkRun = new BenchmarkRule();
	
	
	@BenchmarkOptions(callgc = false, benchmarkRounds = 2, warmupRounds = 0)
	@Test
	public void testProcessRequestPerformanceWithValidInput() {
		
		 String input1 = "1901 2000 SUNDAY";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);
		 
		 assertEquals("SUCCESS", cntDowBegMon.processRequest(cntDowBegMon));
	}
	
	//It's a performance test with valid inputs
	@BenchmarkOptions(callgc = false, benchmarkRounds = 2, warmupRounds = 0)
	@Test
	public void testProcessRequestPerformanceWithWideRangeOfValidInput() {
		
		 String input1 = "1901 3000 SUNDAY";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);
		 
		 cntDowBegMon.processRequest(cntDowBegMon);
	}
	
	//It's a performance test with invalid inputs
	@BenchmarkOptions(callgc = false, benchmarkRounds = 2, warmupRounds = 0)
	@Test(expected=ApplicationException.class)
	public void testProcessRequestPerformanceWithInValidInput() {
		
		 String input1 = "3000 1901 SUNDAY";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);
		 
		 cntDowBegMon.processRequest(cntDowBegMon);
	}
	
	
	@Test
	public void testcountOfDaysMethodWithExpectedResult() {
		 assertEquals(171, cntDowBegMon.countOfDays(1901, 2000, "SUNDAY"));
	}
}
