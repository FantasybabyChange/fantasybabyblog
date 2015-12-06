package com.fantasybabymg.test;

import java.util.ArrayList;
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
		Privilege privilege2 = PrivilegeService.findPrivilege().get(0);
		Privilege privilege = new Privilege();
		privilege.setPName("插入");
		privilege.setPCode("insert2");
		privilege.setPPath("/inser.do");
		privilege.setParentPrivilege(privilege2);
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
	@Test
	public void testInserBatchPrivilege(){
		Privilege privilege = new Privilege();
		privilege.setPName("插入");
		privilege.setPCode("insert");
		privilege.setPPath("/inser.do");
		Privilege privilege1 = new Privilege();
		privilege1.setPName("删除");
		privilege1.setPCode("del");
		privilege1.setPPath("/del.do");
		Privilege privilege2 = new Privilege();
		privilege2.setPName("更新");
		privilege2.setPCode("update");
		privilege2.setPPath("/update.do");
		privilege2.setParentPrivilege(privilege1);
		List<Privilege> list = new ArrayList<Privilege>();
		list.add(privilege);
		list.add(privilege1);
		list.add(privilege2);
		try {
		PrivilegeService.addPrivilegesBatch(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
