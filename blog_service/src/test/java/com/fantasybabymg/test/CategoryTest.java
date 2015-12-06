package com.fantasybabymg.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fantasybabymg.bean.Category;
import com.fantasybabymg.bean.CategoryPrivilege;
import com.fantasybabymg.bean.Privilege;
import com.fantasybabymg.service.back.ICategoryService;
import com.fantasybabymg.util.AttributeUtil;
public class CategoryTest {
	private ICategoryService categoryService;
	@Before
	public void before(){
		categoryService = (ICategoryService) new ClassPathXmlApplicationContext("classpath:spring-back-application.xml").getBean("categoryService");
	}
	@Test
	public void testAddCategory(){
		Category category2 = categoryService.findCategory().get(0);
		Category category = new Category();
		category.setCategoryCode("gly1");
		category.setCategoryName("管理员1");
		category.setParentCategory(category2);
//		String str = "aad68f4a-e519-4f17s-8889-bb2f57257b99";
//		System.out.println(str.length());
		try {
		categoryService.addCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testFindCategory(){
		try {
			List<Category> findCategory = categoryService.findCategory();
			for (Category category : findCategory) {
				System.out.println(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testAddUUID(){
		List<Category> list = new ArrayList<Category>();
//		CategoryPrivilege a = new CategoryPrivilege();
		Category  a = new Category();
		a.setCategoryName("呵呵");
		a.setCreateDate(new Date());
		Category a2 = new Category();
		a2.setCategoryName("嘻嘻");
		a.setParentCategory(a2);
		List<Privilege> l2 = new ArrayList<Privilege>();
		Privilege p = new Privilege();
		p.setPName("权限");
		l2.add(p);
		a.setPrivileges(l2);
		/*CategoryPrivilege a1 = new CategoryPrivilege();
		a1.setCategoryId(1234);
		a1.setPrivilegeId(3215);
		list.add(a);
		list.add(a1);*/
		list.add(a);
		try {
			List<?> returnValues  = AttributeUtil.setUUidBatch(list);
			System.out.println("---------convert------");
			for (Object object : returnValues) {
				Category cp = (Category) object;
				System.out.println(cp.get_uuid());
				System.out.println(cp.getParentCategory().getCategoryName());
				List<Privilege> privileges = cp.getPrivileges();
				System.out.println(privileges.get(0).getPName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
