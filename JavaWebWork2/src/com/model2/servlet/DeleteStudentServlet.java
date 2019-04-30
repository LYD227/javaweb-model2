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
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StudentDaoImpl sdi = new StudentDaoImpl();
		String id= request.getParameter("id");
		int StuId = Integer.parseInt(id);
		
		Student stu = new Student();
		stu.setStuId(StuId);
		boolean isSuccess = sdi.delete(stu);
		if (isSuccess) {
			request.getRequestDispatcher("/StudentServlet").forward(request, response);
		}else {
			System.out.println("Ê§°Ü");
		}

		
	}

}
