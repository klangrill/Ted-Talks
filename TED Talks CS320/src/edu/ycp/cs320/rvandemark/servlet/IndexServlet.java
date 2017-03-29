package edu.ycp.cs320.rvandemark.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.rvandemark.model.Engine;
import edu.ycp.cs320.rvandemark.model.User;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Engine.setUser(new User (
			"rvandemark@ycp.edu",
			"rvandy",
			"secure password 123",
			"Nick",
			"Vandemark",
			0,
			new String[]{"Computer Engineering", "Computer Science", "Physics", "Math", "Psychology"}
		));
		
		req.setAttribute("user", Engine.getUser());
		
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Engine.setUser(new User (
			"rvandemark@ycp.edu",
			"rvandy",
			"secure password 123",
			"Nick",
			"Vandemark",
			0,
			new String[]{"Computer Engineering", "Computer Science", "Physics", "Math", "Psychology"}
		));
		
		req.setAttribute("user", Engine.getUser());
		
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
}
