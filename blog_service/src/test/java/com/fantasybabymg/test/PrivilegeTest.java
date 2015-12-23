package com.fantasybabymg.test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fantasybabymg.bean.Category;
import com.fantasybabymg.bean.Privilege;
import com.fantasybabymg.service.back.IPrivilegeService;
import com.fantasybabymg.util.AttributeUtil;
import com.fantasybabymg.util.PinYinUtil;
import com.fantasybabymg.util.constant.ConfigurationFilePath;
import com.fantasybabymg.util.constant.XMLNodeNameConstant;
public class PrivilegeTest {
	private IPrivilegeService PrivilegeService;
	@Before
	public void before(){
		PrivilegeService = (IPrivilegeService) new ClassPathXmlApplicationContext("classpath:spring-back-application.xml").getBean("privilegeService");
	}
	@Test
	public void testAddPrivilege(){
		List<Privilege> categories = PrivilegeService.findPrivilege();
		Privilege privilege2 = null;
		if (categories != null && categories.size() > 0) {
			privilege2 = categories.get(0);
		}
		Privilege privilege = new Privilege();
		privilege.setPName("插入1");
		privilege.setPCode(PinYinUtil.getFullPingYinWord(privilege.getPName(), null,null));
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
	@SuppressWarnings("unchecked")
	@Test
	public void parseXMLToPrivilege(){
		String filePath = PrivilegeTest.class.getClassLoader().getResource(ConfigurationFilePath.INITDB_XML_FILE_PATH).getPath();
		List<Privilege> convertXMLtoList = (List<Privilege>) AttributeUtil.convertXMLtoList(Privilege.class,filePath , XMLNodeNameConstant.PRIVILEGE_ROOT_ELEMENT_NAME);
		for (Privilege privilege : convertXMLtoList) {
			System.out.println(privilege);
		}
		
		
	}
}
