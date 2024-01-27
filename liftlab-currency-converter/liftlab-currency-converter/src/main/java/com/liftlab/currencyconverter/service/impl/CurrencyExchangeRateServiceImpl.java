package com.liftlab.currencyconverter.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.liftlab.currencyconverter.constant.Currency;
import com.liftlab.currencyconverter.exceptions.CurrencyConversionException;
import com.liftlab.currencyconverter.exceptions.ValidationException;
import com.liftlab.currencyconverter.response.ExchangeDataResponse;
import com.liftlab.currencyconverter.service.CurrencyExchangeRateService;
import com.liftlab.currencyconverter.validator.ExchangeApiRequestValidator;

/**
 * 
 * @author sahil
 * CurrencyExchangeRateService Implementation
 *
 */
@Service
public class CurrencyExchangeRateServiceImpl implements CurrencyExchangeRateService {
	
	private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeRateServiceImpl.class);
	
    @Value("${exchange.rate.api.url}")
    private String exchangeRateApiUrl;

	@Override
	public double getExchangeRate(String sourceCurrency, String targetCurrency) throws CurrencyConversionException, ValidationException {
		
		ExchangeApiRequestValidator.validateCurrencies(sourceCurrency, targetCurrency);
		
		String apiUrl = String.format("%s/%s", exchangeRateApiUrl, sourceCurrency.toUpperCase());

        try {
        	RestTemplate restTemplate = new RestTemplate();
            ExchangeDataResponse response = restTemplate.getForObject(apiUrl, ExchangeDataResponse.class);
            
            if (response != null && response.getRates() != null) {
                Double rate = response.getRates().get(targetCurrency.toUpperCase());
                if (rate != null) {
                    return rate;
                } else {
                    throw new CurrencyConversionException("LL-006", "Invalid or missing rate for the target currency");
                }
            } else {
                throw new CurrencyConversionException("LL-007", "Invalid response from the exchange rate API");
            }
        } catch (RestClientException e) {
        	logger.error("Error in exchange rate api {}",e);
            throw new CurrencyConversionException("LL-008", "Error while fetching exchange rate from the API");
        }
		
	}


}
