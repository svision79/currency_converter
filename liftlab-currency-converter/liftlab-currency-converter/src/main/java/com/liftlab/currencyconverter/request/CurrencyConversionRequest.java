package com.liftlab.currencyconverter.request;

//DTO for handling conversion requests
public class CurrencyConversionRequest {
	 
	private String sourceCurrency;
	private String targetCurrency;
	private double sourceAmount;
	
	
	public String getSourceCurrency() {
		return sourceCurrency;
	}
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	
	public double getSourceAmount() {
		return sourceAmount;
	}
	public void setSourceAmount(double sourceAmount) {
		this.sourceAmount = sourceAmount;
	}
	
	
	 
	 

}
