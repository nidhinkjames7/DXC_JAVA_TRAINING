package com.dxc.bankingApp;

import java.util.Scanner;

public class bankingApp {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		ICICI oicici= new ICICI();
		HDFC ohdfc= new HDFC();
		AXIS oaxis= new AXIS();
		
		Scanner sc= new Scanner(System.in);
		bankingInfo b = new bankingInfo();
		System.out.println("******Banks********");
		System.out.println();
		System.out.println("1.ICICI");
		System.out.println("2.HDFC");
		System.out.println("3.AXIS");
		System.out.println("Enter Your Choice");
		int choice =sc.nextInt();
		int c;
		if(choice==1)
		{
//			b.getBankingInfo(new ICICI());
			while(true)
			{
				System.out.println("**************Different Process************");
				System.out.println();
				System.out.println("1.Account Creation");
				System.out.println("2.Deposit Money");
				System.out.println("3.Withdraw Money");
				System.out.println("4.Create FD account");
				System.out.println("5. View Your Account Detaills");
				System.out.println("Enter Your Choice");
				c= sc.nextInt();
				switch(c)
				{
				case 1: oicici.openAccount();
					break;
				case 2: oicici.deposit();
					break;
				case 3: oicici.withdrawl();
					break;
				case 4: oicici.openFD();
					break;
				case 5: oicici.displayAccDetails();
					break;
				default: System.exit(0);
				}
			}
		}
		else if(choice==2)
		{
//			b.getBankingInfo(new HDFC());
			
			while(true)
			{
				System.out.println("************Different Process**************");
				System.out.println();
				System.out.println("1.Account Creation");
				System.out.println("2.Deposit Money");
				System.out.println("3.Withdraw Money");
				System.out.println("4.Create FD account");
				System.out.println("5. View Your Account Detaills");
				System.out.println("Enter Your Choice");
				c= sc.nextInt();
				switch(c)
				{
				case 1: ohdfc.openAccount();
					break;
				case 2: ohdfc.deposit();
					break;
				case 3: ohdfc.withdrawl();
					break;
				case 4: ohdfc.openFD();
					break;
				case 5: ohdfc.displayAccDetails();
					break;
				default: System.exit(0);
				}
			}
			
		}
		else if(choice==3)
		{
//			b.getBankingInfo(new AXIS());
			
			while(true)
			{
				System.out.println("***********Different Process**************");
				System.out.println();
				System.out.println("1.Account Creation");
				System.out.println("2.Deposit Money");
				System.out.println("3.Withdraw Money");
				System.out.println("4.Create FD account");
				System.out.println("5. View Your Account Detaills");
				System.out.println("Enter Your Choice");
				c= sc.nextInt();
				switch(c)
				{
				case 1: oaxis.openAccount();
					break;
				case 2: oaxis.deposit();
					break;
				case 3: oaxis.withdrawl();
					break;
				case 4: oaxis.openFD();
					break;
				case 5: oaxis.displayAccDetails();
					break;
				default: System.exit(0);
				}
			}
			
		}
		else
		{
			System.out.println("Invalid Choice");
		}
	}

}
