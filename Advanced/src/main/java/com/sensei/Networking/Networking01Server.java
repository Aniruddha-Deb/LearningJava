package com.sensei.Networking;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Networking01Server {

	ServerSocket ss = null;
	private BufferedInputStream bis;
	
	public Networking01Server() throws IOException {
		ss = new ServerSocket( 4242 );
	}
	
	public void runServer() throws Exception {
		while( true ) {
			System.out.println( "Waiting for client to connect." ) ;
			Socket s = ss.accept();
			System.out.println( "Received a client connection." ) ;
			
			BufferedReader br = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
			String text = br.readLine() ;
			System.out.println( text );
			
			File mp3file = null;
			if( text.equals( "s" ) ) {
				mp3file = new File( "/Users/Sensei/Music/abs.mp3" );
			}
			else if( text.equals( "m" ) ) {
				mp3file = new File( "/Users/Sensei/Music/Blasterjaxx - Mystica.mp3" );
			}
			else {
				mp3file = new File( "/Users/Sensei/Music/08. Major Lazer – Lean On (feat. MØ and DJ Snake).mp3" );
			}
			
			byte[] song = new byte[(int) mp3file.length()];
			
			bis = new BufferedInputStream( new FileInputStream( mp3file ) );
			bis.read( song );
			OutputStream os = s.getOutputStream();
			os.write( song );
			
			s.close();
		}
	}
	
	public static void main( String[] args ) throws Exception {
		new Networking01Server().runServer() ;
	}
}
