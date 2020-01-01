package com.parking.GojekParkingLot.model;

public class Slot {
    
	private int slotNumber;
    private Vehicle vehicle;
    private boolean isEmpty = true;
	
    public Slot() {
    }
    
    public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Slot [slotNumber=");
		builder.append(slotNumber);
		builder.append(", vehicle=");
		builder.append(vehicle);
		builder.append(", isEmpty=");
		builder.append(isEmpty);
		builder.append("]");
		return builder.toString();
	}
    
    
}
