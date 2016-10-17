


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyFirstGenericServlet
 */
@WebServlet("/MyFirstGenericServlet")
public class MyFirstGenericServlet extends HttpServlet implements Servlet {
	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String id=request.getParameter("id");
		
		if(id.equals("1"))
		{
			String fname=request.getParameter("first_name");
			String lname=request.getParameter("last_name");
			session.setAttribute("fname", fname);
			session.setAttribute("lname", lname);
			response.sendRedirect("form2.html");
		}
		if(id.equals("2"))
		{
			String age=request.getParameter("age");
			String weight=request.getParameter("weight");
			session.setAttribute("age", age);
			session.setAttribute("weight", weight);
			response.sendRedirect("form3.html");
		}
		if(id.equals("3"))
		{
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			session.setAttribute("email", email);
			session.setAttribute("contact", contact);
			
			
			String fname=(String) session.getAttribute("fname");
			String lname=(String) session.getAttribute("lname");
			String age=(String) session.getAttribute("age");
			String weight=(String) session.getAttribute("weight");
			String email1=(String) session.getAttribute("email");
			String contact1=(String) session.getAttribute("contact");
			
			System.out.println(fname);
			System.out.println(lname);
			System.out.println(age);
			System.out.println(weight);
			System.out.println(email1);
			System.out.println(contact1);

			out.println(fname+"</br>");
			out.println(lname);
			out.println(age);
			out.println(weight);
			out.println(email1);
			out.println(contact1);
			
			RequestDispatcher rd= request.getRequestDispatcher("secondServlet");
			rd.forward(request, response);

		}
		
		
		
	}

}
