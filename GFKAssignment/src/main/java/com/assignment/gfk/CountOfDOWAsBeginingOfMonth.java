package com.assignment.gfk;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.assignment.gfk.constants.ErrorMessage;
import com.assignment.gfk.exceptions.ExceptionUtil;

/**
 * Count number of Sundays in a century that falls as beginning of month
 * 
 * @author Nava Krishna
 *
 */
public class CountOfDOWAsBeginingOfMonth {

	/**
	 * It initiates the execution of the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		CountOfDOWAsBeginingOfMonth cntOfMnthBegin = new CountOfDOWAsBeginingOfMonth();
		System.out.println("Response Status "+cntOfMnthBegin.processRequest(cntOfMnthBegin));
	}
	
	/**
	 * Read start and end numbers from CLI using scanner API. Returns
	 * {@code responseMsg} based on execution status.
	 * 
	 * 
	 * @param cntOfMnthBegin
	 * @return {@code responseMsg} based on execution status
	 * 
	 * 
	 * @throws ApplicationExcep'tion
	 *             if the input is invalid or internal server error.
	 */
	public String processRequest(CountOfDOWAsBeginingOfMonth cntOfMnthBegin) {
		
		String responseMsg="SUCCESS";
		

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter Begining year of century:");
			int startYear = scanner.nextInt();

			System.out.println("Enter end year of century:");
			int endYear = scanner.nextInt();
			

			System.out.println("Enter day to get Count, Eg: SUNDAY");
			String dayOfTheWeek = scanner.next();

			if (startYear > endYear)
				ExceptionUtil.raiseException(ErrorMessage.YEAR_VALIDATION_FAILURE_MESSAGE, endYear + "," + endYear,
						ErrorMessage.INVALID_RESOURCE_TYPE);

			System.out.println("Total count of " + dayOfTheWeek + " in a century is "
					+ cntOfMnthBegin.countOfDays(startYear, endYear, dayOfTheWeek));


		} catch (InputMismatchException ex) {
			responseMsg = "FAILURE";
			ExceptionUtil.raiseException(ErrorMessage.INVALID_INPUT, "", ErrorMessage.INVALID_INPUT_RESOURCE);
		} catch(Exception ex) {
			responseMsg = "FAILURE";
			ExceptionUtil.raiseException(ex.getMessage(), ErrorMessage.INTERNAL_SERVER_ERROR_MESSAGE,
					ErrorMessage.INVALID_SERVER_ERROR_RESOURCE_TYPE);
		}
		
		return responseMsg;
	}

	/**
	 * Returns {@code cntOfDays} within in a specified range of years. It starts
	 * with first day beginning year and advances to last day of the end year by
	 * adding every month which finally provides the beginning day of every month.
	 * 
	 * Below is the way which gives more insight.
	 * 
	
	 * 
	 * @param startYear
	 * @param endYear
	 * @param dayOfTheWeek
	 * @return {@code cntOfDays} within in a specified range of years
	 */
	public int countOfDays(int startYear, int endYear, String dayOfTheWeek) {

		int cntOfDays = 0;

		for (LocalDate date = LocalDate.now().withYear(startYear).with(firstDayOfYear()); date
				.isBefore(LocalDate.now().withYear(endYear).with(lastDayOfYear())); date = date.plusMonths(1)) {
			
			if (dayOfTheWeek.equalsIgnoreCase(date.getDayOfWeek().name()))
				cntOfDays++;
		}
		return cntOfDays;
	}

}
