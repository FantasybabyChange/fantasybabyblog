package com.fantasybabymg.bean;

import java.io.Serializable;
/**
 * the middle table use to connect category and privilege
 * @author FantasyBaby
 *
 */
public class CategoryPrivilege implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9203940062156561759L;
	private String _uuid;
    private int categoryId;
    private int privilegeId;
	public String get_uuid() {
		return _uuid;
	}

	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}
}
