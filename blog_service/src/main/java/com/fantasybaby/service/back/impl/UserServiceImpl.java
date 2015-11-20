package com.fantasybaby.service.back.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybaby.bean.BlogUser;
import com.fantasybaby.dao.IUserDao;
import com.fantasybaby.service.back.IUserService;
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
