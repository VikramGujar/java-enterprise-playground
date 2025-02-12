package com.demo.serv1;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/dls")
public class DisplayServlet implements Servlet
{

	@Override
	public void init(ServletConfig scf) throws ServletException 
	{
		// no code
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String yourName = req.getParameter("name");
		String yourMail = req.getParameter("mail");
		String yourPhone = req.getParameter("phone");
		String yourGender = req.getParameter("gender");
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("Your Name is <h1>"+yourName+"</h1>");
		pw.println("Your Mail is <h1>"+yourMail+"</h1>");
		pw.println("Your Phone is <h1>"+yourPhone+"</h1>");
		pw.println("Your Gender is <h1>"+yourGender+"</h1>");
		
	}

	
	
	@Override
	public void destroy() 
	{
		// no code
		
	}

	@Override
	public ServletConfig getServletConfig() 
	{
		
		return this.getServletConfig();
	}

	@Override
	public String getServletInfo() 
	{
		
		return "This servlet will Desplay User name";
	}

	

	
}
