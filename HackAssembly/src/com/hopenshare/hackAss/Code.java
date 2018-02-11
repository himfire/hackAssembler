package com.hopenshare.hackAss;

public class Code {
	public void getBin(String m) {
		String[] splitDes = null;
		boolean newLine = false;
		if (m.indexOf("=") != -1) {
			splitDes = m.split("=");
			comp(splitDes[1],true);
			Destination(splitDes[0]);
			newLine = true;
		} else if (m.contains(";")) {
			splitDes = m.split(";");
			comp(splitDes[0],true);
			jmp(splitDes[1],true);
			newLine = true;
		}
		if(newLine){
			System.out.println("");
		}
	}

	public void changeToBinary(String s) {
		//System.out.print(s);
		try{
			int no = Integer.parseInt(s);
			int container[] = new int[15];
		    int i = 0;
		    while (no > 0){
		        container[i] = no%2;
		        i++;
		        no = no/2;
		    }
		    for(int o = 0;o<=15-i;o++){
		    	System.out.print(0);
		    }
		    for (int j = i -1 ; j >= 0 ; j--){
		        System.out.print(container[j]);
		    }	
		}catch(NumberFormatException nfe){  
			changeText(s);
		}
		System.out.println("");
	}

	private void changeText(String s) {
		
	}

	public void print(String string) {
		System.out.println(string);
	}
	private void comp(String m,boolean cCode) {
		if(cCode){
			System.out.print("111");
		}
		switch (m) {
		case "0":
			System.out.print("0101010");
			break;
		case "1":
			System.out.print("0111111");
			break;
		case "-1":
			System.out.print("0111010");
			break;
		case "D":
			System.out.print("0001100");
			break;
		case "A":
			System.out.print("0110000");
			break;
		case "!D":
			System.out.print("0001101");
			break;
		case "!A":
			System.out.print("0110001");
			break;
		case "-D":
			System.out.print("0001111");
			break;
		case "-A":
			System.out.print("0110011");
			break;
		case "D+1":
			System.out.print("0011111");
			break;
		case "A+1":
			System.out.print("0110111");
			break;
		case "D-1":
			System.out.print("0001110");
			break;
		case "A-1":
			System.out.print("0110010");
			break;
		case "D+A":
			System.out.print("0000010");
			break;
		case "D-A":
			System.out.print("0010011");
			break;
		case "A-D":
			System.out.print("0000111");
			break;
		case "D&A":
			System.out.print("0000000");
			break;
		case "D|A":
			System.out.print("0010101");
			break;
		case "M":
			System.out.print("1110000");
			break;
		case "!M":
			System.out.print("1110001");
			break;
		case "-M":
			System.out.print("1110011");
			break;
		case "M+1":
			System.out.print("1110111");
			break;
		case "M-1":
			System.out.print("1110010");
			break;
		case "D+M":
			System.out.print("1000010");
			break;
		case "D-M":
			System.out.print("1010011");
			break;
		case "M-D":
			System.out.print("1000111");
			break;
		case "D&M":
			System.out.print("1000000");
			break;
		case "D|M":
			System.out.print("1010101");
			break;
		}	
	}
	
	private void jmp(String m,boolean destination) {
		if(destination){
			System.out.print("000");
		}
		switch (m) {
		case "JGT":
			System.out.print("001");
			break;
		case "JEQ":
			System.out.print("010");
			break;
		case "JGE":
			System.out.print("011");
			break;
		case "JLT":
			System.out.print("100");
			break;
		case "JNE":
			System.out.print("101");
			break;
		case "JLE":
			System.out.print("110");
			break;
		case "JMP":
			System.out.print("111");
			break;
		}
	}

	private void Destination(String m) {
		// System.out.println("here " +m);
		String[] jmpValue = m.split(";");
		boolean checkJmp = m.contains(";");
		switch (jmpValue[0]) {
		case "M":
			System.out.print("001");
			break;
		case "D":
			System.out.print("010");
			break;
		case "MD":
			System.out.print("011");
			break;
		case "A":
			System.out.print("100");
			break;
		case "AM":
			System.out.print("101");
			break;
		case "AD":
			System.out.print("110");
			break;
		case "AMD":
			System.out.print("111");
		}
		if(checkJmp){
			jmp(jmpValue[1],false);
		}else{			
			System.out.print("000");
		}
	}
}