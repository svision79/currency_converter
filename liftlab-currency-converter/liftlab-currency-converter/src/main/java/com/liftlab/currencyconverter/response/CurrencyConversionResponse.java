package com.liftlab.currencyconverter.response;


/***
 * 
 * @author sahil
 * DTO for handling conversion responses
 * Note: targetAmount set as String to handle formatting
 */
public class CurrencyConversionResponse {
	
	private String targetCurrency;
	private String targetAmount;
	
	private String error;
	
	public CurrencyConversionResponse(String targetCurrency, String targetAmount) {
		super();
		this.targetCurrency = targetCurrency;
		this.targetAmount = targetAmount;
	}
	
	public CurrencyConversionResponse() {
		
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public String getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	

}
