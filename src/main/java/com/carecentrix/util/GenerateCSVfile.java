package com.carecentrix.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenerateCSVfile {
	private static Logger logger = LogManager.getLogger(GenerateCSVfile.class);
	
	private static final String SAMPLE_CSV_FILE = "./src/test/resources/sample.csv";

	
	/**
	 * This method will generate the csv file 
	 * @throws IOException
	 */
	public static void generateCSVfile() throws IOException {
		File file = new File("./src/test/resources/sample.csv");

		if (file.delete()) {
			logger.info("File deleted successfully");
		} else {
			logger.info("Failed to delete the file");
		}

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

				CSVPrinter csvPrinter = new CSVPrinter(writer,
						CSVFormat.DEFAULT.withHeader("ID","FirstName", "LastName",  "Gender", "DOB", "Address"));) {
			csvPrinter.printRecord(GenerateRandom.generateRandomId(), "Firstname1", "LastName1", GenerateRandom.randomGender(),
					GenerateRandom.generateRandomDOB(), "Address1");
			csvPrinter.printRecord(GenerateRandom.generateRandomId(), "Firstname2", "LastName2", GenerateRandom.randomGender(),
					GenerateRandom.generateRandomDOB(), "Address2");
			csvPrinter.printRecord(GenerateRandom.generateRandomId(), "Firstname3", "LastName3", GenerateRandom.randomGender(),
					GenerateRandom.generateRandomDOB(), "Address3");
			csvPrinter.printRecord(GenerateRandom.generateRandomId(), "Firstname4", "LastName3", GenerateRandom.randomGender(),
					GenerateRandom.generateRandomDOB(), "Address4");
			logger.info("CSV file generated successfully and saved in location '" + SAMPLE_CSV_FILE + "'");
			csvPrinter.flush();
		}

	}

}
