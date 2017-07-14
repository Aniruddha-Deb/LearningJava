package com.sensei.EventListener;

public class App {

	public static void main(String[] args) {
	
		EventListener listener = new EventListener();
		EventListener.ButtonListener buttonListener = new EventListener.ButtonListener();
		EventListener.TextListener textListener = new EventListener.TextListener();
		EventListener.FrameListener frameListener = new EventListener.FrameListener();

		Panel panel = new Panel( buttonListener, textListener );
		listener.setPanel( panel );
		Frame frame = new Frame( "Event listener", 500, 500, panel, frameListener );
		frame.setVisible( true );
	}
	
}
