package com.sensei.mp3;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3Player {

	public static void main( String[] args ) {
		Player player;
		
		try {
			player = new Player( new FileInputStream( "/Users/Sensei/Music/abs.mp3" ) );
			player.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
