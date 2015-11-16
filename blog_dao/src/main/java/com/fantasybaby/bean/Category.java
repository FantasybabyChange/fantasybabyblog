package com.fantasybaby.bean;

import java.util.Date;


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
	private String categorName;   
	private CategoryType categorytype;
	private Date createDate;
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
	public String getCategorName() {
		return categorName;
	}
	public void setCategorName(String categorName) {
		this.categorName = categorName;
	}
	public CategoryType getCategorytype() {
		return categorytype;
	}
	public void setCategorytype(CategoryType categorytype) {
		this.categorytype = categorytype;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}