package com.fantasybabymg.enumerate;
/**
 * user status
 * @author FantasyBaby
 *
 */
public enum UserStatusEnum {
	UPPERCASE(0),
	LOWERCASE(1);
	int value;
	UserStatusEnum(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
