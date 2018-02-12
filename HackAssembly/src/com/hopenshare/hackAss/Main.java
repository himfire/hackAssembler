package com.hopenshare.hackAss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			//Reading the file
			Scanner file = extracted().useDelimiter(",\\s*");
			Parser codeFile = new Parser();
			final Formatter x;
			try{
				x = new Formatter("output.hack");
				System.out.println("file output.hack is created");
				x.close();
			}catch(FileNotFoundException e){
				System.out.println("File isn't created");
			}
			try {
				codeFile.unpack(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			file.close();
		} catch (
		FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException ef) {
			ef.printStackTrace();
		}
	}

	private static Scanner extracted() throws FileNotFoundException {
		return new Scanner(new File("PongL.asm"));
	}
}
