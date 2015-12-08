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
    private Category category;
    private Privilege privilege;
	public String get_uuid() {
		return _uuid;
	}

	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
}
