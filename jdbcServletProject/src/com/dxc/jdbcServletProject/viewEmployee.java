package com.dxc.jdbcServletProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewEmployee
 */
@WebServlet("/viewEmployee")
public class viewEmployee extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Employee> mList=new ArrayList<Employee>();
		try {
			/*mList = EmployeeDAO.getAllEmployees();
			// Do the parsing of List
			
			PrintWriter pw = response.getWriter();
			
			pw.print("<html><body><table><tr>");
			pw.print("<th>ID</th><th>NAME</th><th>EMAIL</th><th>PASSWORD</th><th>COUNTRY</th>");
			
			for(Employee mEmployee: mList) {
				pw.print("<tr>");
				pw.print("<td>"+mEmployee.getId()+"</td>");
				pw.print("<td>"+mEmployee.getName()+"</td>");
				pw.print("<td>"+mEmployee.getEmail()+"</td>");
				pw.print("<td>"+mEmployee.getPassword()+"</td>");
				pw.print("<td>"+mEmployee.getCountry()+"</td>");
				pw.print("</tr>");
			}
			
			pw.print("</tr></table></body></html>");*/
			
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter(); 
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=latin1","nidhin","Myfriends@123");
			
			PreparedStatement ps=con.prepareStatement("select * from employee");  
			              
			out.print("<table width=50% border=1>");  
			out.print("<caption>Employee List:</caption>");  
			  
			ResultSet rs=ps.executeQuery();  
			              
			/* Printing column names */  
			ResultSetMetaData rsmd=rs.getMetaData();  
			int total=rsmd.getColumnCount();  
			out.print("<tr>");  
			for(int i=1;i<=total;i++)  
			{  
			out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
			}  
			  
			out.print("</tr>");  
			              
			/* Printing result */  
			  
			while(rs.next())  
			{  
			out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></td>"+"</td><td>"+rs.getString(5)+"</td><tr>");  
			                  
			}  
			  
			out.print("</table>");  
			              
			out.print("<a href=index.html>HOME</a>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
