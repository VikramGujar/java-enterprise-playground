package com.calculator;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/sb")
public class Sub extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		try 
		{
			int v1 = Integer.parseInt(req.getParameter("v1"));
			int v2 = Integer.parseInt(req.getParameter("v2"));
			
			int sub = v1-v2;
			
			pw.println("Sub = "+sub);
			
		}catch (Exception e) 
		{
			pw.println("Enter only Integer value ");	
		}
		
	}

}

