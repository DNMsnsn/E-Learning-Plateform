package com.Servlets;

import java.io.IOException;
import java.util.List;

import com.DAO.Course;
import com.DAO.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDaoImpl dao = new UserDaoImpl();
		
		HttpSession session = request.getSession();
		String unm = (String) session.getAttribute("unm");
		
		List<Course> course = dao.profileCourse(unm);
		
		request.setAttribute("courses", course);
		
		request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
		
	}

}
