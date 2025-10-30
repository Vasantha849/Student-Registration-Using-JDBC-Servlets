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
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/logForm")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String myemail = request.getParameter("email");
	    String mypassword = request.getParameter("pass");
	    String message = "Invalid credentials";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mainsql","root","vasantha@512");
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE email=? AND password=?");
	        ps.setString(1, myemail);
	        ps.setString(2, mypassword);

	        ResultSet rs = ps.executeQuery();
	        if(rs.next()) {
	            message = " Welcome " + rs.getString("name");
	        }

	        rs.close();
	        ps.close();
	        con.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    request.setAttribute("message", message);
	    RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
	    rd.forward(request, response);
	}

	}

