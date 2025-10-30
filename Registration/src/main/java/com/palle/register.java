package com.palle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class register
 */
@WebServlet("/regForm")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 String myname=request.getParameter("name1");	
 String myemail=request.getParameter("email1");
 String mypass=request.getParameter("pass1");
		
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mainsql","root","vasantha@512");
	PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
	ps.setString(1, myname);
	ps.setString(2, myemail);
	ps.setString(3, mypass);
	
	ps.executeUpdate();
	ps.close();
	con.close();
	
	RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
	rd.forward(request, response);
	}
catch(Exception e)
{
	e.printStackTrace();
}
	}

}
