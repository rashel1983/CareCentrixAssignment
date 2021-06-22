package com.carecentrix.util;

import java.time.LocalDate;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenerateRandom {
	private static Logger logger= LogManager.getLogger(GenerateRandom.class);
	/**
	 * This method will generate random date of birth and return the value as string 
	 * @return{String}
	 */
	static String generateRandomDOB() {
		Random random = new Random();
		int minDay = (int) LocalDate.of(1950, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		String randomDOB = randomBirthDate.toString();
		logger.info("Random date of birth generated successfully and the value is '"+randomBirthDate+"'");
		return randomDOB;
	}
	
	/**
	 * This method will generate random ID and return the value as string 
	 * @return{String}
	 */
	static String generateRandomId() {
		int min = 1000;
		int max = 2000;
		int randomID = (int) Math.floor(Math.random() * (max - min + 1) + min);
		String iD = Integer.toString(randomID);
		logger.info("Random ID generated successfully and the value is '"+randomID+"'");
		return iD;
	}
	
	/**
	 * This method will generate random gender  and return the value as string 
	 * @return{String}
	 */
	static String randomGender() {
		 String gender;
		  if(Math.random() > 0.5) gender  = "M";
		  else gender = "F";
		  logger.info("Random gender generated successfully and the value is '"+gender+"'");
		  return gender;
	}
}
