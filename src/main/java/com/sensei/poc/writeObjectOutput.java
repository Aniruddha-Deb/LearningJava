package com.sensei.poc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class writeObjectOutput {

	private static int UID = 15;
	private static int val = 0;

	public static void main(String[] args) throws Exception{
		
			writeToFile();
			readToFile();
			System.out.println( val );
	}
	
	public static void writeToFile() throws Exception{
		FileOutputStream   fos = new FileOutputStream( "/Users/Sensei/test.txt" ) ;
		ObjectOutputStream oos = new ObjectOutputStream( fos ) ;
		oos.writeInt( UID );
		oos.close();
	}
	
	public static void readToFile() throws Exception{
		FileInputStream   fis = new FileInputStream( "/Users/Sensei/test.txt" ) ;
		ObjectInputStream ois = new ObjectInputStream( fis ) ;
		val = ois.readInt();
		ois.close();
		
	}

}
