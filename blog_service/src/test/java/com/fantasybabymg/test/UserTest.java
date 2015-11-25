/*package com.fantasybabymg.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.bean.BlogUserDetail;
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
		BlogUserDetail ud = new BlogUserDetail();
		ud.setAddress("上海虹口");
		ud.setEmail("fantasybabymg@gmail.com");
		ud.setHometown("陕西宝鸡");
		ud.setImage("head.jpg");
		ud.setName("刘");
		ud.setNickname("FantasyBaby");
		ud.setPhone("123456");
		ud.setProfession("程序猿");
		ud.setSex(0);
		user.setUserDetail(ud);
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
	@Test
	public void testdelUser(){
//		BlogUser user = new BlogUser();
		try {
		boolean deleteUser = userService.deleteUser(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/