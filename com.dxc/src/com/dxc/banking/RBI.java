package com.dxc.banking;

import java.io.BufferedReader;

public interface RBI 
{
	public void openAccount(BufferedReader buff);
	public void deposit(BufferedReader buff);
	public void withdrawl(BufferedReader buff);
	public void openFD(BufferedReader buff);
}
