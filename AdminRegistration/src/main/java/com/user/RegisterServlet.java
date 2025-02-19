package com.user;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String name = req.getParameter("uname");
		String pass = req.getParameter("upass");
		
		AdminBean ab = new AdminBean();
		
		
		
	}
}
