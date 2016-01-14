package com.fantasybabymg.service.back.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UserLoginVO {
 
 @NotBlank
 @Size(max=10)
 private String username;
 @NotBlank
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
