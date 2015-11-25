package com.fantasybabymg.dao;

import java.util.List;

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
	
	public List<BlogUserDetail> findUserDetailByUserId(int id);
}
