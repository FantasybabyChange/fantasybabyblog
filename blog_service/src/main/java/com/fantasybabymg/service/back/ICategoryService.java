package com.fantasybabymg.service.back;


import java.util.List;

import com.fantasybabymg.bean.Category;
import com.fantasybabymg.bean.CategoryPrivilege;
import com.fantasybabymg.exception.FantasyBabyException;

/**
 * 
 * @author FantasyBaby
 *
 */
public interface ICategoryService {
	public boolean addCategory(Category category)throws FantasyBabyException;
	public List<Category> findCategory()throws FantasyBabyException;
	//TODO
	public boolean batchAddCategoryPrivilge(List<CategoryPrivilege> categoryPrivileges)throws FantasyBabyException;
}
