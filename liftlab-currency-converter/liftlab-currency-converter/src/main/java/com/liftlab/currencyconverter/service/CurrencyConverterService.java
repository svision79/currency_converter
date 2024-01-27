package com.liftlab.currencyconverter.service;

import org.springframework.stereotype.Service;

import com.liftlab.currencyconverter.exceptions.CurrencyConversionException;
import com.liftlab.currencyconverter.request.CurrencyConversionRequest;
import com.liftlab.currencyconverter.response.CurrencyConversionResponse;

@Service
public interface CurrencyConverterService {
	CurrencyConversionResponse convertCurrency(CurrencyConversionRequest request) throws CurrencyConversionException;
}
