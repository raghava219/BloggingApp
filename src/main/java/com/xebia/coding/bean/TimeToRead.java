package com.xebia.coding.bean;

/**
 * This is TimeToRead POJO for returning JSON response
 * 
 * @author Raghava
 *
 */
public class TimeToRead {

	private int mins;

	private double seconds;

	public int getMins() {
		return mins;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}

	public double getSeconds() {
		return seconds;
	}

	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}

}
