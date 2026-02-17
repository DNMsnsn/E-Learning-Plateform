package com.Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.DAO.User;
import com.DAO.UserDaoImpl;

@WebServlet("/AvatarUpdate")
public class AvatarUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String avatar = request.getParameter("av");
		
		HttpSession session = request.getSession();
		
		User user = new User();
		user.setAvatar_src(avatar);
		user.setId((int) session.getAttribute("id"));
		
		UserDaoImpl dao = new UserDaoImpl();
		boolean avset = dao.avatarUpdate(user);
		
		if(avset) {
			session.setAttribute("avatar", avatar);
			response.sendRedirect("profile");
		}
		
		
	}

}
