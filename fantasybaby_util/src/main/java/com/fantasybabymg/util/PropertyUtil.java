package com.fantasybabymg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.fantasybabymg.exception.FantasyBabyException;


/**
 * 
 * @author FantasyBaby
 *
 */
public  class PropertyUtil {
	private static Properties pro = null;
	private static InputStream input = null;
	private static Logger _loger = Logger.getLogger(Properties.class);
	public static void initPeoperty(String filePath){
		try {
			if(pro == null){
				pro = new Properties();
				input = new FileInputStream(new File(filePath));
				pro.load(input);
				_loger.info("log property file  input path="+filePath);
			}
		} catch (Exception e) {
			throw new FantasyBabyException(e, PropertyUtil.class);
		}
	}
	public static void initPeoperty(InputStream _input){
		try {
			if(pro == null){
				pro = new Properties();
				input = _input;
				pro.load(input);
			}
		} catch (Exception e) {
			throw new FantasyBabyException(e, PropertyUtil.class);
		}
	}
	public static String getPropertyVale(String key){
		if(pro != null){
			return pro.getProperty(key);
		}else{
			throw new FantasyBabyException("please init propertyUtil", PropertyUtil.class);
		}
	}
	public static void close(){
		if(pro != null){
			pro.clear();
		}
		try {
			if(input != null){
				input.close();
			}
		} catch (IOException e) {
			throw new FantasyBabyException(e, PropertyUtil.class);
		}
	}

}
