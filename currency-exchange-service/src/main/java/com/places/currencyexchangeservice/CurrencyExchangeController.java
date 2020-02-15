package com.places.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
    private ExchangeRepository exchnageRepository;
	
	@GetMapping("/currency-exchnage/from/{from}/to/{to}")
	public ExchangeValue exchangeValue(@PathVariable String from, @PathVariable String to) {

		ExchangeValue exchangeValue = exchnageRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;
	}
}