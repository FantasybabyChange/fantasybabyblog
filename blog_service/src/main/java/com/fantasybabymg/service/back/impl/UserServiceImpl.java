package com.fantasybabymg.service.back.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.dao.IUserDao;
import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.service.back.IUserService;
import com.fantasybabymg.util.EncryptUtil;
import com.fantasybabymg.util.GUIDUtil;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Override
	public boolean addUser(BlogUser user) throws FantasyBabyException{
		boolean isPass =false;
		try {
			if (user != null) {
				user.set_uuid(GUIDUtil.getUUid());
				if (StringUtils.isNotBlank(user.getPassWord()) ) {
					user.setPassWord(EncryptUtil.encryptToMD5(user.getPassWord()));
				}else{
					throw new FantasyBabyException("空的密码",UserServiceImpl.class);
				}
				userDao.addUser(user);
			}else{
				throw new FantasyBabyException("user is empty",UserServiceImpl.class);
			}
		} catch (Exception e) {
			throw new FantasyBabyException(e.getMessage(), UserServiceImpl.class);
		}
		return isPass;
	}
	@Override
	public List<BlogUser> findUsers() {
		return userDao.findUser(null);
	}
	@Override
	public boolean deleteUser(int id) throws FantasyBabyException {
		boolean isPass = false;
		try {
			userDao.deleteUser(id);
			isPass = true;
		} catch (Exception e) {
			throw new FantasyBabyException(e,UserServiceImpl.class);
		}
		return isPass;
	}
}
