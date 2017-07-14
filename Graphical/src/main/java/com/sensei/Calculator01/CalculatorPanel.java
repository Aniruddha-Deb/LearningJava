package com.sensei.Calculator01;

import static com.sensei.Calculator01.Logger.log;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CalculatorPanel extends JPanel implements ActionListener {
	
	private JButton calcButton         = null ;
	private JTextField valueATextField = null ;
	private JTextField valueBTextField = null ;
	private JTextField resultTextField = null ;
	private JComboBox<String> opCombo  = null ;
	
	private static String[] ops = { "+", "-", "x", "/" } ;
	
	public CalculatorPanel() {
		setUpUI() ;
	}
	
	private void setUpUI() {
		createWidgets() ;
		addListenersToWidgets() ;
		layoutWidgets() ;
	}
	
	private void createWidgets() {
		calcButton      = new JButton( "=" ) ;
		valueATextField = new JTextField( 5 ) ;
		valueBTextField = new JTextField( 5 ) ;
		resultTextField = new JTextField( 10 ) ;
		opCombo         = new JComboBox<String>( ops ) ;
		
		resultTextField.setEditable(false) ;
		opCombo.setEditable( false );
	}
	
	private void addListenersToWidgets() {
		calcButton.addActionListener( this );
		opCombo.addActionListener( this );
		valueATextField.addActionListener(this);
		valueBTextField.addActionListener(this);
	}
	
	private void layoutWidgets() {
		setLayout( new FlowLayout( FlowLayout.CENTER ) );
		add( valueATextField ) ;
		add( opCombo ) ;
		add( valueBTextField ) ;
		add( calcButton ) ;
		add( resultTextField ) ;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			double firstVal  = Double.parseDouble( valueATextField.getText() );
			double secondVal = Double.parseDouble( valueBTextField.getText() );
			String op        = opCombo.getSelectedItem().toString() ;
			
			handleChangedInputs( firstVal, secondVal, op ) ;
		}
		catch( NumberFormatException ne ) {
			JOptionPane.showMessageDialog( this, "Invalid value entered in text fields" );
		}
	}
	
	public void handleChangedInputs(double firstVal, double secondVal, String op ) {
		log( "Input values have changed." ) ;
		log( "\ta=" + firstVal );
		log( "\tb=" + secondVal );
		log( "\top=" + op ) ;
		
		double result = 0.0 ;
		
		if( op.equals( "+" ) ) {
			result = firstVal + secondVal ;
		}
		else if( op.equals( "-" ) ) {
			result = firstVal - secondVal ;
		}
		else if( op.equals( "x" ) ) {
			result = firstVal * secondVal ;
		}
		else if( op.equals( "/" ) ) {
			result = firstVal / secondVal ;
		}
		
		resultTextField.setText( Double.toString(result) ) ;
	}
}
