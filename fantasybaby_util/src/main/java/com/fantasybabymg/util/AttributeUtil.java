package com.fantasybabymg.util;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.pattern.IntegerPatternConverter;
import org.dom4j.Attribute;
import org.dom4j.Element;

import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.util.constant.SpecialFieldNameConstant;
import com.fantasybabymg.util.constant.SpecialMethodNameConstant;

/**
 * use this class to set Attribute or
 * convert entity like VO -> Bean
 * @author FantasyBaby
 *
 */
public class AttributeUtil {
	private static Logger _log = Logger.getLogger(AttributeUtil.class);
	/**
	 *  copy value to another object but create uuid
	 * @param list
	 * @return
	 * @throws Exception
	 */
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
						Method getMethod = objectClass.getDeclaredMethod(StringUtil.getMethodName(SpecialMethodNameConstant.GET_METHOD_NAME, name), field.getType());
						Object returnValue = getMethod.invoke(object);
						Method setMethod = objectClass.getDeclaredMethod(StringUtil.getMethodName(SpecialMethodNameConstant.SET_METHOD_NAME, name),field.getType());
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
	public static Object convertStringType(String str,Type clas2){
		if(Integer.class.getTypeName().toString().equals(clas2.toString()) || "int".equals(clas2.toString())){
			return Integer.parseInt(str);
		}
		return str;
	}
	public static List<?> convertXMLtoList(Class<?> convertClass,File file,String parentElement,String unionObjectName) {
		Dom4JReaderHelper dom4J = new Dom4JReaderHelper();
		List<Object> list = new ArrayList<Object>();
		try {
			dom4J.initSAXReader(file);
			Element rootElement = dom4J.getParentElement(parentElement);
			if (rootElement != null) {
				Iterator<?> elementIterator = rootElement.elementIterator();
				while(elementIterator.hasNext()){
					Element element = (Element) elementIterator.next();
					Field[] declaredFields = convertClass.getDeclaredFields();
					if (CollectionUtil.isNotEmptyCollection(declaredFields)) {
						Object newInstance = convertClass.newInstance();
						for (Field field : declaredFields) {
							Attribute attribute = element.attribute(field.getName());
							if (attribute != null) {
								String name = field.getName();
								String value = attribute.getValue();
								Method setMethod = convertClass.getDeclaredMethod(StringUtil.getMethodName(SpecialMethodNameConstant.SET_METHOD_NAME, name), field.getType());
								setMethod.invoke(newInstance,convertStringType(value,field.getGenericType()));
							}
						}
						list.add(newInstance);
						Iterator<?> childElementIterator = element.elementIterator();
						while(childElementIterator.hasNext()){
							Element childElement = (Element) childElementIterator.next();
								Object childObject = convertClass.newInstance();
								for (Field field : declaredFields) {
									String name = field.getName();
									Attribute attribute = childElement.attribute(field.getName());
									if (attribute != null ||  name.equals(unionObjectName)) {
										Method setMethod = convertClass.getDeclaredMethod(StringUtil.getMethodName(SpecialMethodNameConstant.SET_METHOD_NAME, name), field.getType());
										if (name.equals(unionObjectName)) {
											setMethod.invoke(childObject,newInstance);
										}else{
											String value = attribute.getValue();
											setMethod.invoke(childObject,convertStringType(value,field.getGenericType()));
										}
									}
								}
								list.add(childObject);
						}
					}
					
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return list;
	}
	
	public static List<?> convertXMLtoList(Class<?> convertClass,String filePath,String parentElement,String unionObjectName) throws FantasyBabyException{
		return convertXMLtoList(convertClass, new File(filePath),parentElement, unionObjectName);
	}

}
