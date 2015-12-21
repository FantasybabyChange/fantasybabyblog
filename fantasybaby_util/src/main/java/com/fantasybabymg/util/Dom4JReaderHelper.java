package com.fantasybabymg.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.fantasybabymg.exception.FantasyBabyException;

/**
 * user the class to encapsulation dom4j
 * @author FantasyBaby
 *
 */
public class Dom4JReaderHelper {
	private SAXReader reader;
	private Document document;
	public Dom4JReaderHelper() {
		reader = new SAXReader();
	}
	public void initSAXReader(String filePath) throws DocumentException{
		if (StringUtil.isNotBleank(filePath)) {
			initSAXReader(new File(filePath));	
		}else{
			throw new FantasyBabyException("path url is null", Dom4JReaderHelper.class);
		}
	}
	public void initSAXReader(File file) throws DocumentException{
		document = reader.read(file);
	}
	/**
	 * find root parentsName
	 * @param rootName
	 * @return
	 */
	public Element getParentElement(String rootName){
		Element element = null;
		if (document != null) {
			Element rootElement = document.getRootElement();
			if (StringUtil.isNotBleank(rootName)) {
				element = rootElement.element(rootName);
			}else{
				element = rootElement;
			}
		}else{
			throw new FantasyBabyException("please init reader.The document is null", Dom4JReaderHelper.class);
		}
		return element;
	}
}
