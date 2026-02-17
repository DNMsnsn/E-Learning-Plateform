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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String unm = request.getParameter("unm");
		String psw = request.getParameter("psw");
		
		User user = new User();
		user.setUname(unm);
		user.setPassword(psw);
		
		UserDaoImpl dao = new UserDaoImpl();
		User loged = dao.checkLogin(user);
		
		if(loged != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("id", loged.getId());
			session.setAttribute("fnm", loged.getFname());
			session.setAttribute("snm", loged.getSname());
			session.setAttribute("unm", loged.getUname());
			session.setAttribute("func", loged.getFunc());
			session.setAttribute("city", loged.getCity());
			session.setAttribute("mail", loged.getEmail());
			session.setAttribute("psw", loged.getPassword());
			session.setAttribute("avatar", loged.getAvatar_src());
			session.setAttribute("score", loged.getScore());
			
			response.sendRedirect("profile");
		} else {
			response.sendRedirect("/WEB-INF/login.jsp?error=1");
		}
			
		
	}
}
