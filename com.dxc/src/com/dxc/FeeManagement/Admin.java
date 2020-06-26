package com.dxc.FeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Admin 
{
	Scanner sc= new Scanner(System.in);
	
	String acc_id;
	String acc_name,acc_address,acc_email,acc_phone,acc_username,acc_password;
	
	public void addAccountant()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1","nidhin","Myfriends@123");
			
			Statement stmt=(Statement) con.createStatement();
			String insert_query= "INSERT INTO accountant VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(insert_query);
			
			System.out.println("Enter Acountant Id");
			acc_id=sc.nextLine();
			System.out.println("Enter Accountant Name");
			acc_name=sc.nextLine();
			System.out.println("Enter Accountant Address");
			acc_address=sc.nextLine();
			System.out.println("Enter Email");
			acc_email=sc.nextLine();
			System.out.println("Enter Phone Number");
			acc_phone=sc.nextLine();
			System.out.println("Enter Username");
			acc_username=sc.nextLine();
			System.out.println("Enter Password");
			acc_password=sc.nextLine();
			
			pstmt.setString(1, acc_id);
			pstmt.setString(2, acc_name);
			pstmt.setString(3, acc_address);
			pstmt.setString(4, acc_email);
			pstmt.setString(5, acc_phone);
			pstmt.setString(6, acc_username);
			pstmt.setString(7, acc_password);
			
			pstmt.executeUpdate();
			
			System.out.println("Successfully Inserted");
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		
		
	}
	public void viewAccountant()
	{
		/*System.out.println("Accountant Name: "+acc_name);
		System.out.println("Accountant Address: "+acc_address);
		System.out.println("Accountant Email: "+acc_email);
		System.out.println("Accountant Phone Number: "+acc_phone);
		System.out.println("Accountant Username: "+acc_username);*/
		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1","nidhin","Myfriends@123");
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs= stmt.executeQuery("select * from accountant");
			while(rs.next())
			{
				System.out.println("Accountant ID: "+rs.getString(1)+"\nAccountant Name: "+rs.getString(2)+"\nAccountant Address: "+rs.getString(3)+"\nAccountant E-mail: "+rs.getString(4)+"\nAccountant Phone Number: "+rs.getString(5)+"\nAccountant Username: "+rs.getString(6));			
				System.out.println("================================================");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
}
