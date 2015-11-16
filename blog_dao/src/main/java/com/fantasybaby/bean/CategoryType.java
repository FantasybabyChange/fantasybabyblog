package com.fantasybaby.bean;

import java.util.Date;


/**
 * 
 * @author FantasyBaby
 *
 */
public class CategoryType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5979827852260906605L;
	private String _uuid;
	private int _id;
	private String typeName;
	private Date createDate;
	public CategoryType() {
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}