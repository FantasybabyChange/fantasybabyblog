package com.fantasybabymg.ubean;

import java.util.List;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.bean.Category;
import com.fantasybabymg.bean.Privilege;
/**
 * the middle table use to connect category and privilege
 * @author FantasyBaby
 *
 */
public class CategoryPrivilegeT{
	private BlogUser blogUser;
    private List<Category> categorys;
    private List<Privilege> privileges;
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	public BlogUser getBlogUser() {
		return blogUser;
	}
	public void setBlogUser(BlogUser blogUser) {
		this.blogUser = blogUser;
	}
}
