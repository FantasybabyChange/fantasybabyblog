package com.fantasybabymg.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.fantasybabymg.bean.CategoryPrivilege;
@Component("categoryPrivilegeDao")
public interface ICategoryPrivilegeDao {
	/**
	 * insert many to many
	 * @param categoryPrivilege
	 * @return
	 */
	public int addCategoryPrivilege(List<CategoryPrivilege> categoryPrivilege);
}
