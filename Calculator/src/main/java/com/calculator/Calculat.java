package com.calculator;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/calculate")
public class Calculat implements Servlet
{

	@Override
	public void init(ServletConfig scf) throws ServletException 
	{
		// no-code
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String choice = req.getParameter("cal");
		System.out.println(choice);
		if(choice.equals("sum"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("ad");
			rd.forward(req, res);
			
		}else if(choice.equals("sub"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("sb");
			rd.forward(req, res);
			
		}else if(choice.equals("mul"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("ml");
			rd.forward(req, res);
			
		}else if(choice.equals("mod"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("md");
			rd.forward(req, res);
			
		}else
		{
			RequestDispatcher rd = req.getRequestDispatcher("dv");
			rd.forward(req, res);
			
		}
		
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
