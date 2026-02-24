package com.kh.mybatis.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentService;
import com.kh.mybatis.student.model.vo.Student;

@WebServlet("/student/insertStudent")
public class StudentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/student/insertStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Student s = new Student();
		s.setName(name);
		s.setTel(tel);
		
		int result = new StudentService().insertStudent(s);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "학생 등록 성공!");
		}
		else {
			request.getSession().setAttribute("msg", "학생 등록 성공!");
		}
		
		response.sendRedirect(request.getContextPath()+"/student/insertStudent");
	}

}
