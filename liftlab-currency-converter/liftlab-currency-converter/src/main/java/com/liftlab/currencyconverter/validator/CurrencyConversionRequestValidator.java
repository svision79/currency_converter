package com.liftlab.currencyconverter.validator;

import com.liftlab.currencyconverter.exceptions.ValidationException;
import com.liftlab.currencyconverter.request.CurrencyConversionRequest;

/**
 * 
 * @author sahil
 * 
 * Error message codes hard coded in validation exception objects, can be part of error codes config based on requirement
 *
 */

public class CurrencyConversionRequestValidator {
	
	public static void validateCurrencyConversionRequest(CurrencyConversionRequest request) {
        if (request == null) {
            throw new ValidationException("LL-001", "Currency conversion request cannot be null.");
        }

        if (request.getSourceCurrency() == null || request.getTargetCurrency() == null) {
            throw new ValidationException("LL-002", "Source and target currencies must be specified.");
        }

        if (request.getSourceAmount() <= 0) {
            throw new ValidationException("LL-003", "Source amount must be greater than 0.");
        }

    }

}
