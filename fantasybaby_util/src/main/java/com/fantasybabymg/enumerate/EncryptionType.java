package com.fantasybabymg.enumerate;

public enum EncryptionType {
	ENCRYP(0),
	DECRP(1);
	int value;
	private EncryptionType(int typeName) {
		this.value = typeName;
	}
	public int getValue(){
		return this.value;
	}
}
