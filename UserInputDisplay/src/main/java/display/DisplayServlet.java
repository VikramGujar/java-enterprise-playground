package display;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/user")
public class DisplayServlet implements Servlet 
{
	@Override
	public void init(ServletConfig arg0) throws ServletException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String mid = req.getParameter("mid");
		long phone = Long.parseLong(req.getParameter("phno"));
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		pw.println("<!DOCTYPE html>");
		pw.println("<html lang='en'>");
		pw.println("<head>");
		pw.println("<meta charset='UTF-8'>");
		pw.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		pw.println("<title>User Details</title>");
		pw.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
		pw.println("<style>");
		pw.println("body { background-color: #f8f9fa; }");
		pw.println(".container { width: 50%; margin: 50px auto; background: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); text-align: center; }");
		pw.println("h2 { color: #007bff; }");
		pw.println(".details { font-size: 18px; line-height: 1.6; }");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");

		pw.println("<div class='container'>");
		pw.println("<h2>******* User Details *******</h2><br>");
		pw.println("<div class='details'>");
		pw.println("<p><strong>ID:</strong> " + id + "</p>");
		pw.println("<p><strong>First Name:</strong> " + fname + "</p>");
		pw.println("<p><strong>Last Name:</strong> " + lname + "</p>");
		pw.println("<p><strong>Mail ID:</strong> " + mid + "</p>");
		pw.println("<p><strong>Phone No:</strong> " + phone + "</p>");
		pw.println("</div>");
		pw.println("</div>");

		pw.println("</body>");
		pw.println("</html>");

		
		
		
		
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "Display User Detailes";
	}

	

}
