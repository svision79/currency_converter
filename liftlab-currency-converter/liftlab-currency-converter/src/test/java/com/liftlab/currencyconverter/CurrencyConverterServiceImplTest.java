package com.liftlab.currencyconverter;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.liftlab.currencyconverter.constant.Currency;
import com.liftlab.currencyconverter.exceptions.CurrencyConversionException;
import com.liftlab.currencyconverter.exceptions.ValidationException;
import com.liftlab.currencyconverter.request.CurrencyConversionRequest;
import com.liftlab.currencyconverter.response.CurrencyConversionResponse;
import com.liftlab.currencyconverter.service.CurrencyDecimalPlacesService;
import com.liftlab.currencyconverter.service.CurrencyExchangeRateService;
import com.liftlab.currencyconverter.service.impl.CurrencyConverterServiceImpl;
import com.liftlab.currencyconverter.service.impl.CurrencyDecimalPlacesServiceImpl;
import com.liftlab.currencyconverter.service.impl.CurrencyExchangeRateServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CurrencyConversionApplication.class)
@RunWith(SpringRunner.class)
@TestComponent
class CurrencyConverterServiceImplTest {
	
	@InjectMocks
	CurrencyConverterServiceImpl converterService;
	
	@Mock
    CurrencyExchangeRateServiceImpl exchangeRateService; // Mock the implementation class
	
	@Mock
	CurrencyDecimalPlacesServiceImpl decimalPlacesStrategy;

//    @Before
//    public void setup() throws ValidationException, CurrencyConversionException {
//    	
//        Mockito.when(exchangeRateService.getExchangeRate(Mockito.anyString(), Mockito.anyString()))
//               .thenReturn(0.012); // Replace this with the expected exchange rate
//    }
//	
    @Test
    void convertCurrencyValidRequestSuccessResponse() throws CurrencyConversionException {
    	
//    	ReflectionTestUtils.setField(exchangeRateService,"exchangeRateApiUrl","https://api.exchangerate-api.com/v4/latest", String.class); 
    	Mockito.when(exchangeRateService.getExchangeRate(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(0.012);
    	
    	Mockito.when(decimalPlacesStrategy.getDecimalPlaces(Mockito.anyString()))
        .thenReturn(2);
    	
        CurrencyConversionRequest request = new CurrencyConversionRequest();
        request.setSourceCurrency(Currency.INR.name());
        request.setTargetCurrency(Currency.USD.name());
        request.setSourceAmount(100.0);

        CurrencyConversionResponse response = converterService.convertCurrency(request);

        assertNotNull(response);
        assertEquals(Currency.USD.name(), response.getTargetCurrency());
        assertNotNull(response.getTargetAmount());
        assertEquals("1.20", response.getTargetAmount());
    }

    @Test
    void convertCurrencyInvaidRequest() {

        CurrencyConversionRequest request = new CurrencyConversionRequest(); // Invalid request

        assertThrows(ValidationException.class, () -> converterService.convertCurrency(request));
    }

}
