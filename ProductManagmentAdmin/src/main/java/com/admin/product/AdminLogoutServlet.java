package com.admin.product;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/logout")
public class AdminLogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session has Exprired...<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}else {
			hs.removeAttribute("abean");
			hs.removeAttribute("alist");
			req.setAttribute("msg", "Admin LoggedOut Successfully...<br>");
			req.getRequestDispatcher("AdminLogout.jsp").forward(req, res);
		}
	}
}
