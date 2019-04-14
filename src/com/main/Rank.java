package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Rank 
{
	private ArrayList<Integer> count_list = new ArrayList();
	private ArrayList<UserFile> file_list_2 = new ArrayList();

	public void sortResults(ArrayList<UserFile> file_list, JTextArea textarea2)
	{
		removeFiles(file_list);
		
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
					textarea2.append("File name: "+file+"String Occurences: "+i+"\n\n");
					textarea2.setVisible(true);
				}
			}
		}
		
		for (UserFile file:file_list_2)
		{
			file_list.add(file);
			textarea2.append("File name: "+file+"String Occurences: "+file.getCount()+"\n\n");
			textarea2.setVisible(true);
		}
		
		file_list_2.clear();
		count_list.clear();
	}
	
	
	public void removeFiles(ArrayList<UserFile> file_list)
	{
		Iterator<UserFile> iterator = file_list.iterator();
		while(iterator.hasNext())
		{
			UserFile i=iterator.next();
			if(i.getCount()==0)
			{
				file_list_2.add(i);
				iterator.remove();
			}
		}
	}
}
