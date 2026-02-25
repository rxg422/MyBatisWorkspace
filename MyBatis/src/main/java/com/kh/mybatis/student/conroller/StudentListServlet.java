package com.kh.mybatis.student.conroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentService;
import com.kh.mybatis.student.service.model.vo.Student;

@WebServlet("/student/selectList")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list = new StudentService().selectStudentList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/student/selectList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
