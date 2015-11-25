package com.fantasybabymg.bean;

/**
 * 
 * @author FantasyBaby
 *
 */
public class BlogUserDetail implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8701504054911733833L;
	private String _uuid;
	private String name;
	private String nickname;
	private int sex;
	private String phone;
	private String email;
	private String address;
	private String hometown;
	private String profession;
	private String image;
	private BlogUser user;
	public BlogUserDetail() {
	}
	public String get_uuid() {
		return _uuid;
	}
	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public BlogUser getUser() {
		return user;
	}
	public void setUser(BlogUser user) {
		this.user = user;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}