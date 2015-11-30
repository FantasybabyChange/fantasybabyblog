package com.fantasybabymg.service.back.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.bean.BlogUserDetail;
import com.fantasybabymg.dao.IUserDao;
import com.fantasybabymg.dao.IUserDetailDao;
import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.service.back.IUserService;
import com.fantasybabymg.util.EncryptUtil;
import com.fantasybabymg.util.GUIDUtil;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IUserDetailDao userDetailDao;
	@Override
	public boolean addUser(BlogUser user) throws FantasyBabyException{
		boolean isPass =false;
			if (user != null) {
				user.set_uuid(GUIDUtil.getUUid());
				if (StringUtils.isNotBlank(user.getPassWord()) ) {
					user.setPassWord(EncryptUtil.encryptToMD5(user.getPassWord()));
				}else{
					throw new FantasyBabyException("空的密码",UserServiceImpl.class);
				}
				userDao.addUser(user);
				BlogUserDetail userDetail = user.getUserDetail();
				if (userDetail != null) {
					userDetail.set_uuid(GUIDUtil.getUUid());
					userDetail.setUser(user);
					userDetailDao.addUserDetail(userDetail);
				}
			}else{
				throw new FantasyBabyException("user is empty",UserServiceImpl.class);
			}
		return isPass;
	}
	@Override
	public List<BlogUser> findUsers(Map<String, String> criterion) {
		return userDao.findUserAllInformation(criterion);
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
