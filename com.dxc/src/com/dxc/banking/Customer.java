package com.dxc.banking;

public class Customer 
{
	String name,email,phone,balanace;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBalanace() {
		return balanace;
	}

	public void setBalanace(String balanace) {
		this.balanace = balanace;
	}

	int operationCounter;

	public int getOperationCounter() 
	{
		return operationCounter;
	}

	public void setOperationCounter(int operationCounter)
	{
		this.operationCounter = operationCounter;
	}
	
	int openAccCounter, depositCounter, withdrawlCounter,openFDCounter;
	public int getOpenAccCounter() {
		return openAccCounter;
	}

	public void setOpenAccCounter(int openAccCounter) {
		this.openAccCounter = openAccCounter;
	}

	public int getDepositCounter() {
		return depositCounter;
	}

	public void setDepositCounter(int depositCounter) {
		this.depositCounter = depositCounter;
	}

	public int getWithdrawlCounter() {
		return withdrawlCounter;
	}

	public void setWithdrawlCounter(int withdrawlCounter) {
		this.withdrawlCounter = withdrawlCounter;
	}

	public int getOpenFDCounter() {
		return openFDCounter;
	}

	public void setOpenFDCounter(int openFDCounter) {
		this.openFDCounter = openFDCounter;
	}
	
}
