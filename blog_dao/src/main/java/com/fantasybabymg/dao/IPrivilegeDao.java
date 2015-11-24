package com.fantasybabymg.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.fantasybabymg.bean.Privilege;
@Component("privilegeDao")
public interface IPrivilegeDao {
	public int addPrivilege(Privilege Privilege);
	
	public int deletePrivilege(int id);
	
	public List<Privilege> findPrivilege();
	
}
