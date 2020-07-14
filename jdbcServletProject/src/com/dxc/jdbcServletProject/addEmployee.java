package com.dxc.jdbcServletProject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addEmployee
 */
@WebServlet("/addEmployee")
public class addEmployee extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String empName=request.getParameter("emp_name");
		String empEmail=request.getParameter("emp_email");
		String empPassword=request.getParameter("emp_password");
		String empCountry=request.getParameter("emp_country");
		
		Employee mEmployee= new Employee();
		mEmployee.setName(empName);
		mEmployee.setEmail(empEmail);
		mEmployee.setPassword(empPassword);
		mEmployee.setCountry(empCountry);
		
		try {
			EmployeeDAO.saveEmployee(mEmployee);
			response.sendRedirect("index.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
