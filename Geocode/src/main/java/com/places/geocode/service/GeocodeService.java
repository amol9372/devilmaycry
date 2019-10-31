package com.places.geocode.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.places.geocode.model.GeocodeAddressResponse;

import com.places.Utility.Enums.*;

@Service
public class GeocodeService {
   
	@Autowired
	private Environment env;
	
	public GeocodeAddressResponse getLatLongFromAddress(String address) throws RestClientException, UnsupportedEncodingException {
		return getLatLong(address);
	}
	
	private GeocodeAddressResponse getLatLong(String address) throws RestClientException, UnsupportedEncodingException {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = env.getProperty("geocode.address.url");
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fooResourceUrl)   // Used to add Query parameters
		        .queryParam("address", address)
		        .queryParam("key", env.getProperty("google.api.key"));
		
		
		GeocodeAddressResponse geocodeAddressResponse = restTemplate.getForObject(URLDecoder.decode(builder.toUriString(), "UTF-8"), GeocodeAddressResponse.class);
		
		// TODO if status is OK, (a) check list is empty or not
		// TODO if status is NOT OK, return the response
		
		if(Status.OK.toString().equals(geocodeAddressResponse.getStatus())) {
			
		}
		
		return geocodeAddressResponse;
	}
	
	
}
