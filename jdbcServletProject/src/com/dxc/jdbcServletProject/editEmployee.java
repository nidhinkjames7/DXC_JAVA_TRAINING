package com.dxc.jdbcServletProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editEmployee
 */
@WebServlet("/editEmployee")
public class editEmployee extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int empID=Integer.parseInt(request.getParameter("empid"));
		String empName=request.getParameter("empname");
		String empEmail=request.getParameter("empemail");
		String empPassword=request.getParameter("emppassword");
		String empCountry=request.getParameter("empcountry");
		
		Employee mEmployee= new Employee();
		mEmployee.setId(empID);
		mEmployee.setName(empName);
		mEmployee.setEmail(empEmail);
		mEmployee.setPassword(empPassword);
		mEmployee.setCountry(empCountry);
		
		try {
			EmployeeDAO.editEmployee(mEmployee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
