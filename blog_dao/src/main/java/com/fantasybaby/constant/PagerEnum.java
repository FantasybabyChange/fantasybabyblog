package com.fantasybaby.constant;

public enum PagerEnum {
	/**
	 * 千位分隔
	 */
	THOUSAND("#,###"),
	/**
	 * 小数
	 */
	FLOAT("0.0");

	public String value;

	PagerEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
