package com.fantasybabymg.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

import com.fantasybabymg.exception.FantasyBabyException;


public class StringUtil {
	
	public static String cut(String str,int length){
		if(!StringUtils.isEmpty(str)){
			if(str.length()>length){
				str = "<span title=\""+str+"\">"+str.substring(0, length)+"......</span>";
			}
		}
		return str;
	}
	
	/** 
	 * 计算采用utf-8编码方式时字符串所占字节数  UTF8汉字占3个字节
	 * @param content 
	 * @return 
	 */  
	public static int getByteSize(String content) throws Exception{  
	    int size = 0;  
	    if (null != content) {  
	        try {  
	            // 汉字采用utf-8编码时占3个字节  
	            size = content.getBytes("utf-8").length;  
	        } catch (UnsupportedEncodingException e) {  
	        	throw  new FantasyBabyException(e.getMessage(),StringUtil.class);
	            
	        }  
	    }  
	    return size;  
	}  
	
}
