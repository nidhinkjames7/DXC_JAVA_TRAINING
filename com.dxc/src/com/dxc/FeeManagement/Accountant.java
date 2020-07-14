package com.dxc.FeeManagement;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

import javax.activation.MailcapCommandMap;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Accountant 
{
	Scanner sc= new Scanner(System.in);
	
	String stud_id;
	String stud_name,stud_address,stud_city,stud_state,stud_country;
	String stud_email,stud_phone,stud_course,stud_username,stud_password;
	String date;
	int stud_fee,stud_paid,stud_due;
	
	
	
	public void addStudent(BufferedReader buff, Connection con)
	{
		try
		{
			/*Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1","nidhin","Myfriends@123");
			*/
			Statement stmt=(Statement) con.createStatement();
			String insert_query= "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(insert_query);
			
			System.out.println("Enter Student id");
			stud_id=sc.nextLine();
			System.out.println("Enter Student Name");
			stud_name=sc.nextLine();
			System.out.println("Enter Student Address");
			stud_address=sc.nextLine();
			System.out.println("Enter City");
			stud_city=sc.nextLine();
			System.out.println("Enter State");
			stud_state=sc.nextLine();
			System.out.println("Enter Country");
			stud_country=sc.nextLine();
			System.out.println("Enter Email");
			stud_email=sc.nextLine();
			System.out.println("Enter Phone Number");
			stud_phone=sc.nextLine();
			System.out.println("Enter Course");
			stud_course=sc.nextLine();
			System.out.println("Enter Fees");
			stud_fee=sc.nextInt();
			/*System.out.println("Enter Fee Paid");
			stud_paid=sc.nextLine();*/
			/*System.out.println("Enter Due Fees");
			stud_due=sc.nextLine();*/
			System.out.println("Enter Username");
			stud_username=sc.next();
			System.out.println("Enter Password");
			stud_password=sc.next();
			
			pstmt.setString(1, stud_id);
			pstmt.setString(2, stud_name);
			pstmt.setString(3, stud_address);
			pstmt.setString(4, stud_city);
			pstmt.setString(5, stud_state);
			pstmt.setString(6, stud_country);
			pstmt.setString(7, stud_email);
			pstmt.setString(8, stud_phone);
			pstmt.setString(9, stud_course);
			pstmt.setInt(10, stud_fee);
			/*pstmt.setString(11, stud_paid);
			pstmt.setString(12, stud_due);*/
			pstmt.setString(11, stud_username);
			pstmt.setString(12, stud_password);
			pstmt.setInt(13, stud_due);
			pstmt.setInt(14, stud_paid);
			pstmt.setString(15, date);
			
			pstmt.executeUpdate();
			
			System.out.println("Successfully Inserted");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		finally
		{
			sc.close();
		}
	}
	public void viewStudent(BufferedReader buff, Connection con)
	{
		/*System.out.println("Enter Student Name: "+stud_name);		
		System.out.println("Enter Student Address: "+stud_address);		
		System.out.println("Enter City: "+stud_city);		
		System.out.println("Enter State: "+stud_state);		
		System.out.println("Enter Country: "+stud_country);		
		System.out.println("Enter Email: "+stud_email);		
		System.out.println("Enter Phone Number: "+stud_phone);
		System.out.println("Enter Course: "+stud_course);	
		System.out.println("Enter Fees: "+stud_fee);		
		System.out.println("Enter Fee Paid: "+stud_paid);		
		System.out.println("Enter Due Fees: "+stud_due);		
		System.out.println("Enter Username: "+stud_username);
		*/
		try
		{
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1","nidhin","Myfriends@123");*/
		Statement stmt=(Statement) con.createStatement();
		ResultSet rs= stmt.executeQuery("select * from student");
		while(rs.next())
		{
			System.out.println("Student ID: "+rs.getString(1)+"\nStudent Name: "+rs.getString(2)+"\nStudent Address: "+rs.getString(3)+"\nStudent City: "+rs.getString(4)+"\nStudent State: "+rs.getString(5)+"\nStudent Country: "+rs.getString(6)+"\nStudent Email: "+rs.getString(7)+
					"\nStudent Phone: "+rs.getString(8)+"\nStudent Course: "+rs.getString(9)
					+"\nStudent Fee: "+rs.getString(10)/*"\nStudent Fee Paid: "+rs.getString(11)+
					"\nStudent Fee Due: "+rs.getString(12)*/+"\nStudent Username: "+rs.getString(11));		
			System.out.println("============================================================");
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		finally
		{
			sc.close();
		}
	}
	
	public void account(Connection con)
	{
		System.out.println("*****Welcome to ACCOUNT section*****");
		System.out.println("=====================================");
		System.out.println("Enter User ID");
		stud_id=sc.next();
		try
		{
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy?characterEncoding=latin1","nidhin","Myfriends@123");*/
		Statement stmt=(Statement) con.createStatement();
		String insert_query= "INSERT INTO student VALUES(?,?,?)";
		PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(insert_query);
		ResultSet rs= stmt.executeQuery("SELECT * FROM student WHERE stud_id='"+stud_id+"'");
		while(rs.next())
		{
			System.out.println("Student ID: "+rs.getString(1)+"\nStudent Name: "+rs.getString(2)+"\nStudent Address: "+rs.getString(3)+"\nStudent City: "+rs.getString(4)+"\nStudent State: "+rs.getString(5)+"\nStudent Country: "+rs.getString(6)+"\nStudent Email: "+rs.getString(7)+
					"\nStudent Phone: "+rs.getString(8)+"\nStudent Course: "+rs.getString(9)
					+"\nStudent Fee: "+rs.getInt(10)/*"\nStudent Fee Paid: "+rs.getString(11)+
					"\nStudent Fee Due: "+rs.getString(12)*/+"\nStudent Username: "+rs.getString(11));		
			System.out.println("============================================================");
		}

		System.out.println("Enter Fee Paied");
		stud_paid=sc.nextInt();
		System.out.println("Enter Date of Payment");
		date=sc.nextLine();
		stud_due =(stud_fee) - (stud_paid);
		

		/*pstmt.setString(1, stud_id);
		pstmt.setString(2, stud_name);
		pstmt.setString(3, stud_address);
		pstmt.setString(4, stud_city);
		pstmt.setString(5, stud_state);
		pstmt.setString(6, stud_country);
		pstmt.setString(7, stud_email);
		pstmt.setString(8, stud_phone);
		pstmt.setString(9, stud_course);
		pstmt.setInt(10, stud_fee);
		pstmt.setString(11, stud_paid);
		pstmt.setString(12, stud_due);
		pstmt.setString(13, stud_username);
		pstmt.setString(14, stud_password);*/
		pstmt.setInt(15, stud_due);
		pstmt.setInt(16, stud_paid);
		pstmt.setString(17, date);
		
		pstmt.executeUpdate();
		System.out.println("Fees Updated!!!");
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		finally 
		{
			sc.close();
		}		
	}
}
