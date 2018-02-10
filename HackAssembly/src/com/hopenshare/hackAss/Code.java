package com.hopenshare.hackAss;

public class Code {
	public void getBin(String m) {
		
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
}