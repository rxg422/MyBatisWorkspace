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

@WebServlet("/emp/search2")
public class EmpSearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpSearchController2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		String gender = request.getParameter("gender");
		String salaryParam = request.getParameter("salary");
		String salaryCompare = request.getParameter("salaryCompare");
		String hireDate = request.getParameter("hire_date");
		String hiredateCompare = request.getParameter("hiredateCompare");
		
		int salary = 0;
		if(salaryParam != null && salaryParam != "") {
			salary = Integer.parseInt(salaryParam);
		}
		
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		param.put("gender", gender);
		param.put("salary", salary);
		param.put("salaryCompare", salaryCompare);
		param.put("hire_date", hireDate);
		param.put("hiredateCompare", hiredateCompare);
		
		EmpService service = new EmpService();
		List<Map<String, Object>> list = null;
		
		list = service.search2(param);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/emp/search2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
