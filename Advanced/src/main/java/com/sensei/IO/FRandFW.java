package com.sensei.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FRandFW {

	FileReader fr = null;
	FileWriter fw = null;
	
	public FRandFW() throws IOException {
		fr = new FileReader( "/Users/Sensei/xanadu.txt" );
		fw = new FileWriter( "/Users/Sensei/outagain.txt" );
		int c;
			
		while( (c=fr.read()) != -1 ) {				
			System.out.print( (char)c );
			fw.write( c );
		}
		fr.close();
		fw.close();
	}

	public static void main(String[] args) {
		try {
			new FRandFW();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
