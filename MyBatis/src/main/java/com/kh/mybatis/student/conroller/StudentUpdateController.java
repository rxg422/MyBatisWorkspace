package com.kh.mybatis.student.conroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentService;
import com.kh.mybatis.student.service.model.vo.Student;

@WebServlet("/student/updateStudent")
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 가공
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Student s = new Student(no, name, tel, null);
		
		int result = new StudentService().updateStudent(s);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "정보 수정 성공!");
		}
		else {
			request.getSession().setAttribute("msg", "정보 수정 실패!");
		}
		response.sendRedirect(request.getContextPath()+"/student/selectOne?no="+no);
	}

}
