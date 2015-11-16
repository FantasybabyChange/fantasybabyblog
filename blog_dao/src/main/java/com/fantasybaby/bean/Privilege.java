package com.fantasybaby.bean;

/**
 * 
 * @author FantasyBaby
 *
 */
public class Privilege implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8646567150287530772L;
	private String _uuid;
	private int pId;
	private String pName;
	private String pPath;
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
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpPath() {
		return pPath;
	}
	public void setpPath(String pPath) {
		this.pPath = pPath;
	}
}