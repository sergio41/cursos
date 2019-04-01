package com.cursos.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private Environment environment;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(1L, from, to, new BigDecimal(65), quantity, quantity, 0);
		currencyConversionBean.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return currencyConversionBean;
	}
	
}