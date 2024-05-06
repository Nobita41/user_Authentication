package com.userServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UserDao.User;
import com.userBeans.UserRegistrationBeans;

/**
 * Servlet implementation class userRegistrationServlet
 */
@SuppressWarnings("serial")
@WebServlet("/userRegistrationServlet")
public class userRegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher dispatcher=null;
		
		String name=request.getParameter("userName");
	String email=request.getParameter("userEmail");
	String pass=request.getParameter("userPassword");
	
	
	// object of userBeans
	UserRegistrationBeans urb= new UserRegistrationBeans(name, email, pass);
	
	// object of userdao
	User u= new User();
	
	int status=u.userRegistration(urb);
	if(status>0) {
		request.setAttribute("msg", "Thank you for registration");
		dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
	}
	
	}

}
