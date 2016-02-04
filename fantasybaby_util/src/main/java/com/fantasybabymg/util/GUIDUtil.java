package com.fantasybabymg.util;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class GUIDUtil 
{
	public static String getUUid(){
		return UUID.randomUUID().toString();
	}
}
