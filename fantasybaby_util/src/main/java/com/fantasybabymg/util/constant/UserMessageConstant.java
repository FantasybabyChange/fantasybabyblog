package com.fantasybabymg.util.constant;

import com.fantasybabymg.util.PropertyUtil;

public class UserMessageConstant {
	static{
		PropertyUtil.initPeoperty(UserMessageConstant.class.getResource(ConfigurationFilePath.USER_MESSAGE_FILE_PATH).getPath());
	}
	public static final String PASSWORD_USERNAME_NOT_NULL = PropertyUtil.getPropertyVale("password_username_notempty");
	public static final String SESSIONID_NEED_REFRESH = PropertyUtil.getPropertyVale("sessionid_null_refresh");
}
