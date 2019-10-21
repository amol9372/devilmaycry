package com.places.geocode.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
	@JsonProperty("formatted_address")
	private String formattedAddress;

	private Geometry geometry;
	@JsonProperty("place_id")
	private String placeId;

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Results [formattedAddress=");
		builder.append(formattedAddress);
		builder.append(", geometry=");
		builder.append(geometry);
		builder.append(", placeId=");
		builder.append(placeId);
		builder.append("]");
		return builder.toString();
	}

}
