package com.parking.GojekParkingLot.model;

import java.util.Date;

public class ParkingTicket {
    
	private long ticketId;
    private String registrationNumber;
    private int slotNumber;
    private Date inTime;
	
    public ParkingTicket() {
    	this.inTime = new Date(System.currentTimeMillis());
    	//this.ticketId = (long)(Math.random() * 1000);
    }
    
    public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
    
    
}
