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
	private JTextField textfield2;
	private JButton button1;
	private JButton button2;
	private JPanel panel1;
	private JFrame screen;
	private String search_string;
	private String file;
	private int count;
	private FileProcessor file_processor = new FileProcessor();
	private Rank rank = new Rank();
	
	  // Constructor

	  public GUI (String title)
	  {
		  // set the title
		   super(title);
		   
		   JFrame screen = new JFrame("SearchEngine");
		   
		   	// Set screen layout
		   screen.setLayout(new BorderLayout());
		   
		   JPanel panel1 = new JPanel();
		   
		   // Make textfields
		   textfield1 = new JTextField("String...");
		   textfield1.setToolTipText("Enter word/phrase");
		   textfield1.setColumns(25);
		   textfield1.addActionListener(this);
		   
		   textfield2 = new JTextField("File name...");
		   textfield2.setToolTipText("Enter file name");
		   textfield2.setColumns(25);
		   textfield2.addActionListener(this);
		   
		   // Make buttons
		   button1 = new JButton("Search all files");
		   button1.addActionListener(this);
		   
		   button2 = new JButton("Search specific file");
		   button2.addActionListener(this);
		   
		   // Add textfields and buttons to the panel
		   panel1.add(textfield1);
		   panel1.add(button1);
		   panel1.add(textfield2);
		   panel1.add(button2);
		   
		   // Add panel to the screen frame
		   screen.add(panel1);
			
		   // set the location of the screen  
		   screen.setLocation(100,100);
			
		   // Define the size of the frame  
		   screen.setSize(600,600);
			   
		   // Make the screen appear
		   screen.setVisible(true);
	  }

	  public void actionPerformed(ActionEvent event) 
	  {
		  // If the user clicks the "Search all files button"
		  if (event.getSource()==button1)
		  {
			  search_string=textfield1.getText();
			  
			  file_processor.fileConnect("test.txt");
			  count=file_processor.fileCheck(search_string);
			  rank.resultRank(count, "file_1.txt");
			  
			  file_processor.fileConnect("file_2.txt");
			  count=file_processor.fileCheck(search_string);
			  rank.resultRank(count, "file_2.txt");
			  
			  file_processor.fileConnect("file_3.txt");
			  count=file_processor.fileCheck(search_string);
			  rank.resultRank(count, "file_3.txt");
			  
			  rank.displayRank();
		  }
		  
		  // If the user clicks the "Search specific file button"
		  if (event.getSource()==button2)
		  {
			  System.out.print("HIII");
			  search_string=textfield1.getText();
			  file=textfield2.getText();
			  
			  file_processor.fileConnect(file);
			  count=file_processor.fileCheck(search_string);
			  rank.displayrankSpecific(count, file);
		  }
	  }
		
	  
	  
}
