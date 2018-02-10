package com.hopenshare.hackAss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			//Reading the file
			Scanner file = extracted().useDelimiter(",\\s*");
			Parser codeFile = new Parser();
			codeFile.unpack(file);
			file.close();
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException ef) {
			ef.printStackTrace();
		}
	}

	private static Scanner extracted() throws FileNotFoundException {
		return new Scanner(new File("test.txt"));
	}
}
