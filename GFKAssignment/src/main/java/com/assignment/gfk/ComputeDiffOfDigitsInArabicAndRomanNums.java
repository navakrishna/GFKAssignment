package com.assignment.gfk;

import java.util.Collections;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.assignment.gfk.constants.ErrorMessage;
import com.assignment.gfk.exceptions.ApplicationException;
import com.assignment.gfk.exceptions.ExceptionUtil;

/**
 * Compute characters saved in Arabic representation as compared to it's minimal
 * Roman representation. Algorithm is executed in the range of 1 to n Arabic
 * numbers.
 * 
 *  
 * 
 * @author Nava Krishna
 * @see TreeMap
 * @see NavigableMap
 * @see IntStream
 * 
 *
 */

public class ComputeDiffOfDigitsInArabicAndRomanNums {

	/**
	 * NavigableMap maintains relation between Arabic numbers and minimal
	 * representation of Roman numbers. It is used because it floor's the value
	 * based on nearest key approach which reduces loop in identifying
	 * respective Roman representation.
	 *
	 */
	public static NavigableMap<Integer, String> conv = new TreeMap<Integer, String>();

	static {
		conv.put(1000, "M");
		conv.put(900, "CM");
		conv.put(500, "D");
		conv.put(400, "CD");
		conv.put(100, "C");
		conv.put(90, "XC");
		conv.put(50, "L");
		conv.put(40, "XL");
		conv.put(10, "X");
		conv.put(9, "IX");
		conv.put(5, "V");
		conv.put(4, "IV");
		conv.put(1, "I");
	}

	/**
	 * It initiates the execution of the program.
	 * @param args
	 */
	public static void main(String[] args) {
		ComputeDiffOfDigitsInArabicAndRomanNums cmpDiff = new ComputeDiffOfDigitsInArabicAndRomanNums();
		System.out.println("Response Status "+cmpDiff.processRequest(cmpDiff));
	}
	
	/**
	 * Read start and end numbers from CLI using scanner API. Returns
	 * {@code responseMsg} based on execution status.
	 * 
	 * @param cmpDiff
	 * @return {@code responseMsg} based on execution status
	 * 
	 * @throws ApplicationException
	 *             if the input is invalid or internal server error.
	 */
	public String processRequest(ComputeDiffOfDigitsInArabicAndRomanNums cmpDiff) {
		
		String responseMsg= "SUCCESS";
		
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Welcome to compute difference of Arabic and Roman characters use case.");

			System.out.println("Enter starting number:");
			int startNum = scanner.nextInt();

			System.out.println("Enter end number");
			int endNum = scanner.nextInt();

			
			if (startNum > endNum)
				ExceptionUtil.raiseException(ErrorMessage.NUMBER_VALIDATION_FAILURE_MESSAGE, startNum + "," + endNum,
						ErrorMessage.INVALID_RESOURCE_TYPE);


			System.out.println("Number of characters saved with arabic representation vs roman representation "
					+ cmpDiff.computeDiffOfCharacters(startNum, endNum));


		} catch (NoSuchElementException ex) {
			responseMsg = "FAILURE";
			ExceptionUtil.raiseException(ErrorMessage.INVALID_INPUT, "", ErrorMessage.INVALID_INPUT_RESOURCE);
		} catch (Exception ex) {
			responseMsg = "FAILURE";
			ExceptionUtil.raiseException(ex.getMessage(), ErrorMessage.INTERNAL_SERVER_ERROR_MESSAGE,
					ErrorMessage.INVALID_SERVER_ERROR_RESOURCE_TYPE);
		}
		
		return responseMsg;
	}

	/**
	 * Returns difference between Roman number digit and Arabic digit count. More
	 * formally, iterate in the closed range of input values and floor the Roman
	 * representation from navigable map based on input. Populate {@link TreeMap}
	 * with key as Roman number and value as length of Roman number. Finally, reduce
	 * the sum of numeric digit count.
	 * 
	 * 
	 * @param startNum
	 * @param endNum
	 * 
	 * @throws ApplicationException
	 *             If input startNumber is less than end Number
	 * 
	 */
	public int computeDiffOfCharacters(int startNum, int endNum) {


		NavigableSet<Integer> set = (NavigableSet<Integer>) conv.keySet();

		TreeMap<String, Integer> romanMap = new TreeMap<>(
				Comparator.comparing(String::length).thenComparing(Function.identity()));

		int arabicNumCnt = IntStream.rangeClosed(startNum, endNum).map(value -> {
			String romanNum = "";
			int sum = String.valueOf(value).length();

			while (value > 0) {
				romanNum = romanNum + conv.get(set.floor(value));
				value = value - set.floor(value);
			}
			romanMap.put(romanNum, romanNum.length());
			return sum;
		}).reduce((sum, n) -> sum + n).getAsInt();

		return diffOfCharacters(romanMap, arabicNumCnt);

	}

	/**
	 * Returns difference between Roman and Arabic digit count.
	 * 
	 * @param romanMap
	 * @param arabicNumCnt
	 * @return 
	 */
	private int diffOfCharacters(TreeMap<String, Integer> romanMap, int arabicNumCnt) {
		
		int romanValues = 0;
		for(Integer value : romanMap.values().stream().distinct().collect(Collectors.toList())) {
			romanValues += value*Collections.frequency(romanMap.values(), value);
		}
		
		return romanValues-arabicNumCnt;
	}
}


