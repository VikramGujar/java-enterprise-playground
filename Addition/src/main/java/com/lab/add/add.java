package com.lab.add;

import java.io.IOException;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/add")
public class add implements Servlet
{

	@Override
	public void init(ServletConfig scf) throws ServletException 
	{
		// no-code
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd =req.getRequestDispatcher("add");
		rd.forward(req, res);
		
	}
	
	@Override
	public void destroy() 
	{
		// no-code
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
