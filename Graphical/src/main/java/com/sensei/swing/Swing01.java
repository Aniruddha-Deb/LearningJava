package com.sensei.swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class Swing01 extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Swing01();
	}
	
	public Swing01() {
		
		this.setSize( 400, 400 );
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);

		this.setResizable(true);
		this.setLocation(xPos, yPos);
		this.setTitle( "Hello world!" );
		
		JPanel panel = new JPanel(); 
		JButton button = new JButton( "Hello" );
		JLabel label = new JLabel( "Hello Again, World!" );
		JTextField textField = new JTextField( "Type here", 15 );
		JTextArea area = new JTextArea( 15, 20 );
		JScrollPane pane = new JScrollPane(area,
							JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
							JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		area.setText( "Just a bunch of random stuff" ); 
		label.setToolTipText( "test" );
		button.setBorderPainted( true );
		button.setContentAreaFilled( true );
		
		panel.add( label );
		panel.add( button );
		panel.add( textField );
		panel.add(pane);
		panel.add( area );
		this.add( panel );
		
		this.setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}
