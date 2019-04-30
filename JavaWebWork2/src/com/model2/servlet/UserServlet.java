package com.model2.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl udi = new UserDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		boolean Success = udi.findUser(userName, userPassword);

		if (Success) {
			ServletContext application = this.getServletContext();
			application.getRequestDispatcher("/StudentServlet").forward(request, response);
			System.out.println("getRequestDispatcher(\"/StudentServlet\")");
		} else {
			System.out.println("µÇÂ½Ê§°Ü");
		}
	}

}
