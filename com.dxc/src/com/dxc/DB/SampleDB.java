package com.dxc.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class SampleDB 
{
	public static void main(String[] args) throws Exception
	{
		/*Scanner sc= new Scanner(System.in);*/
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb?characterEncoding=latin1","nidhin","Myfriends@123");
		
		Statement stmt=(Statement) con.createStatement();
		
		
		
		String insertQuery= "INSERT INTO contact VALUES(?,?,?,?)";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(insertQuery);
		pstmt.setInt(1, 3);
		pstmt.setString(2,"Amal");
		pstmt.setString(3, "amal@gmail.com");
		pstmt.setString(4,"9873876388");
		
		pstmt.execute();
		
		ResultSet rs= stmt.executeQuery("select * from contact");
		while(rs.next())
		{
			System.out.println("ID: "+rs.getInt(1)+"\nName: "+rs.getString(2)+"\nE-mail: "+rs.getString(3)+"\nPhone: "+rs.getString(4));			
		}
		con.close();
	}
}
