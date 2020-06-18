package com.dxc.bankingApp;

public class bankingInfo 
{
	public void getBankingInfo(RBI banks)
	{
		banks.openAccount();
		banks.deposit();
		banks.withdrawl();
		banks.openFD();
	}
}
