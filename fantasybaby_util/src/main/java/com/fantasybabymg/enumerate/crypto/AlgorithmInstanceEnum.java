package com.fantasybabymg.enumerate.crypto;

public enum AlgorithmInstanceEnum {
	AES("AES"),DES("DES"),MD5("MD5"),SHA_1("SHA-1");
	String value;
	private AlgorithmInstanceEnum(String value) {
	 this.value = value;
	}
	public String getValue(){
		return this.value;
	}
}
