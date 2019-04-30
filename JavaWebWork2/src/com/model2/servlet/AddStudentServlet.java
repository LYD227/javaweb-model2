package com.model2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.dao.impl.StudentDaoImpl;
import com.model2.pojo.Student;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StudentDaoImpl sdi = new StudentDaoImpl();
		String name = request.getParameter("stuName");
		String major = request.getParameter("major");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		Student stu = new Student();
		stu.setStuName(name);
		stu.setMajor(major);
		stu.setGender(gender);
		stu.setBirthday(birthday);
		boolean isSuccess = sdi.save(stu);
		if (isSuccess) {
			request.getRequestDispatcher("/StudentServlet").forward(request, response);
		}else {
			System.out.println("Ê§°Ü");
		}

	}

}
