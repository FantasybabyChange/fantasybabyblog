package com.fantasybabymg.service.back;

import java.util.List;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.exception.FantasyBabyException;

/**
 * 
 * @author FantasyBaby
 *
 */
public interface IUserService {
	public boolean addUser(BlogUser user)throws FantasyBabyException;
	public List<BlogUser> findUsers()throws FantasyBabyException;
	public boolean deleteUser(int id)throws FantasyBabyException;
}
