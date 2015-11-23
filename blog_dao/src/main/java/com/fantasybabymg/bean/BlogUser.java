package com.fantasybabymg.bean;

import java.util.Date;

/**
 * 
 * @author FantasyBaby
 *
 */
public class BlogUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7642916340949203212L;
	
	private String _uuid;
	private int _id;
	private String userName;
	private String passWord;
	private BlogUserDetail userDetail;
	private Category category;
	private Date createDate;
	private Date modifyDate;
	public BlogUser() {
	}
	public String get_uuid() {
		return _uuid;
	}
	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}
	public int get_id() {
		return _id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public BlogUserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(BlogUserDetail userDetail) {
		this.userDetail = userDetail;
	}
}