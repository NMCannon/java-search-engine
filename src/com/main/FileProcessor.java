package com.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileProcessor 
{
	private File file1;
	private Scanner scanner1;
	private int string_count;
	
	public void fileConnect(String filename)
	{
		// Try connect to the passed file
		try
		{
			file1 = new File(filename);
		}

		catch(Exception ex)
		{
			System.out.println("exception "+ex.getMessage()+" caught");
		}
	}
	
	public int fileCheck(String search_string)
	{
		// Make scanner for the file
		try
		{
			scanner1 = new Scanner(file1);
			scanner1.useDelimiter(" ");
			string_count=0;
			
			// While the file has another line put the lines in a string
			while (scanner1.hasNextLine())
			{
				String token = scanner1.nextLine();
				
				// Check if the line in the file contains the user's entered string ignoring case
				if(token.toLowerCase().contains((search_string.toLowerCase())))
				{
					// Count how many times the string appears
					string_count++;
				}
			}
			
		}
		
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "run time error " + e.getMessage());
			System.out.println("\n\nrun time error " + e.getMessage());
		}
		
		// Close scanner and return the string count
		scanner1.close();
		return string_count;
	}
}
