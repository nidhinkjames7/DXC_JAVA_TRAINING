package com.dxc.bankingApp;

import java.util.Scanner;

public class ICICI implements RBI
{
	float balance=0; 
	String name;
	String address;
	String email;
	long phone;
	double total_fd=0;
	Scanner sc = new Scanner(System.in);
	public void openAccount()
	{
		System.out.println("*********Welcome to ICICI Bank*********");
		System.out.println("*********Accouunt Opening Form*********");
		System.out.println("Enter Your Name");
		name= sc.nextLine();
		System.out.println("Enter Your Address");
		address = sc.nextLine();
		System.out.println("Enter Your E-mail");
		email= sc.nextLine();
		System.out.println("Enter Your Phone Number");
		phone= sc.nextLong();	
		balance=MIN_BAL;
	}
	
	public void deposit()
	{
		System.out.println("Welcome to Deposit");
		System.out.println();
		System.out.println("Enter Amount to be deposited");
		float deposit_amt=sc.nextFloat();
		balance=deposit_amt + balance;
		System.out.println("Total Balance Available= "+balance);
	}
	public void withdrawl()
	{
		System.out.println("Welcome to Withdrawl");
		System.out.println();
		if(balance<MIN_BAL)
		{
			System.out.println("Insuffient Amount");
		}
		System.out.println("Enter Amount to be Withdrawed");
		float with_amt= sc.nextFloat();
		if((balance>with_amt))
		{
			balance= balance-with_amt;
		}
		System.out.println("Your Available Balance= "+balance);
	}
	public void openFD()
	{
		float fd_amt=0; 
		System.out.println("Welcome to FD Section");
		System.out.println();
		System.out.println("Enter the amount to be deposited");
		fd_amt= sc.nextFloat();
		System.out.println("Enter the Years to be fixed");
		int NOY=sc.nextInt();
		if(fd_amt>FD_AMT)
		{
			total_fd=fd_amt+(fd_amt*0.05*NOY);
		}
	}
	public void displayAccDetails()
	{
		System.out.println("ICICI Account");
		System.out.println("Name: "+name);
		System.out.println("Address: "+address);
		System.out.println("Email: "+email);
		System.out.println("Phone Number: "+phone);
		System.out.println("Your Available Balance= "+balance);
		System.out.println("Your FD Balance= "+total_fd);
		
	}
}
