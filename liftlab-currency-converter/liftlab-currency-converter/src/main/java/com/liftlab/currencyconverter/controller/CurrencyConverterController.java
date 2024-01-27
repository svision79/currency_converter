package com.liftlab.currencyconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liftlab.currencyconverter.exceptions.CurrencyConversionException;
import com.liftlab.currencyconverter.exceptions.ValidationException;
import com.liftlab.currencyconverter.request.CurrencyConversionRequest;
import com.liftlab.currencyconverter.response.CurrencyConversionResponse;
import com.liftlab.currencyconverter.service.CurrencyConverterService;

/***
 * 
 * @author sahil
 * Controller to define api end points
 * Note : CrossOrigin has been added to handle localhost calls from browser
 *
 */
@RestController
@RequestMapping("/api/v1/currency/")
@CrossOrigin("*")
public class CurrencyConverterController {
	
	@Autowired
    private CurrencyConverterService converterService;


    @PostMapping("/convert")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(@RequestBody CurrencyConversionRequest request) {
    	CurrencyConversionResponse response = new CurrencyConversionResponse();
    	try {
            response = converterService.convertCurrency(request);
            return ResponseEntity.ok(response);
        } catch (ValidationException | CurrencyConversionException e) {
        	response.setError(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (Exception e) {
        	response.setError("Internal server error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
