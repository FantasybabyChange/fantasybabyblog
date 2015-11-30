package com.fantasybabymg.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.bean.BlogUserDetail;
import com.fantasybabymg.bean.Category;
import com.fantasybabymg.context.SystemContext;
import com.fantasybabymg.service.back.IUserDetailService;
import com.fantasybabymg.service.back.IUserService;
import com.fantasybabymg.ubean.Criterion;
public class UserTest {
	private IUserService userService;
	private IUserDetailService userDetailService;
	@Before
	public void before(){
		ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("classpath:spring-back-application.xml");
		userService = (IUserService) cx.getBean("userService");
		userDetailService = (IUserDetailService) cx.getBean("userDetailService");
	}
	@Test
	public void testAddUser(){
		BlogUser user = new BlogUser();
		Category category = new Category();
		category.set_id(1);
		user.setCategory(category);
		user.setPassWord("123");
		user.setUserName("FantasyBaby");
		user.setStatus(0);
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
			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("username", "f");
//			map.put("userid",'1');
			map.put("status", "");
			Criterion<Object> cri = new Criterion<Object>();
			cri.setCriterion(map);
			SystemContext.setCriterionMap(cri);
			
			List<BlogUser> findUsers = userService.findUsers();
		findUsers.forEach(user -> System.out.println(user.getUserName()+ user.getCategory().getCategoryName()+"" +user.getUserDetail().getAddress()));
		
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
	@Test
	public void testFindUserDetail(){
//		BlogUser user = new BlogUser();
		try {
		BlogUserDetail userDetail = userDetailService.findUserDetail(1);
		System.out.println(userDetail.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
