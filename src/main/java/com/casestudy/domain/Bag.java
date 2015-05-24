package com.casestudy.domain;

import static com.casestudy.util.Constants.*;

/**
 */
public final class Bag {
	private final String bagNo;
	private final String entryPoint;
	private final String flightId;

	/**
	 * Constructor for Bag.
	 * @param bagNo String
	 * @param source String
	 * @param flightId String
	 */
	public Bag(String bagNo, String source, String flightId) {
		this.bagNo = bagNo;
		this.entryPoint = source;
		this.flightId = flightId;
	}

	/**
	 * Method getBagNo.
	 * @return String
	 */
	public String getBagNo() {
		return bagNo;
	}

	/**
	 * Method getEntryPoint.
	 * @return String
	 */
	public String getEntryPoint() {
		return entryPoint;
	}

	/**
	 * Method getFlightId.
	 * @return String
	 */
	public String getFlightId() {
		return flightId;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Bag :" + bagNo + SPACE + entryPoint + SPACE + flightId;
	}

}
