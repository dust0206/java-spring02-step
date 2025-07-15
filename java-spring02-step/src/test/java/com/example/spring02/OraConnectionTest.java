package com.example.spring02;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OraConnectionTest {
	
	private static final Logger log = LoggerFactory.getLogger(OraConnectionTest.class);
	
	// jdbc 오라클 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// 오라클 연결 문자열
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// 사용자 아이디
	private static final String USER = "spring";
	
	// 비밀번호
	private static final String PW = "spring";
	
	// 테스트 JUnit
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try(
			Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(conn);
			System.out.println("연결 되었읍니다.");
			log.info("연결되었읍니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
