package com.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{
	private JTextField textfield1;
	private JLabel label1;
	private JButton button1;
	private JPanel panel1;
	private JFrame screen;
	
	  // Constructor

	  public GUI (String title)
	  {
		  // set the title
		   super(title);
		   
		   JFrame screen = new JFrame("SearchEngine");
		   
		   	// Set screen layout
		   screen.setLayout(new BorderLayout());
		   
		   JPanel panel1 = new JPanel();
		   
		   textfield1 = new JTextField("Search...");
		   textfield1.setToolTipText("Enter word/phrase");
		   textfield1.addActionListener(this);
		   
		   button1 = new JButton("Search");
		   button1.addActionListener(this);
		   
		   panel1.add(textfield1);
		   panel1.add(button1);
		   
		   screen.add(panel1);
			
		   // set the location of the screen  
		   screen.setLocation(100,100);
			
		   // Define the size of the frame  
		   screen.setSize(600,600);
			   
		   // Make the screen appear
		   screen.setVisible(true);
	  }

	  @Override
	  public void actionPerformed(ActionEvent arg0) 
	  {
		  // TODO Auto-generated method stub
		
	  }
	  
	  
}
