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
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StudentDaoImpl sdi = new StudentDaoImpl();
		String id= request.getParameter("stuId");
		int stuId = Integer.parseInt(id);
		String name = request.getParameter("stuName");
		String major = request.getParameter("major");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		Student  stu = sdi.findById(stuId);
		stu.setStuId(stuId);
		stu.setStuName(name);
		stu.setMajor(major);
		stu.setGender(gender);
		stu.setBirthday(birthday);
		boolean isSuccess = sdi.update(stu);
		if (isSuccess) {
			request.getRequestDispatcher("/StudentServlet").forward(request, response);
		}else {
			System.out.println("Ê§°Ü");
		}	
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
}
