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
		if(count>best_count)
		{
			best_count=count;
			best_file=file;
		}
		else if(count>worst_count)
		{
			mid_count=count;
			best_file=file;
		}
		else
		{
			worst_count=count;
			worst_file=file;
		}
	}
	
	public void displayRank()
	{
		JOptionPane.showMessageDialog(null, "File:"+best_file+"\nString occurences: "+best_count
				+"\n\nFile: "+mid_file+"\nString occurences: "+mid_count
				+"\n\nFile: "+worst_file+"\nString occurences: "+worst_count);
	}
	
	public void displayrankSpecific(int count, String file)
	{
		JOptionPane.showMessageDialog(null, "File: "+file+"\nString occurences: "+count);
	}
}
