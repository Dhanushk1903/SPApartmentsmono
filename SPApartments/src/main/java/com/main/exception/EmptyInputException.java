package com.main.exception;

public class EmptyInputException extends  Exception {
 
	
	
	public EmptyInputException() {
		 
	}
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EmptyInputException(String errorMessage, String errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	
	

}
