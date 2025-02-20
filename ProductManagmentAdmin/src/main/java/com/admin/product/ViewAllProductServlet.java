package com.admin.product;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllProductServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}else {
			
			ArrayList<ProductBean> al = new ViewAllProductDAO().retrive();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("viewAllProduct.jsp").forward(req, res);
		}
	}
}
