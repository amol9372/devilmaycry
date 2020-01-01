package com.parking.GojekParkingLot.service;

import com.parking.GojekParkingLot.model.ParkingTicket;
import com.parking.GojekParkingLot.model.Slot;
import com.parking.GojekParkingLot.model.Vehicle;

public interface ParkingService {
     Slot getNearestEmptySlot();
     
     ParkingTicket getParkingTicket(Vehicle vehicle, Slot slot);
     
     void parkVehicle(Vehicle vehicle);
     
     void leaveParking(int slotNo);
}
