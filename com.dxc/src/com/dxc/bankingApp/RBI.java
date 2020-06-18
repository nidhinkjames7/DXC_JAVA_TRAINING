package com.dxc.bankingApp;

public interface RBI 
{
	int MIN_BAL=1000;
	int FD_AMT=500;
	float RIO=5;
	
	public void openAccount();
	public void deposit();
	public void withdrawl();
	public void openFD();
	public void displayAccDetails();
}
