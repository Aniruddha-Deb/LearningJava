package com.sensei.UIconcepts;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Toolkit;

public abstract class AbstractMainFrame extends JFrame{
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	MenuBar menuBar = new MenuBar();
	ValuePanel   valuePanel   = new ValuePanel();
	ConsolePanel consolePanel = new ConsolePanel();
	GraphPanel   graphPanel   = new GraphPanel();
	
	protected void init() {

		super.setLayout( new BorderLayout() );
		
		super.setSize( tk.getScreenSize() );
		super.setResizable( true );
		super.setVisible( true );
		super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		super.add( menuBar, BorderLayout.NORTH );
		super.add( valuePanel , BorderLayout.WEST );
		super.add( consolePanel , BorderLayout.SOUTH );
		super.add( graphPanel , BorderLayout.CENTER );
	}
}
