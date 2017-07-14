package com.sensei.Networking.poc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket s = new Socket( "127.0.0.1" , 4343 );
		ObjectInputStream ois = new ObjectInputStream( s.getInputStream() );
		ArrayList<String> test = (ArrayList<String>)ois.readObject();
		System.out.println( test.get(0) );
		
	}

}
