package com.fantasybabymg.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.fantasybabymg.bean.Category;
import com.fantasybabymg.bean.CategoryPrivilege;
@Component("categoryDao")
public interface ICategoryDao {
	public int addCategory(Category category);
	public int deleteCategory(int id);
	public List<Category> findCategory();
	/**
	 * insert many to many
	 * @param categoryPrivilege
	 * @return
	 */
	public int addCategoryPrivilege(List<CategoryPrivilege> categoryPrivilege);
}
