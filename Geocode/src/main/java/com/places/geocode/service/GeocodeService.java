package com.places.geocode.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.places.Utility.Enums.Status;
import com.places.geocode.model.GeocodeAddressResponse;
import com.places.geocode.model.PlaceModel;
import com.places.geocode.service.impl.GeocodeServiceImpl;

@Service
public class GeocodeService {
   
	@Autowired
	private GeocodeServiceImpl geocodeServiceImpl;
	
	public GeocodeAddressResponse getLatLongFromAddress(String address) throws RestClientException, UnsupportedEncodingException {
		return geocodeServiceImpl.getLatLong(address);
	}
	
	public List<PlaceModel> getCityList() {
		return geocodeServiceImpl.getPlaceList();
	}
	
	
	
}
