package com.fantasybabymg.enumerate.crypto;

public enum EncryptionTypeEnum {
	ENCRYP(0),
	DECRP(1);
	int value;
	private EncryptionTypeEnum(int typeName) {
		this.value = typeName;
	}
	public int getValue(){
		return this.value;
	}
}
