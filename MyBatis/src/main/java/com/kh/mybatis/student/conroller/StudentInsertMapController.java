package com.kh.mybatis.student.conroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentService;

@WebServlet("/student/insertStudentMap")
public class StudentInsertMapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentInsertMapController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("tel", tel);
		
		int result = new StudentService().insertStudentMap(param);
		
		if(result > 0) {
			request.setAttribute("msg", "map형식으로 학생 추가 성공!");
		}
		else {
			request.setAttribute("msg", "map형식으로 학생 추가 실패!");
		}
		
		response.sendRedirect(request.getContextPath()+"/student/insertStudentMap");
	}

}
