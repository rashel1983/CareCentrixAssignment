package com.carecentrix.runner;

import java.io.IOException;

import com.carecentrix.util.CopyFile;
import com.carecentrix.util.GenerateCSVfile;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		GenerateCSVfile.generateCSVfile();
		CopyFile.copyCSVfile();
	}

}
