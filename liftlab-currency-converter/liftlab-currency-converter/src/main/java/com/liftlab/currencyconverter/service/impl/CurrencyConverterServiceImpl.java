package com.liftlab.currencyconverter.service.impl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liftlab.currencyconverter.exceptions.CurrencyConversionException;
import com.liftlab.currencyconverter.exceptions.ValidationException;
import com.liftlab.currencyconverter.request.CurrencyConversionRequest;
import com.liftlab.currencyconverter.response.CurrencyConversionResponse;
import com.liftlab.currencyconverter.service.CurrencyConverterService;
import com.liftlab.currencyconverter.service.CurrencyDecimalPlacesService;
import com.liftlab.currencyconverter.service.CurrencyExchangeRateService;
import com.liftlab.currencyconverter.util.CurrencyUtil;
import com.liftlab.currencyconverter.validator.CurrencyConversionRequestValidator;

/**
 * 
 * @author sahil
 * Implementation of CurrencyConverterService
 *
 */
@Service
public class CurrencyConverterServiceImpl implements CurrencyConverterService {
	
	private static final Logger logger = LoggerFactory.getLogger(CurrencyConverterServiceImpl.class);
	
	@Autowired
	CurrencyExchangeRateService exchangeRateService;
	@Autowired
	CurrencyDecimalPlacesService decimalPlacesStrategy;
	

	
	@Override
	public CurrencyConversionResponse convertCurrency(CurrencyConversionRequest request) throws CurrencyConversionException, ValidationException {
 
		logger.info("Converting currency: {} to {} amount: {}", request.getSourceCurrency(), request.getTargetCurrency(), request.getSourceAmount());

		try {
			//validating request
			CurrencyConversionRequestValidator.validateCurrencyConversionRequest(request);
	
			double exchangeRate = exchangeRateService.getExchangeRate(request.getSourceCurrency(), request.getTargetCurrency());
			
			if (exchangeRate <= 0) {
				throw new CurrencyConversionException("LL-004", "Invalid or negative exchange rate.");
			}
			
			double targetAmount = request.getSourceAmount() * exchangeRate;
	
			// Format targetAmount based on currency decimal places
			int decimalPlaces = decimalPlacesStrategy.getDecimalPlaces(request.getTargetCurrency());
			
			String formattedTargetAmount = CurrencyUtil.formatCurrency(targetAmount, decimalPlaces);
			
			logger.info("Conversion successful. Result: {}", formattedTargetAmount);
	
			return new CurrencyConversionResponse(request.getTargetCurrency(), formattedTargetAmount);
		}catch(ValidationException | CurrencyConversionException e) {
			logger.error("Error in converting currency {}",e);
			throw e;
		}
	}

}

