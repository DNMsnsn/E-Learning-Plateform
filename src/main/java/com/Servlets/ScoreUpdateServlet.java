package com.Servlets;

import java.io.IOException;

import com.DAO.User;
import com.DAO.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ScoreUpdateServlet")
public class ScoreUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer score = (Integer) session.getAttribute("score");
		Integer id = (Integer) session.getAttribute("id");
		
		score += 10;
		
		session.setAttribute("score", score);
		
		User user = new User();
		user.setScore(score);
		user.setId(id);
		
		UserDaoImpl dao = new UserDaoImpl();
		dao.scoreUpdate(user);
		
		response.sendRedirect("profile");
		//request.getRequestDispatcher("course").forward(request, response);
		
	}

}
