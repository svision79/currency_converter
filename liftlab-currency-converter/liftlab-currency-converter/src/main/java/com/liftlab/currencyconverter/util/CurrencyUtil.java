package com.liftlab.currencyconverter.util;

import java.text.DecimalFormat;

import static com.liftlab.currencyconverter.constant.Constants.*;

/**
 * 
 * @author sahil
 * 
 * Common utility class for currency conversion
 *
 */
public class CurrencyUtil {
	
	//method to format currency
	public static String formatCurrency(double amount, int decimalPlaces) {
		
		String pattern = CURRENCY_PATTERN;
	    
	    if (decimalPlaces > 0) {
	        pattern += DOT + ZERO.repeat(decimalPlaces);
	    }

	    DecimalFormat decimalFormat = new DecimalFormat(pattern);
	    return decimalFormat.format(amount);
	    
	}

}
