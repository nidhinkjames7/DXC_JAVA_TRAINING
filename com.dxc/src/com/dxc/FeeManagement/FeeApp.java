package com.dxc.FeeManagement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class FeeApp
{
	static Connection conn;

	public static Connection getConnectionInstance() throws Exception
	{
		if(conn == null)
			return conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1","nidhin","Myfriends@123");
		else
			return conn;
	}
	public static void main(String[] args)
	{
//		databaseConnection ConnectionObj= new databaseConnection();
		Scanner sc= new Scanner(System.in);
		Accountant mAccountant= new Accountant();
		Admin mAdmin = new Admin();
		boolean feemngt=true;
		FeeApp mFeeApp= new FeeApp();
		
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1","nidhin","Myfriends@123");
		
		Statement stmt=(Statement) con.createStatement(); 
		*/
		try
		{
		
			do 
			{
				System.out.println("*****WELCOME TO FEE MANAGEMENT SYSTEM*****");
				System.out.println("Select Your User Type");
				
				System.out.println("1.Admin \n2.Accountant");
				String UserTypeChoice= sc.nextLine();
				int adminChoice; 
				boolean transaction=true;
				String continueChoice;
				int accountantChoice;
				if(Integer.parseInt(UserTypeChoice)==1)
				{
					System.out.println("Enter Username");
					String username=sc.nextLine();
					System.out.println("Enter Password");
					String password=sc.nextLine();
					if((username.equals("admin"))&&(password.equals("admin123")))
					{
						do
						{
							System.out.println("*****Admin Procces*****");
							System.out.println();
							System.out.println("1.Add Accountant");
							System.out.println("2.View Accountant Details");
							System.out.println("3.Update Accountant");
							System.out.println("Enter Your Choice");
							adminChoice=sc.nextInt();
							switch(adminChoice)
							{
								case 1: mAdmin.addAccountant(getConnectionInstance());
										break;
								case 2: mAdmin.viewAccountant(getConnectionInstance());
										break;
								default: System.out.println("Invalid Choice");
							}
							System.out.println("Do you Want to Continue\nYes\nNo");
							continueChoice = sc.nextLine();
							if(continueChoice.equalsIgnoreCase("No"))
								transaction = false;
						}while(transaction);
					}
					else 
					{
						System.out.println("Invalid Username or Password");
					}
				}
				else if(Integer.parseInt(UserTypeChoice)==2)
				{
					do
					{
						System.out.println("*****Accountant Process******");
						System.out.println();
						System.out.println("1. Add Student");
						System.out.println("2. View Student Deatils");
						System.out.println("3. Accounts");
						System.out.println("Enter Your Choice");
						accountantChoice=sc.nextInt();
						switch(accountantChoice)
						{
							case 1: mAccountant.addStudent(getConnectionInstance());
									break;
							case 2: mAccountant.viewStudent(getConnectionInstance());
									break;
							case 3:mAccountant.account(getConnectionInstance());
									break;
							default: System.out.println("Invalid Choice");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = sc.nextLine();
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
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		finally
		{
			sc.close();
		}
	}
}
