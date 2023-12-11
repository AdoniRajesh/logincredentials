package servletdemo;

import java.io.IOException;

import java.io.PipedWriter;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/forward")
public class servlet3 extends GenericServlet{

		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			
			String email=req.getParameter("email");
			String password =req.getParameter("password");
			
			if(email.equals("js@gmail.com")&& password.equals("1234"))
			{
				RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
				rd.forward(req, res);
			}
			else
			{
                PrintWriter pw=res.getWriter();
                pw.println(" <h1>  Invalid </h1> ");// pw.println(" invalid ");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, res);
				                                                      //res.setContentType("text/html");
			}
		

	}

}
