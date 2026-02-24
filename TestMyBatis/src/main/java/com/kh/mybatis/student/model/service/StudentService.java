package com.kh.mybatis.student.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.student.model.dao.StudentDao;
import com.kh.mybatis.student.model.vo.Student;

public class StudentService {

	private StudentDao dao = new StudentDao();
	
	public int insertStudent(Student s) {
		
		return 0;
	}

}
