package com.kh.mybatis.student.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.student.service.model.vo.Student;

public class StudentDao {

	public int insertStudent(SqlSession session, Student s) {
		// insert("mapper namespace.queryTagId", 바인딩 값(파라미터))
		return session.insert("student.insertStudent", s);		
	}

}
