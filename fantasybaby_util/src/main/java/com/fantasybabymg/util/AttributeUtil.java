package com.fantasybabymg.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.fantasybabymg.enumerate.CharTypeEnum;
import com.fantasybabymg.util.constant.SpecialFieldNameConstant;
import com.fantasybabymg.util.constant.SpecialMethodNameConstant;

/**
 * use this class to set Attribute or
 * convert entity like VO -> Bean
 * @author FantasyBaby
 *
 */
public class AttributeUtil {
	public static List<?> setUUidBatch(List<?> list) throws Exception{
		List<Object> newList = null;
		if (list != null && list.size() > 0) {
			newList = new ArrayList<Object>(); 
			for (Object object : list) {
				Class<? extends Object> objectClass = object.getClass();
				Object newObject = object.getClass().newInstance();
				Field[] declaredFields = objectClass.getDeclaredFields();
				for (Field field : declaredFields) {
					String name = field.getName();
					try {
						Method getMethod = objectClass.getDeclaredMethod(SpecialMethodNameConstant.GET_METHOD_NAME+StringUtil.upperOrLowerFirstChar(CharTypeEnum.UPPERCASE.getValue(), name));
						System.out.println(SpecialMethodNameConstant.GET_METHOD_NAME+StringUtil.upperOrLowerFirstChar(CharTypeEnum.UPPERCASE.getValue(), name));
						Object returnValue = getMethod.invoke(object);
						Method setMethod = objectClass.getDeclaredMethod(SpecialMethodNameConstant.SET_METHOD_NAME+StringUtil.upperOrLowerFirstChar(CharTypeEnum.UPPERCASE.getValue(), name),field.getType());
						if (SpecialFieldNameConstant.UUID_FIELD_NAME.equals(name)) {
							if (returnValue == null) {
								setMethod.invoke(newObject, GUIDUtil.getUUid());
							}
						}else{
							setMethod.invoke(newObject, returnValue);
						}
					} catch (Exception e) {
					}
				}
				newList.add(newObject);
			}
		}
		return newList;
	}

}
