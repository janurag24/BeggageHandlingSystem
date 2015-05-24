package com.casestudy.client;

import java.io.IOException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.casestudy.service.BeggageHandlingSystem;

/**
 */
public class BeggageHandlingClient {
	final static Logger LOGGER = Logger.getLogger(BeggageHandlingClient.class);

	/**
	 * Method main.
	 * @param args String[]
	 */
	public static void main(String[] args) {
		LOGGER.info("BeggerHandlingClient::main() Starts");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		if (ArrayUtils.getLength(args) == 0) {
			LOGGER.error("Proper Usage is: java BeggageHandlingClient filename");
			System.exit(0);
		}

		BeggageHandlingSystem application = (BeggageHandlingSystem) context
				.getBean("beggageHandlingSystem");
		try {
			application.execute(args);
		} catch (IOException e) {
			LOGGER.error("IO Exception in BeggageHandlingClient::main()", e);
		}
		LOGGER.info("BeggerHandlingClient::main() Ends");
	}
}
