package com.joyful.common.util;

/**
 * String字符串的部分字段的判断和更改
 * @author hechangzhi 2016年7月29日14:58:41
 *
 */
public class StringUtil {
	/**
	 * 判断字符串是否为null，“”，“ ”
	 * @param str
	 * @return
	 */
	public static Boolean isNotEmpty(String str){
		Boolean flag = true;
		if(str != null)
			str = str.trim();	//去掉首位的空格
		if(str == null || "".equals(str) ){
			flag = false;
		}
		return flag;
	}
	
	public static Boolean isEmpty(String str){
		Boolean flag = true;
		if(str != null ){
			str = str.trim();	//去掉首位的空格
			if(!"".equals(str)){
				flag = false;
			}
		}
		return flag;
	}
	
	public static void main(String[] arg){
		
	}
}
