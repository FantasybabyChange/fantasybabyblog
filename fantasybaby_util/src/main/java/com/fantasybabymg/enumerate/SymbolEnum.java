package com.fantasybabymg.enumerate;

public enum SymbolEnum {
	/**
	 * \
	 */
   BACKSLASH('\\'),
   /**
    * "/"
    */
   SLASH('/');
   private char value;
	SymbolEnum(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}
}
