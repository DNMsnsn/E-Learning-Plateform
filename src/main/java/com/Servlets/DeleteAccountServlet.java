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

@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		User user = new User();
		user.setId((int) session.getAttribute("id"));
		
		UserDaoImpl dao = new UserDaoImpl();
		boolean delete = dao.deleteAccount(user);
		
		if(delete) {
			session.invalidate();
			response.sendRedirect("/WEB-INF/welcome.jsp");
		}
		
	}

}
