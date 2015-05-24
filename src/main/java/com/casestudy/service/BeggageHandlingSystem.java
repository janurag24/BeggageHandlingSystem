package com.casestudy.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import com.casestudy.domain.Bag;
import com.casestudy.domain.Departure;
import com.casestudy.domain.graph.Edge;
import com.casestudy.domain.graph.Graph;

import static com.casestudy.util.Constants.*;

/**
 */
public class BeggageHandlingSystem {
	private String outputFileName;
	final static Logger logger = Logger.getLogger(BeggageHandlingSystem.class);
	
	/**
	 * Method getOutputFileName.
	 * @return String
	 */
	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * Method setOutputFileName.
	 * @param outputFileName String
	 */
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	/**
	 * Method execute.
	 * @param args String[]
	 * @throws IOException
	 */
	public void execute(String[] args) throws IOException {
		List<Edge> conveyorSystemEdge = new ArrayList<Edge>();
		Map<String, Departure> departureMap = new HashMap<String, Departure>();
		List<Bag> bagsList = new ArrayList<Bag>();
		File file = null;
		BufferedWriter writer = null;
		
		logger.info("BeggerHandlingSystem::execute() Starts");
		readFile(args[0], conveyorSystemEdge, departureMap, bagsList);
		validateFileContent(conveyorSystemEdge, departureMap, bagsList);

		try {
			file = new File(getOutputFileName());
			writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile()),
					32768);

			Graph graph = new Graph(conveyorSystemEdge);
		
			for (Bag bag : bagsList) {
				String destination = new String();

				graph.computeShortestPath(bag.getEntryPoint()); 

				if (StringUtils.equals(bag.getFlightId(), ARRIVAL)) {
					destination = ARRIVAL_BAGGAGEGATE;
				} else {
					if (departureMap.containsKey(bag.getFlightId())) {
						Departure deprtDetail = departureMap.get(bag
								.getFlightId());
						destination = deprtDetail.getFlightGate();
					} else {
						destination = null;
					}
				}

				if (StringUtils.isNotBlank(destination)) {
					FileUtils.writeStringToFile(file, bag.getBagNo() + SPACE,
							true);
					writer.write(bag.getBagNo() + SPACE);
					writer.flush();
					String output = graph.printPath(destination);
					writer.write(output);
					writer.write(System.getProperty("line.separator"));
					writer.flush();
				} else {
					logger.error("The flight id " + bag.getFlightId()
							+ " does not exist. Please check input file");
				}
			}
		} catch (IOException exception) {
			logger.error("Exception while writing to the file", exception);
		} finally {
			// file
			if (writer != null)
				try {
					writer.close();
				} catch (IOException exception) {
					logger.error("Exception while writing to the file", exception);
				}
		}
		logger.info("BeggerHandlingSystem::execute() Ends");

	}

	/**
	 * Method validateFileContent.
	 * @param conveyorSystemEdge List<Edge>
	 * @param departureMap Map<String,Departure>
	 * @param bagsList List<Bag>
	 */
	public void validateFileContent(List<Edge> conveyorSystemEdge,
			Map<String, Departure> departureMap, List<Bag> bagsList) {
		boolean existFlag = false;

		logger.info("BeggerHandlingSystem::validateFileContent() Starts");

		if (bagsList.size() == 0) {
			logger.error("There is no beggage list. Please check the input file for Baggage section");
			existFlag = true;
		}
		if (conveyorSystemEdge.size() == 0) {
			logger.error("There is no Conveyor System list. Please check the input file for Conveyor System section");
			existFlag = true;
		}
		if (departureMap.size() == 0) {
			logger.error("There is no Departure list. Please check the input file for Departure section");
			existFlag = true;
		}
		if (existFlag) {
			logger.error("Existing BeggerHandlingSystem::validateFileContent()");
			System.exit(0);
		}
		logger.info("BeggerHandlingSystem::validateFileContent() Ends");
		
	}

	/**
	 * Method readFile.
	 * @param fileName String
	 * @param conveyorSystemEdge List<Edge>
	 * @param departureMap Map<String,Departure>
	 * @param bagsList List<Bag>
	 * @throws IOException
	 */
	public void readFile(String fileName, List<Edge> conveyorSystemEdge,
			Map<String, Departure> departureMap, List<Bag> bagsList)
			throws IOException {
		boolean conveyorData = false;
		boolean bagsData = false;
		boolean departureData = false;
		FileReader fr = null;
		BufferedReader br = null; 
		logger.info("BeggerHandlingSystem::readFile() Starts");

		try {
			fr = new FileReader(new File(fileName));
			br = new BufferedReader(fr);
			String sLine;
			logger.info("BeggerHandlingSystem::readFile() read a file");

			while ((sLine = br.readLine()) != null) {
				if (!StringUtils.isEmpty(sLine)) {
					if (StringUtils.contains(sLine, SECTION)
							&& StringUtils.contains(sLine, CONVEYORSYSTEM)) {
						conveyorData = true;
						departureData = false;
						bagsData = false;
					} else if (StringUtils.contains(sLine, SECTION)
							&& StringUtils.contains(sLine, DEPARTURES)) {
						conveyorData = false;
						departureData = true;
						bagsData = false;
					} else if (StringUtils.contains(sLine, SECTION)
							&& StringUtils.contains(sLine, BAGS)) {
						conveyorData = false;
						departureData = false;
						bagsData = true;
					} else if (conveyorData && !departureData && !bagsData) {
						String[] splitArr = StringUtils.split(sLine, " ");
						if (ArrayUtils.getLength(splitArr) == 3) {
							Edge edge1 = new Edge(splitArr[0], splitArr[1],
									NumberUtils.toInt(splitArr[2]));
							conveyorSystemEdge.add(edge1);
						}
					} else if (!conveyorData && departureData && !bagsData) {
						String[] splitArr = StringUtils.split(sLine, " ");
						if (ArrayUtils.getLength(splitArr) == 4) {
							Departure deprt = new Departure(splitArr[0],
									splitArr[1], splitArr[2], splitArr[3]);
							departureMap.put(splitArr[0], deprt);
						}
					} else if (!conveyorData && !departureData && bagsData) {
						String[] splitArr = StringUtils.split(sLine, " ");
						if (ArrayUtils.getLength(splitArr) == 3) {
							Bag bag = new Bag(splitArr[0], splitArr[1],
									splitArr[2]);
							bagsList.add(bag);
						}
					}
				}
			}
		} catch (IOException e) {
			logger.error("Exception in BeggerHandlingSystem::readFile()", e);
		} finally {
			if (br != null) {
				br.close();
				logger.info("BeggerHandlingSystem::readFile()   BufferedReader closed");
			}
			if (fr != null) {
				fr.close();
				logger.info("BeggerHandlingSystem::readFile()   FileReader closed");
			}
		}
		logger.info("BeggerHandlingSystem::readFile() Ends");
	}
}
