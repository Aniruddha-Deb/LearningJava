package com.sensei.MIDISequencer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;

import javax.sound.midi.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MiniMusicApp implements ControllerEventListener{

	private static JFrame frame = new JFrame( "MiniMusicApp" );
	private static DrawPanel panel;
	
	private BufferedReader reader = null ;
	
	public static void main(String[] args) {
		new MiniMusicApp().play();
	}
	
	private void setUpUI() {
		panel = new DrawPanel();
		frame.setSize( 400, 400 );
		frame.setContentPane( panel );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible( true );
	}
	
	private void play() {
		setUpUI();
		
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener( this , eventsIWant );
			
			Sequence sequence = new Sequence( Sequence.PPQ, 4 );
			Track track = sequence.createTrack();
			
			for( int i=5; i<61; i+=4 ) {
				track.add( makeEvent(144, 1, i, 100, i) );
				track.add( makeEvent(176, 1, 127, 0, i) ); // detector event
				track.add( makeEvent(128, 1, i, 100, i+2) );
			}
			
			sequencer.setSequence( sequence );
			sequencer.setTempoInBPM( 220 );
			sequencer.start();
		}
		catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
	
	private MidiEvent makeEvent( int comd, int chan, int one, int two, int tick ) {
		MidiEvent event = null;
		
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage( comd, chan, one, two );
			event = new MidiEvent( a, tick );
		}
		catch( Exception e ) {}
		
		return event;
	}

	public void controlChange(ShortMessage event) {
		panel.controlChange(event);
	}
	
	class DrawPanel extends JPanel implements ControllerEventListener {
		boolean msg = false;
		
		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		}

		@Override
		public void paintComponent( Graphics g ) {
			if( msg ) {
				Graphics2D g2d = (Graphics2D) g;
				
				int r = (int) (Math.random()*255);
				int gr = (int) (Math.random()*255);
				int b = (int) (Math.random()*255);
				
				g2d.setColor( new Color( r, gr, b ) );
				int ht = (int) ( (Math.random()*120) + 10 );
				int width = (int) ( (Math.random()*120) + 10 );
				
				int x = (int) ((Math.random() * 40) + 10);
				int y = (int) ((Math.random() * 40) + 10);

				g.fillRect( x, y, width, ht );
				msg = false;
			}
		}
	}

}
