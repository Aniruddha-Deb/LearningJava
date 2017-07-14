package com.sensei.Networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Networking01 {

	public Networking01() throws UnknownHostException, IOException, JavaLayerException {
		System.out.println( "Connecting to server." ) ;
		Socket socket = new Socket( "127.0.0.1", 4242 ) ;
		System.out.println( "Connected to server." ) ;
		Scanner scanner = new Scanner( System.in );
		
		System.out.println( "enter s for snake, m for mystica, l for lean on:" );
		String s = scanner.nextLine();
		PrintWriter writer = new PrintWriter( socket.getOutputStream() );
		writer.println( s );
		writer.flush();

		Player player = new Player( socket.getInputStream() );
		player.play();
		
		socket.close();
		scanner.close();
	}

	public static void main(String[] args) {
		try {
			new Networking01();
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
