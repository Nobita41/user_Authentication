package com.userServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UserDao.User;
import com.userBeans.UserRegistrationBeans;

/**
 * Servlet implementation class userEditProfile
 */
@WebServlet("/userEditProfile")
public class userEditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetch all data
		PrintWriter out= response.getWriter();
		String name=request.getParameter("userName");
		String email= request.getParameter("userEmail");
		String password= request.getParameter("userPassword");
		
		// httpSession Creation
		
		HttpSession hs= request.getSession();
		UserRegistrationBeans user=(UserRegistrationBeans)hs.getAttribute("loginpass");
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		//  update databse
		
		User dao = new User();
	boolean ans= dao.editProfile(user);
	if(ans) {
		request.setAttribute("msg", "Profile Updated successfully");
		 RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	else {
		out.print("error");
	}
 	 
	}

}
