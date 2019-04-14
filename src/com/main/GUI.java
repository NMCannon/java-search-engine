package com.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class GUI extends JFrame implements ActionListener
{
	private JTextField textfield1;
	private JTextField textfield2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JTextArea textarea1;
	private JTextArea textarea2;
	private JPanel panel1;
	private JFrame screen;
	private String search_string;
	private String file;
	private int count;
	private FileProcessor file_processor = new FileProcessor();
	
	private String filename;
	private Rank rank = new Rank();
	
	
	private ArrayList<UserFile> file_list = new ArrayList();
	
	  
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
		   textfield1.setColumns(30);
		   textfield1.addActionListener(this);
		   
		   textfield2 = new JTextField("File name...");
		   textfield2.setToolTipText("Enter file name");
		   textfield2.setColumns(30);
		   textfield2.addActionListener(this);
		   
		   // Make buttons
		   button1 = new JButton("Search");
		   button1.addActionListener(this);
		   
		   button2 = new JButton("Show file list");
		   button2.addActionListener(this);
		   
		   button3 = new JButton("Add file to file list");
		   button3.addActionListener(this);
		   
		   button4 = new JButton("Remove file from file list");
		   button4.addActionListener(this);
		   
		   button5 = new JButton("Clear file list");
		   button5.addActionListener(this);
		   
		   textarea1 = new JTextArea();
		   textarea1.setEditable(false);
		   textarea1.setVisible(false);
		   
		   textarea2 = new JTextArea();
		   textarea2.setEditable(false);
		   textarea2.setVisible(false);
		   
		   // Add textfields and buttons to the panel
		   panel1.add(textfield1);
		   panel1.add(button1);
		   panel1.add(textfield2);
		   panel1.add(button2);
		   panel1.add(button3);
		   panel1.add(button4);
		   panel1.add(button5);
		   panel1.add(textarea1);
		   panel1.add(textarea2);
		   
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
		  // If the user clicks the "Search" button
		  if (event.getSource()==button1)
		  {
			  textarea2.setText(null);
			  
			  if(file_list.isEmpty())
			  {
				  JOptionPane.showMessageDialog(this, "Please add the files you would like to search through, to the file list");
			  }
			  for (UserFile file: file_list)
			  {
				  int count;
				  file_processor.fileConnect(file.getFilename());
				  count=file_processor.fileCheck(textfield1.getText());
				  file.setCount(count);
			  }
			  rank.sortResults(file_list, textarea2);
		  }
		  
		  // If the user clicks the "Add file" button
		  if (event.getSource()==button3)
		  {
			  filename=textfield2.getText();
			  if(!filename.contains(".txt"))
			  {
				  JOptionPane.showMessageDialog(this, "Error: Please enter a .txt file \n");
			  }
			  else
			  {
				  addFile(filename, 0);
			  }
		  }
		  
		  // If the user clicks the "Show file list" button
		  if (event.getSource()==button2)
		  {
			  textarea1.setText(null);
			  for (UserFile file: file_list)	
			  {
				  textarea1.append(file.toString());
			  }
			  textarea1.setVisible(true);
		  }
		  
		  // If the user clicks the "Remove file from file list" button
		  if (event.getSource()==button4)
		  {
			  Iterator<UserFile> iterator = file_list.iterator();
			  while(iterator.hasNext())
			  {
				  UserFile i=iterator.next();
				  if(textfield2.getText().equals(i.getFilename()))
				  {
					  iterator.remove();
					  JOptionPane.showMessageDialog(this, i.getFilename()+" removed");
				  }
			  }
		  }
		  
		  if (event.getSource()==button5)
		  {
			  file_list.removeAll(file_list);
			  textarea1.setText(null);
			  JOptionPane.showMessageDialog(this, "File list cleared");
		  }
	  }
	  
	  // Creates a UserFile object with the user's entered file name
	  public void addFile(String filename, int count)
	  {
		 UserFile userfile_1 = new UserFile(filename, count);
		 file_list.add(userfile_1);
		 JOptionPane.showMessageDialog(this, "Added: \n"+userfile_1);
	  }

	  // Method just to add a file to the list from the control class
	  public void addFilelist(UserFile file_name) 
	  {
		  file_list.add(file_name);
	  }
	  
}
