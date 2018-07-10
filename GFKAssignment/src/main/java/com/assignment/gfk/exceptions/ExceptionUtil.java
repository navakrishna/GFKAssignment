package com.assignment.gfk.exceptions;

/**
 * 
 * It helps in raising exception.
 * 
 * @author Nava Krishna
 *
 */
public class ExceptionUtil {

	/**
	 * Raise an Application exception with proper error message, resource id and type.
	 * 
	 * @param message
	 * @param resourceId
	 * @param resourceType
	 */
	public static void raiseException(String message, String resourceId, String resourceType) {
		throw new ApplicationException(message, resourceId, resourceType);
	}
}
