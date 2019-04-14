package com.main;

public class UserFile 
{
	private String filename;
	private int count;
	
	public UserFile(String filename, int count)
	{
		this.filename=filename;
		this.count=count;
	}
	
	public String toString()
	{
		String content = "File name: "+this.filename+"\n\n";
		return content;
	}

	public String getFilename() 
	{
		return filename;
	}

	public void setFilename(String filename) 
	{
		this.filename = filename;
	}

	public int getCount() 
	{
		return count;
	}

	public void setCount(int count) 
	{
		this.count = count;
	}
}
