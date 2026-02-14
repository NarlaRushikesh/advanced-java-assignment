package com.capgemini.OneToOneUnidirectional;

import jakarta.persistence.*;

@Entity
public class Locker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lockerId;
	private int lockerNumber;
	private int floor;
	
	public Locker() {
		
	}

	public Locker(int lockerNumber, int floor) {
		this.lockerNumber = lockerNumber;
		this.floor = floor;
	}

	public Long getLockerId() {
		return lockerId;
	}

	public int getLockerNumber() {
		return lockerNumber;
	}

	public void setLockerNumber(int lockerNumber) {
		this.lockerNumber = lockerNumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", lockerNumber=" + lockerNumber + ", floor=" + floor + "]";
	}

}
