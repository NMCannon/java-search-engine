package com.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessor 
{
	private File file1;
	private Scanner scanner1;
	private int string_count;
	
	public void fileConnect(String filename)
	{
		try
		{
			file1 = new File(filename);
		}

		catch(Exception ex)
		{
			System.out.println("exception "+ex.getMessage()+" caught");
		}
	}
	
	public boolean fileCheck(String search_string)
	{
		try
		{
			scanner1 = new Scanner(file1);
			scanner1.useDelimiter(" ");
			while (scanner1.hasNextLine())
			{
				String token = scanner1.nextLine();
				if(token.toLowerCase().contains((search_string.toLowerCase())))
				{
					string_count++;
				}
			}
			System.out.println(string_count);
			
			if(string_count>0)
			{
				scanner1.close();
				return true;
			}
			else
			{
				scanner1.close();
				return false;
			}
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}
		return false;
	}
}
