package com.places.geocode.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.places.Utility.Exceptions.PlaceNotFoundException;
import com.places.geocode.dao.GeocodePlaceRepository;
import com.places.geocode.model.GeocodeAddressResponse;
import com.places.geocode.model.PlaceModel;
import com.places.geocode.service.impl.GeocodeServiceImpl;

@Service
public class GeocodeService {
   
	@Autowired
	private GeocodeServiceImpl geocodeServiceImpl;
	
	@Autowired
	private GeocodePlaceRepository geocodePlaceRepository;
	
	public GeocodeAddressResponse getLatLongFromAddress(String address) throws RestClientException, UnsupportedEncodingException {
		return geocodeServiceImpl.getLatLong(address);
	}
	
	public List<PlaceModel> getCityList() {
		return geocodeServiceImpl.getPlaceList();
	}
	
	public PlaceModel getPlace(int id) throws PlaceNotFoundException {
		Optional<PlaceModel> placeModelOptional = geocodePlaceRepository.findById(id);
		if(!placeModelOptional.isPresent()) {
			throw new PlaceNotFoundException("Place Not found");
		}
		
		return placeModelOptional.get();
	}
	
}
