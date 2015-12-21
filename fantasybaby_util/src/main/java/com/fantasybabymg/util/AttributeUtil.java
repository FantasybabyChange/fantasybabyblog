package com.fantasybabymg.util;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;

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
						Method getMethod = objectClass.getDeclaredMethod(SpecialMethodNameConstant.GET_METHOD_NAME+StringUtil.upperOrLowerFirstChar(CharTypeEnum.UPPERCASE.getValue(), name));
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
	public static List<?> convertXMLtoList(Class<?> convertClass,File file,String parentElement){
		Dom4JReaderHelper dom4J = new Dom4JReaderHelper();
		try {
			dom4J.initSAXReader(file);
			Element rootElement = dom4J.getParentElement(parentElement);
			if (rootElement != null) {
				Iterator<?> elementIterator = rootElement.elementIterator();
				while(elementIterator.hasNext()){
					Node node = (Node) elementIterator.next();
					System.out.println(node.getName());
				}
			}
		} catch (DocumentException e) {
			_log.error(e);
		}
		return null;
	}
	
	public static List<?> convertXMLtoList(Class<?> convertClass,String filePath,String parentElement){
		return convertXMLtoList(convertClass, new File(filePath),parentElement);
	}

}
