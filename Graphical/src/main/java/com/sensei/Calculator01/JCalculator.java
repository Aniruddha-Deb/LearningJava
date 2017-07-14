package com.sensei.Calculator01;

import static com.sensei.Calculator01.Logger.log;

import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JCalculator extends JFrame {
	
	private CalculatorPanel  inputPanel  = null ;
	
	public JCalculator() {
		super.setTitle( "Calculator" );
		setUpUI() ;
	}
	
	private void setUpUI() {
		
		log( "Creating panels." );
		inputPanel  = new CalculatorPanel() ;
		
		log( "Adding panels." ) ;
		Container container = super.getContentPane() ;
		container.add( inputPanel ) ;
		
		log( "Setting frame attributes." ) ;
		super.setSize( 500, 100 ) ;
		super.setLocationRelativeTo( null ) ;
		super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public static void main(String[] args) {
		log( "Starting JCalculator" );
		JCalculator calc = new JCalculator() ;
		calc.setVisible( true );
		log( "JCalculator is now active." ) ;
	}
}
