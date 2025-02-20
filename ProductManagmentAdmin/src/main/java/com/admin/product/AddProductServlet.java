package com.admin.product;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false); // Accessing existing session
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}else {
			ProductBean pb = new ProductBean();
			pb.setCode(req.getParameter("pcode"));
			pb.setName(req.getParameter("pname"));
			pb.setPrice(Float.parseFloat(req.getParameter("pprice")));
			pb.setQty(Integer.parseInt(req.getParameter("pqty")));
			
			int k = new AddProductDAO().insertProduct(pb);
			
			if(k>0)
			{
				req.setAttribute("msg", "Product Added Successfully...<br>");
				req.getRequestDispatcher("addProduct.jsp").forward(req, res);
			}
		}
		
		req.setAttribute("msg", res);
	}
	
}
