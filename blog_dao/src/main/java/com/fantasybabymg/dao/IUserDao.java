package com.fantasybabymg.dao;

import java.util.List;
import java.util.Map;

import com.fantasybabymg.bean.BlogUser;

public interface IUserDao {
	public int addUser(BlogUser user);
	public int deleteUser(int id);
	public List<BlogUser> findUserAllInformation(Map<String, Object> criterion);
	public BlogUser findUser(Map<String, Object> criterion);
	
}
