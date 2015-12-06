package com.fantasybabymg.bean;

import java.util.Date;
import java.util.List;


/**
 * 
 * @author FantasyBaby
 *
 */
public class Category implements java.io.Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1997578557697679352L;
	private String _uuid;
	private int _id;
	private String categoryName;   
	private String categoryCode;
	private Category parentCategory;
	private Date createDate;
	private List<Privilege> privileges;
	public Category() {
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categorName) {
		this.categoryName = categorName;
	}
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	@Override
	public String toString() {
		return "Category [_uuid=" + _uuid + ", _id=" + _id + ", categoryName="
				+ categoryName + ", categoryCode=" + categoryCode
				+ ", parentCategory=" + parentCategory + ", createDate="
				+ createDate + ", privileges=" + privileges + "]";
	}
}