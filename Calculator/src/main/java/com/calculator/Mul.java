package com.calculator;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/ml")
public class Mul extends GenericServlet
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
			
			int mul = v1*v2;
			
			pw.println("Mul = "+mul);
			
		}catch (Exception e) 
		{
			pw.println("Enter only Integer value ");	
		}
		
	}

}
