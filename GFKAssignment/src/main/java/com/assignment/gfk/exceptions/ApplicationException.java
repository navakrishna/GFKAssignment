package com.assignment.gfk.exceptions;

/**
 * 
 * 
 * Custom exception extended from RunTime exceptions.
 * It is used across multiple places to notify users with
 * correct and valid error messages.
 * 
 * @author Nava Krishna
 *
 */
public class ApplicationException extends RuntimeException {
	
	private static final long serialVersionUID = 8932790932039467079L;
	private String resourceType;
	private String resourceId;

	public ApplicationException(String message, String resourceId, String resourceType) {
		super(message);
		this.resourceId = resourceId;
		this.resourceType = resourceType;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
}
