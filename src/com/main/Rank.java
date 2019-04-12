package com.main;

import javax.swing.JOptionPane;

public class Rank 
{
	private int best_count=0;
	private int worst_count=0;
	private int mid_count=0;
	private String best_file;
	private String worst_file;
	private String mid_file;
	
	public void resultRank(int count, String file)
	{
		// If the string count for the file is higher than the rest, shift everything down in rank
		if(count>=best_count)
		{
			worst_count=mid_count;
			worst_file=mid_file;
			mid_count=best_count;
			mid_file=best_file;
			best_count=count;
			best_file=file;
		}
		
		// If the string count is greater than the middle rank, shift bottom rank down
		else if(count>mid_count)
		{
			worst_count=mid_count;
			worst_file=mid_file;
			mid_count=count;
			mid_file=file;
		}
		else
		{
			worst_count=count;
			worst_file=file;
		}
	}
	
	// Display the results in order
	public void displayRank()
	{
		JOptionPane.showMessageDialog(null, "File:"+best_file+"\nString occurences: "+best_count
				+"\n\nFile: "+mid_file+"\nString occurences: "+mid_count
				+"\n\nFile: "+worst_file+"\nString occurences: "+worst_count);
		
		best_count=0;
		mid_count=0;
		worst_count=0;
	}
	
	// Display results for specific file
	public void displayrankSpecific(int count, String file)
	{
		JOptionPane.showMessageDialog(null, "File: "+file+"\nString occurences: "+count);
	}
}
