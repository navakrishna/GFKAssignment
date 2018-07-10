package com.assignment.gfk;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.assignment.gfk.constants.ErrorMessage;
import com.assignment.gfk.exceptions.ExceptionUtil;

/**
 * A Tabulation(bottom up algorithm) based implementation. Array is the data
 * structure used for this approach. Result is finally stored in max index of array.
 * 
 * <p>This implementation provides O(n) space complexity and O(mn) time complexity
 * on {@code countCoins} operations because it mainly avoids calling duplicate work and recursion.<p>
 * 
 * @author Nava Krishna
 *
 */
public class ComputeWaysToCountCoins {
	
	/**
	 * It initiates the execution of the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ComputeWaysToCountCoins cmpWayForCoins = new ComputeWaysToCountCoins();
		System.out.println("Response Status "+cmpWayForCoins.processRequest(cmpWayForCoins));
	}

	/**
	 * Read start and end numbers from CLI using scanner API. Returns
	 * {@code responseMsg} based on execution status.
	 * 
	 * 
	 * @param cmpWayForCoins
	 * @return {@code responseMsg} based on execution status
	 * 
	 * 
	 * @throws ApplicationExcep'tion
	 *             if the input is invalid or internal server error.
	 */
	public String processRequest(ComputeWaysToCountCoins cmpWayForCoins) {
		
		String responseMsg="SUCCESS";
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter different denominations of euro:");

			Integer[] euros = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
					.toArray(Integer[]::new);

			System.out.println("Enter amount for possible combinations:");
			int amount = scanner.nextInt();

			System.out.println("Number of ways to count "+cmpWayForCoins.countCoins(euros, euros.length, amount));

		} catch (InputMismatchException ex) {
			responseMsg="FAILURE";
			ExceptionUtil.raiseException(ErrorMessage.INVALID_INPUT, "", ErrorMessage.INVALID_INPUT_RESOURCE);
		} catch(Exception ex) {
			responseMsg = "FAILURE";
			ExceptionUtil.raiseException(ex.getMessage(), ErrorMessage.INTERNAL_SERVER_ERROR_MESSAGE,
					ErrorMessage.INVALID_SERVER_ERROR_RESOURCE_TYPE);
		}
		
		return responseMsg;
	}
	
	
	/**
	 * Returns number of ways, the coins can arrange to get specified value.
	 * 
	 * @param euros
	 * @param count
	 * @param amount
	 * 
	 */
	public long countCoins(Integer[] euros, int count, int amount) {

		long[] table = new long[amount + 1];
		table[0] = 1;

		IntStream.range(0, count).forEach(coinIndex -> IntStream.rangeClosed(euros[coinIndex], amount)
				.forEach(valueAtCoinIndex -> table[valueAtCoinIndex] += table[valueAtCoinIndex - euros[coinIndex]]));

		return table[amount];
	}
}
