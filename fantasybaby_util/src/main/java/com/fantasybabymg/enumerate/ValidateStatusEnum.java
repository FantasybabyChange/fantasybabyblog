package com.fantasybabymg.enumerate;
/**
 * user status
 * @author FantasyBaby
 *
 */
public enum ValidateStatusEnum {
	PASS(0),
	NOTPASS(1);
	int value;
	ValidateStatusEnum(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
