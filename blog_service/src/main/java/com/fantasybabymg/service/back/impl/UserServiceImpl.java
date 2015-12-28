package com.fantasybabymg.service.back.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.bean.BlogUserDetail;
import com.fantasybabymg.bean.Category;
import com.fantasybabymg.bean.CategoryPrivilege;
import com.fantasybabymg.bean.Privilege;
import com.fantasybabymg.context.SystemContext;
import com.fantasybabymg.dao.ICategoryDao;
import com.fantasybabymg.dao.ICategoryPrivilegeDao;
import com.fantasybabymg.dao.IPrivilegeDao;
import com.fantasybabymg.dao.IUserDao;
import com.fantasybabymg.dao.IUserDetailDao;
import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.service.back.IUserService;
import com.fantasybabymg.ubean.CategoryPrivilegeT;
import com.fantasybabymg.ubean.Criterion;
import com.fantasybabymg.util.AttributeUtil;
import com.fantasybabymg.util.CollectionUtil;
import com.fantasybabymg.util.EncryptUtil;
import com.fantasybabymg.util.GUIDUtil;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IUserDetailDao userDetailDao;
	@Autowired
	private ICategoryDao categoryDao;
	@Autowired
	private IPrivilegeDao privilegeDao;
	@Autowired
	private ICategoryPrivilegeDao categoryPrivilegeDao;
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
	@SuppressWarnings("unchecked")
	@Override
	public List<BlogUser> findUsers() {
		Criterion<Object> criterionMap = SystemContext.getCriterionMap();
		Object criterion = criterionMap.getCriterion();
		List<BlogUser> users = null;
		if (criterion instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) criterion;
			users = userDao.findUserAllInformation(map);
		}
		return users;
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
	@SuppressWarnings("unchecked")
	@Override
	public boolean batchInitUserCategoryPrivilege() throws FantasyBabyException {
		CategoryPrivilegeT categoryPrivilege = SystemContext.getCategoryPrivilege();
		boolean flag = false;
		List<Category> categorys = categoryPrivilege.getCategorys();
		List<Privilege> privileges = categoryPrivilege.getPrivileges();
		BlogUser blogUser = categoryPrivilege.getBlogUser();
		try {
			categorys = (List<Category>) AttributeUtil.setUUidBatch(categorys);
			privileges = (List<Privilege>) AttributeUtil.setUUidBatch(privileges);
			if (CollectionUtil.isNotEmptyCollection(categorys)){
				List<CategoryPrivilege> categoryPrivileges = new ArrayList<CategoryPrivilege>();
				for (Category category : categorys) {
					if(category.getParentCategory() != null){
						for (Privilege privilege : privileges) {
							CategoryPrivilege cp = new CategoryPrivilege();
							cp.setPrivilege(privilege);
							cp.setCategory(category);
							cp.set_uuid(GUIDUtil.getUUid());
							categoryPrivileges.add(cp);
						}
					}
				}
				categoryPrivilegeDao.addCategoryPrivilege(categoryPrivileges);
			}
			categoryDao.addBatchCategory(categorys);
			privilegeDao.addPrivilegesBatch(privileges);
			flag = true;
		} catch (Exception e) {
			throw new FantasyBabyException(e, CategoryServiceImpl.class);
		}finally{
			categorys.clear();
			privileges.clear();
		}
		return flag;
	}
}
