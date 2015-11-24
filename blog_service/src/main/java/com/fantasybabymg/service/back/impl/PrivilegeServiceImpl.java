package com.fantasybabymg.service.back.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasybabymg.bean.Privilege;
import com.fantasybabymg.dao.IPrivilegeDao;
import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.service.back.IPrivilegeService;
import com.fantasybabymg.util.GUIDUtil;
/**
 * 
 * @author FantasyBaby
 *
 */
@Service("privilegeService")
public class PrivilegeServiceImpl implements IPrivilegeService {
	@Autowired
	private IPrivilegeDao privilegeDao;
	@Override
	public boolean addPrivilege(Privilege privilege)throws FantasyBabyException{
		boolean isPass = false;
		try {
			if (privilege != null) {
				privilege.set_uuid(GUIDUtil.getUUid());
				privilegeDao.addPrivilege(privilege);
				isPass = true;
			}else{
				throw new FantasyBabyException("Privilege is null",PrivilegeServiceImpl.class);
			}
		} catch (Exception e) {
			throw new FantasyBabyException(e , PrivilegeServiceImpl.class);
		}
		return isPass;
	}
	@Override
	public List<Privilege> findPrivilege() throws FantasyBabyException {
		return privilegeDao.findPrivilege();
	}
	@Override
	public boolean deletePrivilege(int id) throws FantasyBabyException {
		boolean isPass = false;
		try {
			privilegeDao.deletePrivilege(id);
			isPass = true;
		} catch (Exception e) {
			throw new FantasyBabyException(e, PrivilegeServiceImpl.class);
		}
		return isPass;
	}
}
