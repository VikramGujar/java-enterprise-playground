package com.admin.product;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/admin")
public class AdminLoginServlet  extends HttpServlet
{

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		
		AdminBean ab = new AdminLoginDAO().login(userName, passWord);
		
		if(ab==null)
		{
			
		}else {
			HttpSession hs = req.getSession();
			hs.setAttribute("abean", ab);
			RequestDispatcher rd = req.getRequestDispatcher("AdminLoginSuccess.jsp");
			rd.forward(req, res);
		}
			
	}
}
