package com.sensei.EventListener;

import java.awt.event.*;

public class EventListener {
	
	public void setPanel( Panel panel ) {
		this.panel = panel;
	}
	static Panel panel;
	
	public static class ButtonListener implements ActionListener{
		
		int numClicks = 0;
		
		public void actionPerformed( ActionEvent e ) {
			if( e.getSource() == panel.button ) {
				numClicks++;
				panel.textArea.append( "Button Clicked " + numClicks + " times\n" );
			}
		}
	}
	
	public static class TextListener implements KeyListener {

		public void keyTyped(KeyEvent e) {
			panel.textArea.append( "Key pressed: " + e.getKeyChar() + "\n" );
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}
	}
	
	public static class FrameListener implements WindowListener {

		public void windowOpened(WindowEvent e) {
			panel.textArea.append( "Window Opened\n" );
		}

		public void windowClosing(WindowEvent e) {
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
			panel.textArea.append( "Window iconified (minimized)\n" );
		}

		public void windowDeiconified(WindowEvent e) {
			panel.textArea.append( "Window deiconified\n" );
		}

		public void windowActivated(WindowEvent e) {
			panel.textArea.append( "Window activated\n" );
		}

		public void windowDeactivated(WindowEvent e) {
			panel.textArea.append( "Window deactivated\n" );
		}
		
	}
}
