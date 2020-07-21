package com.dxc.aop.bank;

import java.io.BufferedReader;

public class Actions 
{
	public int MIN_BAL = 1000;
	public int BAL = MIN_BAL;
	
	public void openAccount(BufferedReader buff, Customer customer)
	{
		try
		{
			System.out.println("Enter Customer Name");
			String name=buff.readLine();
			System.out.println("Enter Customer Email");
			String email=buff.readLine();
			System.out.println("Enter Customer Phone Number");
			String phone=buff.readLine();
			System.out.println("Enter Customer Age");
			String age=buff.readLine();
			
			customer.setName(name);
			customer.setEmail(email);
			customer.setPhone(phone);
			customer.setAge(age);
			
			System.out.println("Congratulations your Account is Opened !!");
			System.out.println("your Details are \nName: "+name+"\nEmail: "+email+"\nPhone: "+phone+"\nAge: "+age);
		
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e);
		}
	}
	
	public void deposit(BufferedReader buff, Customer customer) 
	{
		try 
		{
			System.out.println("Enter the amount to be deposited");
			String amount = buff.readLine();
			BAL = BAL + Integer.parseInt(amount);
			customer.setBalance(String.valueOf(BAL));
			System.out.println("Balance is "+BAL);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
	}
	
	public void withdrawl(BufferedReader buff, Customer customer)
	{
		try {
			System.out.println("Enter the amount to be Withdrawl");
			String amount = buff.readLine();
			if(BAL - Integer.parseInt(amount) > MIN_BAL)
				BAL = BAL - Integer.parseInt(amount);
			else
				System.out.println("MIN BAL is not maintained after withdrawl !!");
			customer.setBalance(String.valueOf(BAL));
			System.out.println("Balance is "+BAL);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
	}

	public void checkBalance()
	{
		try 
		{
			System.out.println("Enter the balance amount= "+BAL);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
	}
	
}
