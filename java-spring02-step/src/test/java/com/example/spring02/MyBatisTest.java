package com.example.spring02;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

// p.93

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTest {

	// 의존관계 주입
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		System.out.println("sqlFactory : " + sqlFactory);
	}
	
	@Test
	public void testSession() throws Exception {
		try(SqlSession session = sqlFactory.openSession()) {
			System.out.println(" session : " + session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
