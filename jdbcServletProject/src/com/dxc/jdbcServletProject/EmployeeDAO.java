package com.dxc.jdbcServletProject;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO 
{
	// Singleton Design Pattern Implementation for Connection Object
		public static Connection getConnection() throws Exception {
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");
			if (con == null)
				return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=latin1","nidhin","Myfriends@123");
			else
				return con;
		}

	public static int  saveEmployee(Employee mEmp) throws Exception
	{
		int status = 0;
		Connection con = EmployeeDAO.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into employee(emp_name,emp_email,emp_password,emp_country) values(?,?,?,?)");
		ps.setString(1, mEmp.getName());
		ps.setString(2, mEmp.getEmail());
		ps.setString(3, mEmp.getPassword());
		ps.setString(4, mEmp.getCountry());
		status = ps.executeUpdate();	
		
		System.out.println("Successfully Added");
		
		/*PrintWriter pw = response.getWriter();
		pw.println("<script type=\"text/javascript\">");
		pw.println("alert('Inserted Successfully');");
		pw.println("</script>");*/
			
		ps.close();
		return status;
	}
	
	public static int editEmployee(Employee mEmp) throws Exception {
		int status = 0;
		Connection con = EmployeeDAO.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into employee(emp_name,emp_email,emp_password,emp_country) values(?,?,?,?)");
		ps.setString(1, mEmp.getName());
		ps.setString(2, mEmp.getEmail());
		ps.setString(3, mEmp.getPassword());
		ps.setString(4, mEmp.getCountry());
		status = ps.executeUpdate();	
		
		System.out.println("Successfully Updated!!!");
		return status;
	}
	
	public static int deleteEmployee(int id) throws Exception {
		int status = 0;
		Connection con = EmployeeDAO.getConnection();
		
		return status;
	}

	public static Employee getEmployeebyID(int id) throws Exception {
		Employee mEmployee = new Employee();
		Connection con = EmployeeDAO.getConnection();
		
		return mEmployee;
	}
	
	public static List<Employee> getAllEmployees() throws Exception {
		List<Employee> mList = new ArrayList<Employee>();
		Connection con = EmployeeDAO.getConnection();
		
		return mList;
	}
	
}
