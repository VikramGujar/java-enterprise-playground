package com.employee.employeeData;

import java.io.IOException;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;


@WebServlet("/dls")
public class DisplayServelet implements Servlet
{

	@Override
	public void init(ServletConfig scf) throws ServletException 
	{
		// No-Code
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, res);
		
	}
	
	@Override
	public void destroy() 
	{
		// No-Code
		
	}

	@Override
	public ServletConfig getServletConfig() 
	{
		
		return this.getServletConfig();
	}

	@Override
	public String getServletInfo() 
	{
		
		return "This class is used to Display Employee Data";
	}

	
	
}
