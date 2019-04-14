/*****************************************
 * Purpose: Controls project
 * Author: Noel Cannon
 * Date: 14/03/19
 ****************************************/

package com.main;

public class Control 
{

	public static void main(String[] args) 
	{
		GUI gui1 = new GUI("Search Engine");
		
		UserFile userfile1 = new UserFile("file_1.txt", 0);
		UserFile userfile2 = new UserFile("file_2.txt", 0);
		UserFile userfile3 = new UserFile("file_3.txt", 0);
		
		gui1.addFilelist(userfile1);
		gui1.addFilelist(userfile2);
		gui1.addFilelist(userfile3);
	}

}
