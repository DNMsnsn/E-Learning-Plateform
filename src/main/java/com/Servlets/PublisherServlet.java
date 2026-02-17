package com.Servlets;

import java.io.IOException;

import com.DAO.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PublisherServlet")
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String content = request.getParameter("content");
		
		HttpSession httpSession = request.getSession();
		int id = (int) httpSession.getAttribute("id");
		String unm = (String) httpSession.getAttribute("unm");
		
		UserDaoImpl dao = new UserDaoImpl();
		dao.saveCourse(id, unm, title, desc, content);
		
		response.sendRedirect("profile");
				
	}
}
