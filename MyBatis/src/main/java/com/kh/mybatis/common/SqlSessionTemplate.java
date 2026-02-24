package com.kh.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

	// 어플리케이션 시작시 SqlSessionFactory를 1회만 생성하여 재사용
	private static SqlSessionFactory sqlSessionFactory;
	
	// static 초기화 블럭
	static {
		String resource = "/mybatis-config.xml";
		try(InputStream inputStream = Resources.getResourceAsStream(resource);) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// sqlSession 생성 및 반환
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession(false); // 수동커밋
	}
	
}
