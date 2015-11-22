package com.fantasybaby.service.back.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybaby.service.back.IUserService;
import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.dao.IUserDao;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Override
	public boolean addUser(BlogUser user){
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}
}
