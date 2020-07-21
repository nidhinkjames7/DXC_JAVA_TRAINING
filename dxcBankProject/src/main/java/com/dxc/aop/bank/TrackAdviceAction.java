package com.dxc.aop.bank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackAdviceAction 
{
	
	@Pointcut("execution(* Actions.*(..))")
	public void getAge(){} // pointcut name
	
	@Before("getAge()") // applying pointcut before advice
	@After("getAge()") // applying pointcut before advice
	public void myadvice(JoinPoint jp) 
	{
		System.out.println("Concern Added");
		System.out.println("Method signature is "+jp.getSignature());
	}
	
}
