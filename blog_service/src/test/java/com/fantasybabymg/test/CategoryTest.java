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
import com.fantasybabymg.service.back.IPrivilegeService;
import com.fantasybabymg.util.AttributeUtil;
import com.fantasybabymg.util.PinYinUtil;
import com.github.stuxuhai.jpinyin.PinyinFormat;
public class CategoryTest {
	private ICategoryService categoryService;
	private IPrivilegeService PrivilegeService;
	@Before
	public void before(){
		categoryService = (ICategoryService) new ClassPathXmlApplicationContext("classpath:spring-back-application.xml").getBean("categoryService");
		PrivilegeService = (IPrivilegeService) new ClassPathXmlApplicationContext("classpath:spring-back-application.xml").getBean("privilegeService");
	}
	@Test
	public void testAddCategory(){
		List<Category> categories = categoryService.findCategory();
		Category category2 = null;
		if (categories != null && categories.size() > 0) {
			category2 = categories.get(1);
		}
		
		Category category = new Category();
		category.setCategoryName("管理员2");
		category.setCategoryCode(PinYinUtil.getFullPingYinWord(category.getCategoryName(), "", PinyinFormat.WITHOUT_TONE));
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
	/*@Test
	public void testAddUUID(){
		List<CategoryPrivilege> list = new ArrayList<CategoryPrivilege>();
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
		CategoryPrivilege a1 = new CategoryPrivilege();
		a1.setCategoryId(1234);
		a1.setPrivilegeId(3215);
		list.add(a);
		list.add(a1);
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
	}*/
	@Test
	public void testPinYin(){
		String p1 = PinYinUtil.getPingYinHeaderWord("刘曦");
		System.out.println(p1);
		String p2 = PinYinUtil.getPingYinHeaderWord("行");
		System.out.println(p2);
		String p3 = PinYinUtil.getFullPingYinWord("你好", "", PinyinFormat.WITHOUT_TONE);
		System.out.println(p3);
	}
	@Test
	public void testAddCategoryPrivilge(){
		List<CategoryPrivilege> list = new ArrayList<CategoryPrivilege>();
		List<Privilege> privilges = PrivilegeService.findPrivilege();
		List<Category> categorys = categoryService.findCategory();
		/*Privilege privilege = privilges.get(0);
		Category category = categorys.get(0);
		CategoryPrivilege cp = new CategoryPrivilege();
		cp.setPrivilege(privilege);
		cp.setCategory(category);
		Privilege privilege1 = privilges.get(1);
		Category category1 = categorys.get(2);
		CategoryPrivilege cp1 = new CategoryPrivilege();
		cp1.setPrivilege(privilege1);
		cp1.setCategory(category1);
		list.add(cp);
		list.add(cp1);*/
		Privilege privilege1 = privilges.get(0);
		Category category1 = categorys.get(1);
		CategoryPrivilege cp1 = new CategoryPrivilege();
		cp1.setPrivilege(privilege1);
		cp1.setCategory(category1);
		list.add(cp1);
		boolean batchAddCategoryPrivilge = categoryService.batchAddCategoryPrivilge(list);
	}
}
