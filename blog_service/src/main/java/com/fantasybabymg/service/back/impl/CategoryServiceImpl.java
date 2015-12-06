package com.fantasybabymg.service.back.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybabymg.bean.Category;
import com.fantasybabymg.bean.CategoryPrivilege;
import com.fantasybabymg.dao.ICategoryDao;
import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.service.back.ICategoryService;
import com.fantasybabymg.util.AttributeUtil;
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
	private Logger _logger = Logger.getLogger(CategoryServiceImpl.class); 
	@Override
	public boolean addCategory(Category category)throws FantasyBabyException{
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
			throw new FantasyBabyException(e, CategoryServiceImpl.class);
		}
		return isPass;
	}
	@Override
	public java.util.List<Category> findCategory() throws FantasyBabyException {
		return categoryDao.findCategory();
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean batchAddCategoryPrivilge(List<CategoryPrivilege> categoryPrivileges)
			throws FantasyBabyException {
		boolean flag = false;
		//TODO need to add logic to judge the category
		_logger.info("start insert categoryPrivilge num:"+categoryPrivileges.size());
		try {
			List<CategoryPrivilege> setUUidBatch = (List<CategoryPrivilege>) AttributeUtil.setUUidBatch(categoryPrivileges);
			int resultCount = categoryDao.addCategoryPrivilege(setUUidBatch);
		_logger.info("end insert categoryPrivilge num:"+resultCount);
			flag = true;
		} catch (Exception e) {
			throw new FantasyBabyException(e, CategoryServiceImpl.class);
		}
		return flag;
	}
}
