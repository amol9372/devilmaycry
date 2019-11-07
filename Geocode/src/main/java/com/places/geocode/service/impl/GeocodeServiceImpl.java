package com.places.geocode.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.places.Utility.Enums.Status;
import com.places.geocode.model.PlaceModel;
import com.places.geocode.model.GeocodeAddressResponse;

@Service
public class GeocodeServiceImpl {
   
	@Autowired
	private Environment env;
	
	public GeocodeAddressResponse getLatLong(String address) throws RestClientException, UnsupportedEncodingException {
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
	
	public List<PlaceModel> getPlaceList() {
		CsvToBean<PlaceModel> csv = new CsvToBean();

		String csvFilename = "C:\\Users\\amols\\Downloads\\world-cities\\world-cities.csv";
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(csvFilename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Set column mapping strategy
		List<PlaceModel> placeList = csv.parse(setColumMapping(), csvReader);

		for (Object object : placeList) {
			PlaceModel placeModel = (PlaceModel) object;
		}
		
		return placeList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static ColumnPositionMappingStrategy setColumMapping() {
		ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
		strategy.setType(PlaceModel.class);
		String[] columns = new String[] { "city", "country", "province" };
		strategy.setColumnMapping(columns);
		return strategy;
	}
	
}
