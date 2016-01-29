package com.fantasybabymg.enumerate;

public enum CharTypeEnum {
	UPPERCASE(0),
	LOWERCASE(1);
	int value;
	CharTypeEnum(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
