package com.Servlets;

import java.io.IOException;

import com.DAO.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCourse")
public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String unm = request.getParameter("unm");
		String ttl = request.getParameter("title");
		
		String sessionUnm = (String) request.getSession().getAttribute("unm");
		
		if(sessionUnm != null && sessionUnm.equals(unm)) {
			UserDaoImpl dao = new UserDaoImpl();
			dao.deleteCourse(unm, ttl);
		}
		
		response.sendRedirect("profile");
	}
}
