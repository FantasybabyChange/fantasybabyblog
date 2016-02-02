package com.fantasybabymg.util.constant;

import com.fantasybabymg.util.PropertyUtil;

public class UserMessageConstant {
	static{
//		PropertyUtil.initPeoperty(UserMessageConstant.class.getResource(ConfigurationFilePath.USER_MESSAGE_FILE_PATH).getPath());
		PropertyUtil.initPeoperty(UserMessageConstant.class.getClassLoader().getResourceAsStream(ConfigurationFilePath.USER_MESSAGE_FILE_PATH));
	}
	public static final String PASSWORD_USERNAME_NOT_NULL = PropertyUtil.getPropertyVale("password_username_notempty");
	public static final String SESSIONID_NEED_REFRESH = PropertyUtil.getPropertyVale("sessionid_null_refresh");
	public static final String RETURN_ERROR_KEY = PropertyUtil.getPropertyVale("user_return_key");
	public static final String USER_NOT_EXIST = PropertyUtil.getPropertyVale("user_not_exist");
	public static final String PASSWORD_NOT_RIGHT = PropertyUtil.getPropertyVale("password_not_right");
	public static final String CAPTCHA_NOT_RIGHT = PropertyUtil.getPropertyVale("captcha_not_right");
	public static final String UNKOWNERROR = PropertyUtil.getPropertyVale("unkownError");
	public static final String PAGE_EXPIRE = PropertyUtil.getPropertyVale("page_expire");
}
