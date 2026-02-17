package com.Servlets;

import java.io.IOException;

import com.DAO.User;
import com.DAO.UserDaoImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String fnm = request.getParameter("fnm");
		String snm = request.getParameter("snm");
		String unm = request.getParameter("unm");
		String fnc = request.getParameter("fnc");
		String city = request.getParameter("city");
		String eml = request.getParameter("ml");
		String psw = request.getParameter("psw");
		
		User user = new User();
		user.setFname(fnm);
		user.setSname(snm);
		user.setUname(unm);
		user.setFunc(fnc);
		user.setCity(city);
		user.setEmail(eml);
		user.setPassword(psw);
		user.setAvatar_src("css/avatars/av1.jpg");
		user.setScore(0);
		
		UserDaoImpl dao = new UserDaoImpl();
		dao.signUP(user);
		
		response.sendRedirect("/WEB-INF/login.jsp");
		
	}
}
