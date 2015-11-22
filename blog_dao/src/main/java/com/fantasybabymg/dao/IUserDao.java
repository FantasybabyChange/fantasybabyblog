package com.fantasybabymg.dao;

import com.fantasybabymg.bean.BlogUser;

public interface IUserDao {
	public int addUser(BlogUser user);
	public int deleteUser(int id);
	
}
