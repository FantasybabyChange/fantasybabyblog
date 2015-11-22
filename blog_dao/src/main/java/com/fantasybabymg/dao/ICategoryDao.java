package com.fantasybabymg.dao;

import com.fantasybabymg.bean.Category;

public interface ICategoryDao {
	public int addCategory(Category category);
	public int deleteCategory(int id);
	
}
