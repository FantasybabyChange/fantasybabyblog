package com.fantasybabymg.enumerate;
/**
 * user status
 * @author FantasyBaby
 *
 */
public enum UserStatusEnum {
	ACTIVATE(0),
	INACTIVATED(1);
	int value;
	UserStatusEnum(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
