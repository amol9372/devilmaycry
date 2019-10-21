package com.places.geocode.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry {
	private Location location;

	@JsonProperty("loation_type")
	private String locationType;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Geometry [location=");
		builder.append(location);
		builder.append(", locationType=");
		builder.append(locationType);
		builder.append("]");
		return builder.toString();
	}

}
