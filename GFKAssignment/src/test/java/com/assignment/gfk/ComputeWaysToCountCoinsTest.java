package com.assignment.gfk;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.assignment.gfk.exceptions.ApplicationException;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class ComputeWaysToCountCoinsTest {

	private ComputeWaysToCountCoins cmpWayForCoins = new ComputeWaysToCountCoins();
	
	@Rule
    public TestRule benchmarkRun = new BenchmarkRule();
	
	@BenchmarkOptions(callgc = false, benchmarkRounds = 2, warmupRounds = 1)
	@Test
	public void testProcessRequestPeformanceWithValidInputs() {
		 String input1 = "200 100 50 20 10 5 2 1\n1525";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);
		 
		 assertEquals("SUCCESS", cmpWayForCoins.processRequest(cmpWayForCoins));
	}

	@BenchmarkOptions(callgc = false, benchmarkRounds = 2, warmupRounds = 1)
	@Test
	public void testProcessRequestPeformanceValidInputsAndWideSpaces() {
		 String input1 = "200	 100	 50 	20 	10	 5	 2	 1\n1525";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);
		 
		 assertEquals("SUCCESS", cmpWayForCoins.processRequest(cmpWayForCoins));
	}
	
	@BenchmarkOptions(callgc = false, benchmarkRounds = 1, warmupRounds = 0)
	@Test(expected=ApplicationException.class)
	public void testProcessRequestPeformanceInvalidInputs() {
		 String input1 = "200 100 50 ABC 10 5 2 1\n1525";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);
		 
		 assertEquals("FAILURE", cmpWayForCoins.processRequest(cmpWayForCoins));
	}
	
	@BenchmarkOptions(callgc = false, benchmarkRounds = 1, warmupRounds = 0)
	@Test(expected=ApplicationException.class)
	public void testProcessRequestPeformanceInvalidInputAsSecondParam() {
		 String input1 = "200 100 50 ABC 10 5 2 1\nABC";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);
		 
		 assertEquals("FAILURE", cmpWayForCoins.processRequest(cmpWayForCoins));
	}
	
	@BenchmarkOptions(callgc = false, benchmarkRounds = 2, warmupRounds = 0)
	@Test
	public void testProcessRequestPeformanceWithWideRangeOfValidInputs() {
		 String input1 = "1000 500 200 100 50 20 10 5 2 1\n1525";
		 InputStream in = new ByteArrayInputStream(input1.getBytes());
		 System.setIn(in);
		 
		 assertEquals("SUCCESS", cmpWayForCoins.processRequest(cmpWayForCoins));
	}
}
