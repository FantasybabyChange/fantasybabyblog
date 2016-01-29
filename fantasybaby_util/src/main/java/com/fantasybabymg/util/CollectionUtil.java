package com.fantasybabymg.util;

import java.util.List;

public class CollectionUtil {
	public static boolean isNotEmptyCollection(Object[] objs){
		return objs != null && objs.length > 0;
	}
	public static boolean isNotEmptyCollection(List<?> objs){
		return objs != null && objs.size() > 0;
	}
	
}
