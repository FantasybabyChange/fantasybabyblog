package com.fantasybabymg.service.back.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.dao.IUserDao;
import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.service.back.IUserService;
import com.fantasybabymg.util.GUIDUtil;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Override
	public boolean addUser(BlogUser user) throws FantasyBabyException{
		try {
			if (user != null) {
				user.set_uuid(GUIDUtil.getUUid());
				userDao.addUser(user);
			}else{
				throw new FantasyBabyException("user is empty",UserServiceImpl.class);
			}
		} catch (Exception e) {
			throw new FantasyBabyException(e.getMessage(), UserServiceImpl.class);
		}
		return true;
	}
	@Override
	public List<BlogUser> findUsers() {
		return userDao.findUser(null);
	}
}
