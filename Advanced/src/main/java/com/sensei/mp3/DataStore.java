package com.sensei.mp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class DataStore {
	
	public static void main(String[] args) throws IOException, JavaLayerException, ClassNotFoundException {
		File folder = new File( "/Users/Sensei/Music/Sensei - Top 30 electro house hits 2014" );
		String string = "Dimitri Vegas, Like Mike, W&W - Waves.mp3";
		FileInputStream fis = null;
		
		for( File file : folder.listFiles() ) {
			if( file.getName().equals( string ) ) {
				fis = new FileInputStream( "/Users/Sensei/Music/Sensei - Top 30 electro house hits 2014/" + string );
			}
		}

		Player player = new Player( fis );
		player.play();
	}

}
