package com.hopenshare.hackAss;

public class SymbolTable {

	public static void checkTable(String c) {
		Code bin = new Code();
		//compare the String 
		if (c.indexOf("R") != -1) {
			bin.changeToBinary(c.substring(c.lastIndexOf("R") + 1));
		}else if(c.indexOf("SCREEN") != -1){
			//
			//
			//The problem is here the condition always isn't correct
			//
			//System.out.println("here");
			bin.print("0100000000000000");
		}else if(c.indexOf("KBD") != -1){
			bin.print("0110000000000000");
		}else if(c.indexOf("SP") != -1){
			bin.print("0000000000000001");
		}else if(c.indexOf("LCL") != -1){
			bin.print("0000000000000010");
		}else if(c.indexOf("ARG") != -1){
			bin.print("0000000000000011");
		}else if(c.indexOf("THIS") != -1){
			bin.print("0000000000000100");
		}else{
			bin.changeToBinary(c);
		}
	}
}
