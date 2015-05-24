package com.casestudy.domain;

import static com.casestudy.util.Constants.*;

/**
 */
public final class Departure {
	private final String flightNumber, gate, destinationCode, flightTime;

	/**
	 * Constructor for Departure.
	 * @param flightno String
	 * @param gate String
	 * @param dest String
	 * @param time String
	 */
	public Departure(String flightno, String gate, String dest, String time) {
		this.flightNumber = flightno;
		this.gate = gate;
		this.destinationCode = dest;
		this.flightTime = time;
	}

	/**
	 * Method getFlightNumber.
	 * @return String
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * Method getFlightGate.
	 * @return String
	 */
	public String getFlightGate() {
		return gate;
	}

	/**
	 * Method getDestination_code.
	 * @return String
	 */
	public String getDestination_code() {
		return destinationCode;
	}

	/**
	 * Method getFlightTime.
	 * @return String
	 */
	public String getFlightTime() {
		return flightTime;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Departure: " + flightNumber + SPACE + gate + SPACE
				+ destinationCode + SPACE + flightTime;
	}
}
