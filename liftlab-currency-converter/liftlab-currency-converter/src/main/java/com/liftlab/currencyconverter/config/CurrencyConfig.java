package com.liftlab.currencyconverter.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/***
 * 
 * @author sahil
 *
 *	Configuration class to read currency wise decimal places given in properties file
 *	Note: prefix: currency has been added
 */
@Configuration
@ConfigurationProperties(prefix = "currency")
public class CurrencyConfig {
	
    private Map<String, Integer> decimalPlaces;

    public Map<String, Integer> getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Map<String, Integer> decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }
}
