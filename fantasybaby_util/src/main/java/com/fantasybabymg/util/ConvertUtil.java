package com.fantasybabymg.util;

import com.fantasybabymg.exception.FantasyBabyException;

public class ConvertUtil {
	
	/**
	 * 字符串转换整型
	 */
	public static int stringToInteger(String param) throws FantasyBabyException{
		return Integer.parseInt(param);
	}
	
	/**
	 * 整型转换字符
	 */
	public static String integerToString(Integer param) throws FantasyBabyException{
		return String.valueOf(param);
	}
	
	/**
	 * LONG转换整型
	 */
	public static int longToInteger(long param) throws FantasyBabyException{
		return Integer.parseInt(String.valueOf(param));
	}
}
