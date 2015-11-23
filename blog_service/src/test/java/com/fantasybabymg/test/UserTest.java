package com.fantasybabymg.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.bean.Category;
import com.fantasybabymg.service.back.IUserService;
public class UserTest {
	private IUserService userService;
	@Before
	public void before(){
		userService = (IUserService) new ClassPathXmlApplicationContext("classpath:spring-back-application.xml").getBean("userService");
	}
	@Test
	public void testAddUser(){
		BlogUser user = new BlogUser();
		Category category = new Category();
		category.set_id(1);
		user.setCategory(category);
		user.setPassWord("123");
		user.setUserName("FantasyBaby");
		try {
		userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testFindUser(){
//		BlogUser user = new BlogUser();
		try {
		List<BlogUser> findUsers = userService.findUsers();
		System.out.println(findUsers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}