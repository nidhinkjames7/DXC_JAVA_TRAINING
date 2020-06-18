package com.dxc.banking;

public interface RBI 
{
	int MIN_BAL=1000;
	float FD_AMT=500;
	public void openAccount();
	public void deposit();
	public void withdrawl();
	public void openFD();
	public void displayAccountDetails();
}
