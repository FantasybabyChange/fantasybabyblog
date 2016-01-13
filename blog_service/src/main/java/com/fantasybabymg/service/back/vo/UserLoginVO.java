package com.fantasybabymg.service.back.vo;

public class UserLoginVO {
 private String username;
 private String password;
 private int remember;
 private String sessionid;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getRemember() {
	return remember;
}
public void setRemember(int remember) {
	this.remember = remember;
}
public String getSessionid() {
	return sessionid;
}
public void setSessionid(String sessionid) {
	this.sessionid = sessionid;
}
 
 
}
