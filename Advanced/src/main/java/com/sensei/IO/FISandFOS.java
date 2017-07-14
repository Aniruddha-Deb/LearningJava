package com.sensei.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FISandFOS {

	public FISandFOS() throws IOException {
		FileInputStream fis = new FileInputStream( "/Users/Sensei/xanadu.txt" );
		FileOutputStream fos = new FileOutputStream( "/Users/Sensei/outagain.txt" );
		int c;
		
		while( (c = fis.read()) != -1 ) {
			System.out.print( (char)c );
			fos.write( c );
		}
		fis.close();
		fos.close();
	}
	
	public static void main(String[] args) {
		try {
			new FISandFOS();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
