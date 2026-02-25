package com.kh.mybatis.student.conroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentService;

@WebServlet("/student/deleteStudent")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
//		int result = new StudentService().deleteStudent(no);
		
//		if(result > 0) {
//			
//		}
	}

}
