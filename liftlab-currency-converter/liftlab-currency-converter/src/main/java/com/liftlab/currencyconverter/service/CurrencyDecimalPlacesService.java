package com.liftlab.currencyconverter.service;

import org.springframework.stereotype.Service;

import com.liftlab.currencyconverter.constant.Currency;

@Service
public interface CurrencyDecimalPlacesService {
	int getDecimalPlaces(String currency);
}