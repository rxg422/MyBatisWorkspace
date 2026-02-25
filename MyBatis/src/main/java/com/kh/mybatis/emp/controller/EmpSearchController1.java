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

@WebServlet("/emp/search1")
public class EmpSearchController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpSearchController1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		
		EmpService service = new EmpService();
		List<Map<String, Object>> list = null;
		
		if(searchType.equals("") || searchKeyword == null) {
			list = service.selectAll();
		}
		else {
			list = service.search1(param);
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/emp/search1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
