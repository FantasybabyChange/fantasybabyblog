package com.fantasybabymg.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fantasybabymg.bean.Privilege;
import com.fantasybabymg.service.back.IPrivilegeService;
public class PrivilegeTest {
	private IPrivilegeService PrivilegeService;
	@Before
	public void before(){
		PrivilegeService = (IPrivilegeService) new ClassPathXmlApplicationContext("classpath:spring-back-application.xml").getBean("privilegeService");
	}
	@Test
	public void testAddPrivilege(){
		Privilege privilege = new Privilege();
		privilege.setPName("插入");
		privilege.setPCode("insert");
		privilege.setPPath("/inser.do");
		try {
		PrivilegeService.addPrivilege(privilege);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testFindPrivilege(){
		try {
			List<Privilege> findPrivilege = PrivilegeService.findPrivilege();
			for (Privilege Privilege : findPrivilege) {
				System.out.println(Privilege.getPName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testDelPrivilege(){
		try {
			PrivilegeService.deletePrivilege(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
