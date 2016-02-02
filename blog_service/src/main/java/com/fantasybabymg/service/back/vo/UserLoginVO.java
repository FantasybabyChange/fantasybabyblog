package com.fantasybabymg.service.back.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


public class UserLoginVO {
 
 @NotBlank(message="{password_username_notempty}")
 @Length(min=4,max=15,message="{username_maxlength}")
 private String username;
 @NotBlank(message="{password_username_notempty}")
 @Size(min=5,message="{password_minlength}")
 private String password;
 private int remember;
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
}
