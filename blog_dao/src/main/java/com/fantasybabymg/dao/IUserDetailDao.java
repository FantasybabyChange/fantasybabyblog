package com.fantasybabymg.dao;

import org.springframework.stereotype.Component;

import com.fantasybabymg.bean.BlogUserDetail;
/**
 * 
 * @author FantasyBaby
 *
 */
@Component("userDetailDao")
public interface IUserDetailDao {
	public int addUserDetail(BlogUserDetail UserDetail);
	
	public int updateUserDetail(BlogUserDetail UserDetail);
	
	public int deleteUserDetail(int id);
	
	public BlogUserDetail findUserDetailByUserId(int id);
}
