package com.liftlab.currencyconverter.service;

import org.springframework.stereotype.Service;

import com.liftlab.currencyconverter.constant.Currency;
import com.liftlab.currencyconverter.exceptions.CurrencyConversionException;

@Service
public interface CurrencyExchangeRateService {
	double getExchangeRate(String sourceCurrency, String targetCurrency) throws CurrencyConversionException;
}
