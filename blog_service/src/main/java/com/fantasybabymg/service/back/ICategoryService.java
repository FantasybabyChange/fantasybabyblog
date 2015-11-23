package com.fantasybabymg.service.back;


import com.fantasybabymg.bean.Category;

/**
 * 
 * @author FantasyBaby
 *
 */
public interface ICategoryService {
	public boolean addCategory(Category category)throws Exception;
	public java.util.List<Category> findCategory()throws Exception;
}
