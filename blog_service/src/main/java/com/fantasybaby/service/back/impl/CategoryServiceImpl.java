package com.fantasybaby.service.back.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybaby.service.back.ICategoryService;
import com.fantasybabymg.bean.Category;
import com.fantasybabymg.dao.ICategoryDao;
import com.fantasybabymg.util.GUIDUtil;
/**
 * 
 * @author FantasyBaby
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ICategoryDao categoryrDao;
	@Override
	public boolean addCategory(Category category){
		boolean isPass = false;
		try {
			if (category != null) {
				category.set_uuid(GUIDUtil.getUUid());
				categoryrDao.addCategory(category);
				isPass = true;
			}else{
				throw new Exception("null project");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isPass;
	}
}
