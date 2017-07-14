package com.sensei.IO.objectIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OOSandOIS {
	
	public static final long serialVersionUID = 6553687584L; 

	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	
	public OOSandOIS() throws Exception{
		oos = new ObjectOutputStream( new FileOutputStream( "/Users/Sensei/outagain.txt" ) );
		ois = new ObjectInputStream( new FileInputStream( "/Users/Sensei/outagain.txt" ) );
		
		oos.writeObject( new Character( "Magician", 200 ) );
		oos.writeObject( new Character( "Troll", 120 ) );
		
		Character magician = (Character) ois.readObject();
		Character troll = (Character) ois.readObject();
		System.out.println( magician.getName() );
		System.out.println( troll.getName() );
	}

	public static void main(String[] args) {
		try {
			new OOSandOIS();
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}

}
