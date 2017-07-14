package com.sensei.Networking.poc;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket( 4343 );
		
		ArrayList<String> data = new ArrayList<String>();
		data.add( "test" );
		data.add( "test2" );
		while( true ) {
			Socket s = ss.accept();
			ObjectOutputStream oos = new ObjectOutputStream( s.getOutputStream() );
			oos.writeObject( data );
			oos.flush();
		}
	}

}
