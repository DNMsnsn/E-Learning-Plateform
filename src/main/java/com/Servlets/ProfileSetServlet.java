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

@WebServlet("/ProfileSetServlet")
public class ProfileSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fnm = request.getParameter("fnm");
		String snm = request.getParameter("snm");
		String unm = request.getParameter("unm");
		String fnc = request.getParameter("fnc");
		String city = request.getParameter("city");
		String eml = request.getParameter("ml");
		String psw = request.getParameter("psw");
		
		HttpSession session = request.getSession();
		
		User user = new User();
		user.setId((int) session.getAttribute("id"));
		user.setFname(fnm);
		user.setSname(snm);
		user.setUname(unm);
		user.setFunc(fnc);
		user.setCity(city);
		user.setEmail(eml);
		user.setPassword(psw);
		
		UserDaoImpl dao = new UserDaoImpl();
		
		
		if(dao.profileSet(user)) {
			
			session.setAttribute("fnm", fnm);
			session.setAttribute("snm", snm);
			session.setAttribute("unm", unm);
			session.setAttribute("func", fnc);
			session.setAttribute("city", city);
			session.setAttribute("mail", eml);
			session.setAttribute("psw", psw);
			
			response.sendRedirect("profile");
			
		} else {
			
			response.sendRedirect("profile?error=1");
		}
		
	}

}
