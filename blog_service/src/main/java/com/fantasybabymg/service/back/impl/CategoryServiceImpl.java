package com.fantasybabymg.service.back.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybabymg.bean.Category;
import com.fantasybabymg.dao.ICategoryDao;
import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.service.back.ICategoryService;
import com.fantasybabymg.util.GUIDUtil;
/**
 * 
 * @author FantasyBaby
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ICategoryDao categoryDao;
	@Override
	public boolean addCategory(Category category)throws Exception{
		boolean isPass = false;
		try {
			if (category != null) {
				category.set_uuid(GUIDUtil.getUUid());
				categoryDao.addCategory(category);
				isPass = true;
			}else{
				throw new FantasyBabyException("category is null",CategoryServiceImpl.class);
			}
		} catch (Exception e) {
		}
		return isPass;
	}
	@Override
	public java.util.List<Category> findCategory() throws Exception {
		return categoryDao.findCategory();
	}
}
