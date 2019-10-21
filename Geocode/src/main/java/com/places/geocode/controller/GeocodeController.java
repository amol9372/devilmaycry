package com.places.geocode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.places.geocode.model.GeocodeAddressResponse;

@RestController
@RequestMapping("/geocode")
public class GeocodeController {
   
	@GetMapping("/getLatLong")
	public GeocodeAddressResponse getLatlongFromAddress(@RequestParam("address") String address) {
		return null;
	}
	
}
