/*package com.fantasybabymg.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fantasybabymg.bean.Category;
import com.fantasybabymg.service.back.ICategoryService;
public class CategoryTest {
	private ICategoryService categoryService;
	@Before
	public void before(){
		categoryService = (ICategoryService) new ClassPathXmlApplicationContext("classpath:spring-back-application.xml").getBean("categoryService");
	}
	@Test
	public void testAddCategory(){
		Category category = new Category();
		category.setCategoryName("管理员");
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
				System.out.println(category.getCategoryName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
*/