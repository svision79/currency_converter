package com.liftlab.currencyconverter.validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.liftlab.currencyconverter.constant.Currency;
import com.liftlab.currencyconverter.exceptions.ValidationException;

/**
 * 
 * @author sahil
 * Validator class to validate whether currency is allowed or not
 *
 */
public class ExchangeApiRequestValidator {
	
	public static void validateCurrencies(String sourceCurrency, String targetCurrency) {
		List<String> enumNames = Stream.of(Currency.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        if (!enumNames.contains(sourceCurrency) || !enumNames.contains(targetCurrency)) {
            throw new ValidationException("LL-005","Invalid source or target currency");
        }
    }

}
