/*package com.fantasybabymg.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fantasybaby.service.back.IUserService;
import com.fantasybabymg.bean.BlogUser;
public class UserTest {
	private IUserService userService;
	@Before
	public void before(){
		userService = (IUserService) new ClassPathXmlApplicationContext("").getBean("userService");
	}
	@Test
	public void testAddUser(){
		BlogUser user = new BlogUser();
		try {
		userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
*/