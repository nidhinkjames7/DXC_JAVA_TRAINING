package com.dxc.fees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class FeeApp
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc= new Scanner(System.in);
		Accountant mAccountant= new Accountant();
		Admin mAdmin = new Admin();
		boolean feemngt=true;

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1","nidhin","Myfriends@123");

		Statement stmt=(Statement) con.createStatement();

		do 
		{
			System.out.println("*****WELCOME TO FEE MANAGEMENT SYSTEM*****");
			System.out.println("Select Your User Type");

			System.out.println("1.Admin \n2.Accountant");
			int UserTypeChoice= sc.nextInt();
			int adminChoice; 
			boolean transaction=true;
			String continueChoice;
			int accountantChoice;
			if(UserTypeChoice==1)
			{
				System.out.println("Enter Username");
				String username=sc.next();
				System.out.println("Enter Password");
				String password=sc.next();
				if((username.equals("admin"))&&(password.equals("admin123")))
				{
					do
					{
						System.out.println("*****Admin Procces*****");
						System.out.println();
						System.out.println("1.Add Accountant");
						System.out.println("2.View Accountant Details");
						System.out.println("Enter Your Choice");
						adminChoice=sc.nextInt();
						switch(adminChoice)
						{
							case 1: mAdmin.addAccountant();
									break;
							case 2: mAdmin.viewAccountant();
									break;
							default: System.out.println("Invalid Choice");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = sc.next();
						if(continueChoice.equalsIgnoreCase("No"))
							transaction = false;
					}while(transaction);
				}
				else
				{
					System.out.println("Invalid Username and Password");
				}
			}
			else if(UserTypeChoice==2)
			{
				do
				{
					System.out.println("*****Accountant Process******");
					System.out.println();
					System.out.println("1. Add Student");
					System.out.println("2. View Student Deatils");
					System.out.println("Enter Your Choice");
					accountantChoice=sc.nextInt();
					switch(accountantChoice)
					{
						case 1: mAccountant.addStudent();
								break;
						case 2: mAccountant.viewStudent();
								break;
						default: System.out.println("Invalid Choice");
					}
					System.out.println("Do you Want to Continue\nYes\nNo");
					continueChoice = sc.next();
					if(continueChoice.equalsIgnoreCase("No"))
						transaction = false;
				}while(transaction);	
			}
			else
			{
				feemngt=false;
			}
		}while(feemngt);
	}
}