package com.places.limitsservice.controller.copy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.places.limitsservice.model.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {

	
	@GetMapping("/limits")
	public LimitsConfiguration getLimitsConfiguration() {
		return new LimitsConfiguration(1000, 1);
	}
}
