package com.main;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Rank 
{
	private ArrayList<Integer> count_list = new ArrayList();

	public void sortResults(ArrayList<UserFile> file_list)
	{
		for (UserFile file: file_list)
		{
			count_list.add(file.getCount());
		}
		
		Collections.sort(count_list, Collections.reverseOrder());
		
		for (int i: count_list)
		{
			for (UserFile file: file_list)
			{
				if(file.getCount()==i)
				{
					JOptionPane.showMessageDialog(null, "File name: "+file+"\nString Occurences: "+i+"\n\n");
				}
			}
		}
		count_list.clear();
	}
}
