package com.fantasybabymg.util;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * 处理汉字到拼音
 * 使用jpinyin 
 * @author FantasyBaby
 *github https://github.com/FantasyBaby4Java/jpinyin
 */
public class PinYinUtil {
	public static String getPingYinHeaderWord(String chineseWord){
		return PinyinHelper.getShortPinyin(chineseWord);
	}
	
	public static String getFullPingYinWord(String chineseWord,String separation,PinyinFormat format){
		return PinyinHelper.convertToPinyinString(chineseWord,
						separation==null?"":separation,
						format == null?PinyinFormat.WITHOUT_TONE:format);
	}
}
