package com.hopenshare.hackAss;

import java.util.Scanner;

public class Parser {

	public void unpack(Scanner file) {
		int count = 0;
		String[] content = new String[200];
		Code bin = new Code();
		SymbolTable c = new SymbolTable();
		while (file.hasNext()) {
			int no = 1;
			content[++count] = file.nextLine();
			// System.out.println(content[count]);
			String[] subContent = content[count].split("\n", 0);
			for (String m : subContent) {
				count = 0;
				char[] ch_arr = m.toCharArray();
				for (char f : ch_arr) {
					switch (f) {
					case '@':
						if (count == 0) {
							SymbolTable.checkTable(m.substring(1));
							break;
						}

					default:
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
