package com.parking.GojekParkingLot.main;

import com.parking.GojekParkingLot.model.Vehicle;
import com.parking.GojekParkingLot.service.ParkingService;
import com.parking.GojekParkingLot.service.ParkingServiceImpl;
import com.parking.GojekParkingLot.utils.ParkingUtils;

public class Parking {

	private static ParkingService parkingService = ParkingServiceImpl.getParkingInsImpl();
	private static ParkingUtils parkingUtils = ParkingUtils.getUtilsInstance();
	
	public static void main(String[] args) {
		parkingUtils.initializeParking(5);
		Vehicle v1 = new Vehicle("PB08 BW 0972", "Black");
		Vehicle v2 = new Vehicle("HR26 CQ 9056", "Blue");
		Vehicle v3 = new Vehicle("TN34 AB 0997", "Red");
		parkingService.parkVehicle(v1);
		parkingService.parkVehicle(v2);
		parkingService.parkVehicle(v3);
		parkingService.leaveParking(2);
		Vehicle v4 = new Vehicle("GA21 XN 8760", "Green");
		parkingService.parkVehicle(v4);
		parkingService.parkVehicle(v3);
		 
	}
	
}