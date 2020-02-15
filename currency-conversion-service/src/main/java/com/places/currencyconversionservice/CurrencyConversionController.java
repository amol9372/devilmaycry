package com.places.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
//		Map<String, String> uriVariablesMap = new HashMap<>();
//		uriVariablesMap.put("from", from);
//		uriVariablesMap.put("to", to);
//		
//		ResponseEntity<CurrencyConversionBean> responseEntity = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariablesMap);
		
		CurrencyConversionBean conversionBean = proxy.getExchangeValue(from, to);
		
		conversionBean.setCalculatedAmount(conversionBean.getConversionMultiple().multiply(quantity));
		
		return conversionBean;
	}
}
