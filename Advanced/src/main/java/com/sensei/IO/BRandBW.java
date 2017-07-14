package com.sensei.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BRandBW {

	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public BRandBW() throws IOException {
		br = new BufferedReader( new FileReader( "/Users/Sensei/xanadu.txt" ) );
		bw = new BufferedWriter( new FileWriter( "/Users/Sensei/outagain.txt" ) );
		String l;
		
		while( (l = br.readLine()) != null ) {
			System.out.println( l );
			bw.write( l );
		}
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) {
		try {
			new BRandBW();
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
