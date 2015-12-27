package com.fantasybabymg.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.fantasybabymg.bean.Category;
@Component("categoryDao")
public interface ICategoryDao {
	public int addCategory(Category category);
	public int addBatchCategory(List<Category> category);
	public int deleteCategory(int id);
	public List<Category> findCategory();
}
