package com.liftlab.currencyconverter;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.liftlab.currencyconverter.constant.Currency;
import com.liftlab.currencyconverter.exceptions.CurrencyConversionException;
import com.liftlab.currencyconverter.response.ExchangeDataResponse;
import com.liftlab.currencyconverter.service.impl.CurrencyExchangeRateServiceImpl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CurrencyConversionApplication.class)
@RunWith(SpringRunner.class)
@TestComponent
class CurrencyExchangeRateServiceImplTest {
	
	@InjectMocks
	CurrencyExchangeRateServiceImpl exchangeRateService;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
	    return new PropertySourcesPlaceholderConfigurer();
	}

    @Test
    void getExchangeRateValidCurrencySuccessTest() throws CurrencyConversionException {

    	RestTemplate restTemplateMock = mock(RestTemplate.class);
    	ReflectionTestUtils.setField(exchangeRateService,"exchangeRateApiUrl","https://api.exchangerate-api.com/v4/latest", String.class); 
        when(restTemplateMock.getForObject(anyString(), eq(ExchangeDataResponse.class)))
                .thenReturn(new ExchangeDataResponse());


        String sourceCurrency = Currency.INR.name();
        String targetCurrency = Currency.USD.name();

        double exchangeRate = exchangeRateService.getExchangeRate(sourceCurrency, targetCurrency);

        assertEquals(0.012, exchangeRate);//change as per current rate
    }

}
