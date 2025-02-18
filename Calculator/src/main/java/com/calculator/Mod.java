package com.calculator;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/md")
public class Mod extends GenericServlet
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
			
			int mod = v1%v2;
			
			pw.println("Mod = "+mod);
			
		}catch (Exception e) 
		{
			pw.println("Enter only Integer value ");	
		}
		
	}

}
