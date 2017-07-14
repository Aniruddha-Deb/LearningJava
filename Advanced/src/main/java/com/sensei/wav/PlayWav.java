package com.sensei.wav;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class PlayWav {

	private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;

    public void playSound(String filename){

        String strFilename = filename;

        try {
            soundFile = new File(strFilename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }
    
	private static Map<String, File> buildDatabase( String dir ) {
		Map<String, File> database = new HashMap<String, File>();
		
		File folder = new File( dir );

		for( File file : folder.listFiles() ) {
			if( file.isDirectory() ) {
				buildDatabase( dir + "/" + file.getName() );
			}
			else {
				if( file.getName().endsWith( ".wav" ) ) {
					database.put( file.getName(), file );
				}
			}
		}
		
		return database;
	}
	
    public static void main(String[] args) {
    	System.out.println( "Building database, please wait" );
    	Map<String, File> database = buildDatabase( "/Users/Sensei/music/twoplayer" );
    	System.out.println( "Built database" );
    	
    	PlayWav player = new PlayWav();
    	Scanner sc = new Scanner( System.in );
    	
    	while( true ) {
    		System.out.print( "> " );
    		String input = sc.nextLine();
    		
    		if( input.equals( "quit" ) ) {
    			sc.close();
    			System.exit( 0 );
    		}
    		
    		String[] tokens = input.split( " " );
    		for( String s : tokens ) {
    			File outFile = database.get( s + ".wav" );
    			player.playSound( outFile.getAbsolutePath() );
    		}
    	}
	}

}
