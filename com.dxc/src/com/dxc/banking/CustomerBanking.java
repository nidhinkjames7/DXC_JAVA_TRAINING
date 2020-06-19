package com.dxc.banking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class MyBankClass<T>  // ICICI | HDFC | AXIS
{
	T obj;
	void create(T obj)
	{
		this.obj=obj;
	}
	
	T getInstance()
	{
		return obj;
	}
}

public class CustomerBanking 
{
	InputStreamReader isr= null;
	BufferedReader buff = null;
	ICICI micici = null;
	HDFC mhdfc =null;
	AXIS maxis =null;
	
	public static void main(String [] args) throws Exception
	{
		CustomerBanking mobject = new CustomerBanking();
		mobject.isr= new InputStreamReader(System.in);
		mobject.buff=new BufferedReader(mobject.isr);
		
		System.out.println("***WELCOME TO INDIAN BANKING SYSTEM***");
		System.out.println("SELECT YOUR BANK");
		System.out.println("1.ICICI");
		System.out.println("2.HDFC");
		System.out.println("3.AXIS");
		String bankChoice = mobject.buff.readLine();
		
		String operationChoice, continueChoice;
		boolean transaction =true;
		
		switch(Integer.parseInt(bankChoice))
		{
			case 1: MyBankClass<ICICI> obj = new MyBankClass<ICICI>();
					obj.create(new ICICI());
					mobject.micici = obj.getInstance();
					do {
						System.out.println("SELECT  YOUR  Operation\n1. Open Account\n2. Deposit\n3. WithDrawl\n4. Open FD");
						operationChoice = mobject.buff.readLine();
						switch(Integer.parseInt(operationChoice)) {
						case 1: mobject.micici.openAccount(mobject.buff);
								break;
						case 2: mobject.micici.deposit(mobject.buff);
								break;
						case 3: mobject.micici.withdrawl(mobject.buff);
								break;
						case 4: mobject.micici.openFD(mobject.buff);
								break;
						default: System.out.println("No Operation Choice Selected");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = mobject.buff.readLine();
						if(continueChoice.equalsIgnoreCase("No"))
							transaction = false;
					}while(transaction);
					break;
			case 2: MyBankClass<HDFC> obj1 = new MyBankClass<HDFC>();
					obj1.create(new HDFC());
					mobject.mhdfc = obj1.getInstance();
					do {
							System.out.println("SELECT  YOUR  Operation\n1. Open Account\n2. Deposit\n3. WithDrawl\n4. Open FD");
							operationChoice = mobject.buff.readLine();
							switch(Integer.parseInt(operationChoice)) {
							case 1: mobject.mhdfc.openAccount(mobject.buff);
									break;
							case 2: mobject.mhdfc.deposit(mobject.buff);
									break;
							case 3: mobject.mhdfc.withdrawl(mobject.buff);
									break;
							case 4:  mobject.mhdfc.openFD(mobject.buff);
									break;
							default: System.out.println("No Operation Choice Selected");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = mobject.buff.readLine();
						if(continueChoice.equalsIgnoreCase("No"))
							transaction = false;
						}while(transaction);
						break;
			case 3: MyBankClass<AXIS> obj2 = new MyBankClass<AXIS>();
					obj2.create(new AXIS());
					mobject.maxis = obj2.getInstance();
					do {
						System.out.println("SELECT  YOUR  Operation\n1. Open Account\n2. Deposit\n3. WithDrawl\n4. Open FD");
						operationChoice = mobject.buff.readLine();
						switch(Integer.parseInt(operationChoice)) {
						case 1: mobject.maxis.openAccount(mobject.buff);
								break;
						case 2: mobject.maxis.deposit(mobject.buff);
								break;
						case 3: mobject.maxis.withdrawl(mobject.buff);
								break;
						case 4:  mobject.maxis.openFD(mobject.buff);
								break;
						default: System.out.println("No Operation Choice Selected");
						}
						System.out.println("Do you Want to Continue\nYes\nNo");
						continueChoice = mobject.buff.readLine();
						if(continueChoice.equalsIgnoreCase("No"))
							transaction = false;
					}while(transaction);
					break;
	
			default: System.out.println("No Choice of Bank Done");
		}
		
	}
}
