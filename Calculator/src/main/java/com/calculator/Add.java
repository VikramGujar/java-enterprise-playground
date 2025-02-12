package com.calculator;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/calculate")
public class Add implements Servlet
{

	@Override
	public void init(ServletConfig scf) throws ServletException 
	{
		// no-code
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int num1 = Integer.parseInt(req.getParameter("v1"));
		int num2 = Integer.parseInt(req.getParameter("v2"));
		
		int sum = num1 + num2;
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("Sum = "+sum+"");
		
	}
	
	@Override
	public void destroy() 
	{
		// no-code
		
	}

	@Override
	public ServletConfig getServletConfig() 
	{
		
		return this.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		
		return "This servlet file is Calculator";
	}

	

}
