package com.fantasybabymg.service.back;


import java.util.List;

import com.fantasybabymg.bean.Privilege;
import com.fantasybabymg.exception.FantasyBabyException;

/**
 * 
 * @author FantasyBaby
 *
 */
public interface IPrivilegeService {
	public boolean addPrivilege(Privilege privilege)throws FantasyBabyException;
	
	public List<Privilege> findPrivilege()throws FantasyBabyException;
	
	public boolean deletePrivilege(int id)throws FantasyBabyException;
}
