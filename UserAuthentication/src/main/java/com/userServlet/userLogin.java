package com.userServlet;

import java.io.IOException;

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
 * Servlet implementation class userLogin
 */
@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("userEmail");
	String pass= request.getParameter("userPassword");
	
	HttpSession hs= request.getSession();
	User dao= new User();
	UserRegistrationBeans urs= dao.login(email, pass);
	
	if(urs!=null) {
		hs.setAttribute("msg", email);
		hs.setAttribute("loginpass", urs);
		response.sendRedirect("index.jsp");	
	}
	else {
		request.setAttribute("msg", "Invalid Credentials");
		RequestDispatcher dispatcher = request.getRequestDispatcher("userLogin.jsp");
		dispatcher.forward(request, response);
	}
	System.out.println(email +" "+ pass);
	}

}
