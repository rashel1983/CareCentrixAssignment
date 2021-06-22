package com.carecentrix.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CopyFile {

	private static Logger logger = LogManager.getLogger(CopyFile.class);

	/**
	 * This method will copy the csv file from one location to another location if
	 * the file already exist in destination location then it will delete the
	 * existing file before copy the file to destination folder
	 */
	public static void copyCSVfile() {
		File file = new File("./src/main/resources/sample.csv");

		if (file.delete()) {
			logger.info("File deleted successfully");
		} else {
			logger.info("No existing file to delete");
		}

		FileSystem fileSys = FileSystems.getDefault();
		Path srcPath = fileSys.getPath("./src/test/resources/sample.csv");
		Path destPath = fileSys.getPath("./src/main/resources/sample.csv");
		try {
			Files.copy(srcPath, destPath, StandardCopyOption.COPY_ATTRIBUTES);
			logger.info("File Coppied to '" + destPath + "'");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
