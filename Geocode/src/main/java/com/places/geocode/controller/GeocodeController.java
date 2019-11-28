package com.places.geocode.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.places.Utility.Exceptions.PlaceNotFoundException;
import com.places.geocode.model.GeocodeAddressResponse;
import com.places.geocode.model.PlaceModel;
import com.places.geocode.service.GeocodeService;

@RestController
@RequestMapping("/geocode")
public class GeocodeController {
   
	@Autowired
	private GeocodeService geocodeService;
	
	@GetMapping("/getLatLong")
	public GeocodeAddressResponse getLatlongFromAddress(@RequestParam("address") String address) throws RestClientException, UnsupportedEncodingException {
		return geocodeService.getLatLongFromAddress(address);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getCityList")
	public List<PlaceModel> getCityList() {
		return geocodeService.getCityList();
	}
	
	@GetMapping("/getPlaceById")
	public PlaceModel getPlaceById(@RequestParam("id") int id) throws PlaceNotFoundException {
		return geocodeService.getPlace(id);
	}
	
}
