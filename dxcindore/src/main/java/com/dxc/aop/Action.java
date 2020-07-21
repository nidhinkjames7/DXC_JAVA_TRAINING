package com.dxc.aop;

public class Action
{
	
	public void showName()
	{
		String name="Nidhin";
		System.out.println("showName() method is used to display Name"+name);
	}
	
	public int getSalary()
	{
		System.out.println("getSalary() method is used to display salary");
		return 5000;
	}
	
	public int getAge() {
		System.out.println("getAge() method is used to display age");
		return 30;
	}
	
}
