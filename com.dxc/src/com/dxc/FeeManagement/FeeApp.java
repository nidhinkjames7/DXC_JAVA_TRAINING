package com.dxc.FeeManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

//import feeSystem.Fees;

class UserClass<T> 
{
	T obj;

	void create(T obj) 
	{ 
		this.obj = obj;
	}

	T getInstance() 
	{ 
		return obj;
	}
}

public class FeeApp
{
	Admin mAdmin=null;
	Accountant mAccountant=null;
	InputStreamReader isr=null;
	BufferedReader buff=null;
	Connection mConnectionObject=null;

	public  Connection getConnectionInstance() throws Exception
	{
		if(mConnectionObject == null)
			return mConnectionObject = DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1","nidhin","Myfriends@123");
		else
			return mConnectionObject;
	}
	public static void main(String[] args) throws IOException
	{
		FeeApp mFeesObject=new FeeApp();
		mFeesObject.isr=new InputStreamReader(System.in);
		mFeesObject.buff=new BufferedReader(mFeesObject.isr);

		
		
		try
		{
			boolean feemngt=true;
		
			do 
			{
				System.out.println("*****WELCOME TO FEE MANAGEMENT SYSTEM*****");
				System.out.println("Select Your User Type");
				
				System.out.println("1.Admin \n2.Accountant");
				String UserTypeChoice=mFeesObject.buff.readLine();
				String adminChoice; 
				boolean transaction=true;
				String continueChoice;
				String accountantChoice;
				if(Integer.parseInt(UserTypeChoice)==1)
				{
					System.out.println("Enter Username");
					String username=mFeesObject.buff.readLine();
					System.out.println("Enter Password");
					String password=mFeesObject.buff.readLine();
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
							adminChoice=mFeesObject.buff.readLine();
							switch(Integer.parseInt(adminChoice))
							{
								case 1: mFeesObject.mAdmin.addAccountant(mFeesObject.buff,mFeesObject.getConnectionInstance());
										break;
								case 2: mFeesObject.mAdmin.viewAccountant(mFeesObject.buff,mFeesObject.getConnectionInstance());
										break;
								default: System.out.println("Invalid Choice");
							}
							System.out.println("Do you Want to Continue\nYes\nNo");
							continueChoice = mFeesObject.buff.readLine();
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
						accountantChoice=mFeesObject.buff.readLine();
						switch(Integer.parseInt(accountantChoice))
						{
							case 1: mFeesObject.mAccountant.addStudent(mFeesObject.buff,mFeesObject.getConnectionInstance());
									break;
							case 2: mFeesObject.mAccountant.viewStudent(mFeesObject.buff,mFeesObject.getConnectionInstance());
									break;
							case 3:mFeesObject.mAccountant.account(mFeesObject.getConnectionInstance());
									break;
							default: System.out.println("Invalid Choice");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice =mFeesObject.buff.readLine();
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
			mFeesObject.buff.close();
		}
	}
}
