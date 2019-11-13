package com.places.geocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.places.geocode.model.PlaceModel;

public interface GeocodePlaceRepository extends JpaRepository<PlaceModel, Integer> {

}
