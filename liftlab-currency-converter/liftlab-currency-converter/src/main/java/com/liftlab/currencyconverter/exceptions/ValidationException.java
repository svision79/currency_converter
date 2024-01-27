package com.liftlab.currencyconverter.exceptions;

/**
 * 
 * @author sahil
 * Custom exception class to handle validation errors
 *
 */
public class ValidationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String messageCode;

	public ValidationException(String messageCode, String message) {
    	super(message);
        this.messageCode = messageCode;
    }
    
    public String getMessageCode() {
    	return messageCode;
    }
}
