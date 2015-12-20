package com.fantasybabymg.bean;

/**
 * 
 * @author FantasyBaby
 *
 */
public class Privilege implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7108857935325256818L;
	private String _uuid;
	private int pId;
	private int order;
	private int isShow;
	private String pName;
	private String pCode;
	private String pPath;
	private Privilege parentPrivilege;
	public Privilege() {
	}
	public String get_uuid() {
		return _uuid;
	}
	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getPName() {
		return pName;
	}
	public void setPName(String pName) {
		this.pName = pName;
	}
	public String getPPath() {
		return pPath;
	}
	public void setPPath(String pPath) {
		this.pPath = pPath;
	}
	public String getPCode() {
		return pCode;
	}
	public void setPCode(String pCode) {
		this.pCode = pCode;
	}
	public Privilege getParentPrivilege() {
		return parentPrivilege;
	}
	public void setParentPrivilege(Privilege parentPrivilege) {
		this.parentPrivilege = parentPrivilege;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
}