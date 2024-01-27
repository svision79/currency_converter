package com.liftlab.currencyconverter.response;

import java.util.Map;

/***
 * 
 * @author sahil
 * 
 * Response DTO base on sample response from following api:
 * 
 * 
 */

public class ExchangeDataResponse {
	
	private String date;
    private Map<String, Double> rates;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Map<String, Double> getRates() {
		return rates;
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
    
    

}
