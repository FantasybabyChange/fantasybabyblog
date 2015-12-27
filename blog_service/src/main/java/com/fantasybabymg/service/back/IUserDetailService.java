package com.fantasybabymg.service.back;

import com.fantasybabymg.bean.BlogUserDetail;
import com.fantasybabymg.exception.FantasyBabyException;

/**
 * 
 * @author FantasyBaby
 *
 */
public interface IUserDetailService {
	public boolean addUserDetail(BlogUserDetail userDetail)throws FantasyBabyException;
	
	public BlogUserDetail findUserDetail(int userid)throws FantasyBabyException;
	
	public boolean deleteUserDetail(int id)throws FantasyBabyException;
}
