package com.dxc.bankapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dxc.bankapp.entity.Customer;


@SpringBootApplication
@SuppressWarnings("resource")
public class SpringbootBankAppApplication 
{
	BufferedReader buff=null;
	InputStreamReader isr=null;
	public static void main(String[] args) throws IOException 
	{
		SpringApplication.run(SpringbootBankAppApplication.class, args);
		SpringbootBankAppApplication mObject=new SpringbootBankAppApplication();
		CustomerInfo mCustomerInfo=new CustomerInfo();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Actions actions = (Actions) context.getBean("actionBean");
		mObject.isr=new InputStreamReader(System.in);
		mObject.buff=new BufferedReader(mObject.isr);
		boolean choice=true;
		
		do
		{
			System.out.println("Enter Your Choice");
			System.out.println("1.Create Account");
			System.out.println("2.Deposit");
			System.out.println("3.Withdrw ");
			System.out.println("4.Check Balance ");
			String bankChoice=mObject.buff.readLine();
			switch(Integer.parseInt(bankChoice))
			{
				case 1:actions.openAccount(mObject.buff,mCustomerInfo);
						break;
				case 2:actions.deposit(mObject.buff, mCustomerInfo);
						break;
				case 3: actions.withdrawl(mObject.buff, mCustomerInfo);
						break;
				case 4: actions.checkBalance();
						break;
				default: System.out.println("Invalid Choice");
			}
			System.out.println("Do you Want to Continue\nYes\nNo");
			String continueChoice = mObject.buff.readLine();
			if (continueChoice.equalsIgnoreCase("No"))
				choice = false;
		}while(choice);
	}

}
