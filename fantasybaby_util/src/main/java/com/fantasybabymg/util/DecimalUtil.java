package com.fantasybabymg.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;

import com.fantasybabymg.enumerate.DecimalEnum;


public class DecimalUtil {
	
	public static String parseMoney(String money,DecimalEnum decimalEnum){
		if(!StringUtils.isEmpty(money)){
			DecimalFormat decimalFormat = new DecimalFormat(decimalEnum.getValue());
			money = decimalFormat.format(new BigDecimal(money).longValue());
		}else{
			money = "0.000";
		}
		return money;
	}
	
	public static String parseFloat(String money,DecimalEnum decimalEnum){
		if(!StringUtils.isEmpty(money)){
			DecimalFormat decimalFormat = new DecimalFormat(decimalEnum.getValue());
			money = decimalFormat.format(new BigDecimal(money).divide(new BigDecimal(10)).longValue());
		}else{
			money = "0.0";
		}
		return money;
	}
	
}
