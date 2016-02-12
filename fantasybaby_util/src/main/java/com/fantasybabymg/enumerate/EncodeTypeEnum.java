package com.fantasybabymg.enumerate;

public enum EncodeTypeEnum {
	UTF8("UTF-8");
	String value;
	private EncodeTypeEnum(String typeName) {
		this.value = typeName;
	}
	public String getValue(){
		return this.value;
	}
}
