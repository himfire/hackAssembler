package com.hopenshare.hackAss;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Code {
	public Code() throws IOException {
	}

	File x = new File("output.hack");
	BufferedWriter out = new BufferedWriter(new FileWriter(x, true));

	// Writer out = new FileWriter(x);
	public void getBin(String m) {
		String[] splitDes = null;
		boolean newLine = false;
		if (m.indexOf("=") != -1) {
			splitDes = m.split("=");
			comp(splitDes[1], true);
			Destination(splitDes[0]);
			newLine = true;
		} else if (m.contains(";")) {
			splitDes = m.split(";");
			comp(splitDes[0], true);
			jmp(splitDes[1], true);
			newLine = true;
		}
		if (newLine) {
			System.out.println("");
			try {
				out.append("\n");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void changeToBinary(String s) throws IOException {
		// System.out.print(s);
		try {
			int no = Integer.parseInt(s);
			int container[] = new int[15];
			int i = 0;
			while (no > 0) {
				container[i] = no % 2;
				i++;
				no = no / 2;
			}
			for (int o = 0; o <= 15 - i; o++) {
				System.out.print(0);
				try {
					out.append(Integer.toString(0));
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			for (int j = i - 1; j >= 0; j--) {
				System.out.print(container[j]);

				try {
					out.append(Integer.toString(container[j]));
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (NumberFormatException nfe) {
			changeText(s);
		}
		System.out.println("");
		try {
			out.write("\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void changeText(String s) {

	}

	public void writeToFile(String s) {
		System.out.print(s);

		try {
			out.append(s);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void print(String string) {
		System.out.println(string);
	}

	private void comp(String m, boolean cCode) {
		if (cCode) {
			writeToFile("111");
		}
		switch (m) {
		case "0":
			writeToFile("0101010");
			break;
		case "1":
			writeToFile("0111111");
			break;
		case "-1":
			writeToFile("0111010");
			break;
		case "D":
			writeToFile("0001100");
			break;
		case "A":
			writeToFile("0110000");
			break;
		case "!D":
			writeToFile("0001101");
			break;
		case "!A":
			writeToFile("0110001");
			break;
		case "-D":
			writeToFile("0001111");
			break;
		case "-A":
			writeToFile("0110011");
			break;
		case "D+1":
			writeToFile("0011111");
			break;
		case "A+1":
			writeToFile("0110111");
			break;
		case "D-1":
			writeToFile("0001110");
			break;
		case "A-1":
			writeToFile("0110010");
			break;
		case "D+A":
			writeToFile("0000010");
			break;
		case "D-A":
			writeToFile("0010011");
			break;
		case "A-D":
			writeToFile("0000111");
			break;
		case "D&A":
			writeToFile("0000000");
			break;
		case "D|A":
			writeToFile("0010101");
			break;
		case "M":
			writeToFile("1110000");
			break;
		case "!M":
			writeToFile("1110001");
			break;
		case "-M":
			writeToFile("1110011");
			break;
		case "M+1":
			writeToFile("1110111");
			break;
		case "M-1":
			writeToFile("1110010");
			break;
		case "D+M":
			writeToFile("1000010");
			break;
		case "D-M":
			writeToFile("1010011");
			break;
		case "M-D":
			writeToFile("1000111");
			break;
		case "D&M":
			writeToFile("1000000");
			break;
		case "D|M":
			writeToFile("1010101");
			break;
		}
	}

	private void jmp(String m, boolean destination) {
		if (destination) {
			writeToFile("000");
		}
		switch (m) {
		case "JGT":
			writeToFile("001");
			break;
		case "JEQ":
			writeToFile("010");
			break;
		case "JGE":
			writeToFile("011");
			break;
		case "JLT":
			writeToFile("100");
			break;
		case "JNE":
			writeToFile("101");
			break;
		case "JLE":
			writeToFile("110");
			break;
		case "JMP":
			writeToFile("111");
			break;
		}
	}

	private void Destination(String m) {
		// System.out.println("here " +m);
		String[] jmpValue = m.split(";");
		boolean checkJmp = m.contains(";");
		switch (jmpValue[0]) {
		case "M":
			writeToFile("001");
			break;
		case "D":
			writeToFile("010");
			break;
		case "MD":
			writeToFile("011");
			break;
		case "A":
			writeToFile("100");
			break;
		case "AM":
			writeToFile("101");
			break;
		case "AD":
			writeToFile("110");
			break;
		case "AMD":
			writeToFile("111");
		}
		if (checkJmp) {
			jmp(jmpValue[1], false);
		} else {
			writeToFile("000");
		}
	}
}