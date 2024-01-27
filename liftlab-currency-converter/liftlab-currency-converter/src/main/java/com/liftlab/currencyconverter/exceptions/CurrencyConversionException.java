package com.liftlab.currencyconverter.exceptions;

/**
 * 
 * @author sahil
 * 
 * Custom Exception class
 *
 */
public class CurrencyConversionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private final String messageCode;

	public CurrencyConversionException(String messageCode, String message) {
    	super(message);
        this.messageCode = messageCode;
    }
    
    public String getMessageCode() {
    	return messageCode;
    }

}
