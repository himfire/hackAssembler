package com.hopenshare.hackAss;

import java.util.Scanner;

public class Parser {

	public void unpack(Scanner file) {
		//getting the file line by line
		int count = 0;
		String[] content = new String[200];
		Code bin = new Code();
		SymbolTable c = new SymbolTable();
		while (file.hasNext()) {
			int no = 1;
			content[++count] = file.nextLine();
			String[] subContent = content[count].split("\n", 0);
			for (String m : subContent) {
				count = 0;
				char[] ch_arr = m.toCharArray();
				for (char f : ch_arr) {
					switch (f) {
					//Check if the line at the beginning contains letter @
					case '@':
						if (count == 0) {
							SymbolTable.checkTable(m.substring(1));
							break;
						}

					default:
						//change direct to binary
						if (count == 0) {
							bin.getBin(m);
						}
						count++;
					}
				}
			}
		}		
	}
}
