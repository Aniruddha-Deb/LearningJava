package com.sensei.swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class Swing02 extends JFrame{

	private static final long serialVersionUID = 1L;
	JButton button;
	JTextField textField;
	JTextArea textArea = new JTextArea( 15, 20 );
	int numClicks;

	public static void main(String[] args) {
		new Swing02();
	}
	
	public Swing02() {
		initializeJFrame( "Swing02 Frame", 400, 400, initializeJPanel() );
		
		ButtonListener buttonListener = new ButtonListener();
		KeyPressListener keyListener = new KeyPressListener();
		button.addActionListener( buttonListener );
		textField.addKeyListener( keyListener );
	}
	
	public void initializeJFrame( String title, int width, int height, JPanel panel ) {
		this.setSize( width, height );
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		
		int xPos = (dimension.width/2) - (this.getWidth()/2);
		int yPos = (dimension.height/2) - (this.getHeight()/2);
		
		this.add( panel );
		this.setLocation(xPos, yPos);
		this.setTitle( title );
		this.setVisible( true );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		WindowActionListener window = new WindowActionListener();
		this.addWindowListener( window );
	}
	
	public JPanel initializeJPanel( ) {
		JPanel panel = new JPanel();
		button = new JButton( "testing" );
		textField = new JTextField( "", 15 ); 
		
		panel.add( button );
		panel.add( textField );
		panel.add( textArea );
		return panel;
	}
	
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if( e.getSource() == button ) {
				numClicks++;
				textArea.append( "Button Clicked " + numClicks + " times\n" );
			}
		}
	}
	
	private class KeyPressListener implements KeyListener {

		public void keyTyped(KeyEvent e) {
			textArea.append( "Key Hit: " + e.getKeyChar() + "\n" );
		}

		public void keyPressed(KeyEvent e) {
			
		}

		public void keyReleased(KeyEvent e) {
			
		}
	}
	
	private class WindowActionListener implements WindowListener {

		public void windowOpened(WindowEvent e) {
			textArea.append( "Window opened\n" );
			
		}

		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void windowIconified(WindowEvent e) {
			textArea.append( "Window minimized\n" );
			
		}

		public void windowDeiconified(WindowEvent e) {
			textArea.append( "Window maximized\n" );
			
		}

		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
