package com.kh.mybatis.student.conroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentService;
import com.kh.mybatis.student.service.model.vo.Student;

@WebServlet("/student/insertStudent")
public class StudentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 학생 입력페이지 이동
		request.getRequestDispatcher("/student/insertStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 입력한 값을 파라미터로 추출 및 vo 클래스로 가공
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Student s = new Student();
		s.setName(name);
		s.setTel(tel);
		
		// vo 클래스를 service념겨 insert작업 수행
		int result = new StudentService().insertStudent(s);
		
		// 응답처리
		if(result > 0) {
			// 서비스 처리 결과 메시지 추가
			request.getSession().setAttribute("msg", "학생 등록 성공");
		}
		else {
			request.getSession().setAttribute("msg", "학생 등록 실패");
		}
		// dml 처리완료 후 재요청(redirect)를 통해 requestScope에 저장된 데이터 초기화
		response.sendRedirect(request.getContextPath()+"/student/insertStudent");
	}

}
