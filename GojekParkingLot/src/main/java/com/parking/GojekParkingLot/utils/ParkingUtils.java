package com.parking.GojekParkingLot.utils;

import java.util.ArrayList;
import java.util.List;

import com.parking.GojekParkingLot.model.ParkingTicket;
import com.parking.GojekParkingLot.model.Slot;

public class ParkingUtils {
	
	private static volatile ParkingUtils parkingUtils;
	private List<ParkingTicket> parkingTickets;
    private Slot[] slots;
    
    public static ParkingUtils getUtilsInstance() {
	    synchronized (ParkingUtils.class) {
			if (parkingUtils == null) {
				parkingUtils = new ParkingUtils();
			}
		}
		return parkingUtils;
	}
    
    public void initializeParking(int slots) {
    	this.parkingTickets = new ArrayList<>();
    	this.slots = new Slot[slots];
		for(int i =0 ; i < slots ; i++) {
            Slot slot = new Slot();
            slot.setSlotNumber(i + 1);
            this.slots[i] = slot; 
		}
    }

	public List<ParkingTicket> getParkingTickets() {
		return parkingTickets;
	}

	public Slot[] getSlots() {
		return slots;
	}
    
}
