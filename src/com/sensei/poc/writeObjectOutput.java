package com.sensei.poc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class writeObjectOutput {

	public static void main(String[] args) {
		
		int UID = 15;
		int val = 0;
		
		try {
			FileOutputStream   fos = new FileOutputStream( "/Users/Sensei/test.txt" ) ;
			ObjectOutputStream oos = new ObjectOutputStream( fos ) ;
			FileInputStream   fis = new FileInputStream( "/Users/Sensei/test.txt" ) ;
			ObjectInputStream ois = new ObjectInputStream( fis ) ;
			
			oos.writeInt( UID );
			val = ois.readInt();
			oos.close();
			ois.close();
		}
		catch( Exception e ){
			e.printStackTrace( );
		}
		
		System.out.println( val );
		
	}

}
