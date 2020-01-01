package com.parking.GojekParkingLot.service;

import java.util.Arrays;
import java.util.Optional;

import com.parking.GojekParkingLot.model.ParkingTicket;
import com.parking.GojekParkingLot.model.Slot;
import com.parking.GojekParkingLot.model.Vehicle;
import com.parking.GojekParkingLot.utils.ParkingUtils;

public class ParkingServiceImpl implements ParkingService {

	private static ParkingServiceImpl parkingServiceImpl;
	private ParkingUtils parkingUtils = ParkingUtils.getUtilsInstance();
	
	public static ParkingServiceImpl getParkingInsImpl() {
		synchronized (ParkingServiceImpl.class) {
			if (parkingServiceImpl == null) {
				return new ParkingServiceImpl();
			}
		}
		return parkingServiceImpl;
	}
	
	@Override
	public Slot getNearestEmptySlot() {
		Optional<Slot> emptySlot = Arrays.stream(parkingUtils.getSlots()).filter(slot -> slot.isEmpty()).findFirst();	
		if(emptySlot.isPresent()) {
			return emptySlot.get();
		}
		return null;
	}

	@Override
	public ParkingTicket getParkingTicket(Vehicle vehicle, Slot slot) {
		ParkingTicket parkingTicket = new ParkingTicket();
		parkingTicket.setTicketId(1000 + parkingUtils.getParkingTickets().size() + 1);
		parkingTicket.setSlotNumber(slot.getSlotNumber());
		parkingTicket.setRegistrationNumber(vehicle.getRegistrationNumber());
		parkingUtils.getParkingTickets().add(parkingTicket);
		return parkingTicket;
	}

	@Override
	public void parkVehicle(Vehicle vehicle) {
		Slot emptySlot = getNearestEmptySlot();
        if(emptySlot == null) {
        	System.out.println("Parking is full ...");
        } else {
            getParkingTicket(vehicle, emptySlot); 
            emptySlot.setVehicle(vehicle);
            emptySlot.setEmpty(false);
            System.out.println(vehicle.getRegistrationNumber() + " parked at Slot : " + emptySlot.getSlotNumber());
        }
	}

	@Override
	public void leaveParking(int slotNo) {
		// Empty the slot
    	Slot slot = Arrays.stream(parkingUtils.getSlots()).filter(s -> s.getSlotNumber() == slotNo).findFirst().get();
    	slot.setEmpty(true);
    	System.out.println("Slot #"+ slot.getSlotNumber() + " is Free to use now");
	}
        
}
