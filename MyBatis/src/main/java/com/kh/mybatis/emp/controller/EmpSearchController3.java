package com.kh.mybatis.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.emp.model.service.EmpService;

@WebServlet("/emp/search3")
public class EmpSearchController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpSearchController3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 직급정보 조회 후 request에 저장
		List jobList = new EmpService().selectJobList();
		
		String arr[] = request.getParameterValues("jobCode");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("arr", arr);
		
		List list = new EmpService().search3(param);
		
		request.setAttribute("jobList", jobList);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/emp/search3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
