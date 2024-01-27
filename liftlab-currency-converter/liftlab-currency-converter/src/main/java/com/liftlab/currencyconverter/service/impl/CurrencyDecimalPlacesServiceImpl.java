package com.liftlab.currencyconverter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liftlab.currencyconverter.config.CurrencyConfig;
import com.liftlab.currencyconverter.constant.Currency;
import com.liftlab.currencyconverter.service.CurrencyDecimalPlacesService;


/**
 * @author sahil
 * CurrencyDecimalPlacesService Implementation
 */
@Service
public class CurrencyDecimalPlacesServiceImpl implements CurrencyDecimalPlacesService{
	
	@Autowired
	private CurrencyConfig currencyConfig;

	/**
	 * Takes currency as inpit and returns desired decimal places based on configuration
	 */
	@Override
	public int getDecimalPlaces(String currency) {
		return currencyConfig.getDecimalPlaces().getOrDefault(currency, 2);
	}

}
