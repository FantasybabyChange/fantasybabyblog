package com.fantasybabymg.service.back.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybabymg.bean.BlogUserDetail;
import com.fantasybabymg.dao.IUserDetailDao;
import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.service.back.IUserDetailService;
import com.fantasybabymg.util.GUIDUtil;
@Service("userDetailService")
public class UserDetailServiceImpl implements IUserDetailService{
	@Autowired
	private IUserDetailDao UserDetailDao;
	@Override
	public boolean addUserDetail(BlogUserDetail UserDetail) throws FantasyBabyException{
		boolean isPass =false;
		if (UserDetail != null) {
			UserDetail.set_uuid(GUIDUtil.getUUid());
			UserDetailDao.addUserDetail(UserDetail);
		}else{
			throw new FantasyBabyException("UserDetail is empty",UserDetailServiceImpl.class);
		}
		return isPass;
	}
	@Override
	public BlogUserDetail findUserDetail(int userid) {
		return UserDetailDao.findUserDetailByUserId(userid);
	}
	@Override
	public boolean deleteUserDetail(int id) throws FantasyBabyException {
		boolean isPass = false;
		try {
			UserDetailDao.deleteUserDetail(id);
			isPass = true;
		} catch (Exception e) {
			throw new FantasyBabyException(e,UserDetailServiceImpl.class);
		}
		return isPass;
	}
}
