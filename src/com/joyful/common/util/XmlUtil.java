package com.joyful.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * xml转换
 * @author hechangzhi
 * @version 创建时间：2016年8月16日
 */
public class XmlUtil {
	
	/**
	 * 将map转换成xml   <xml> <key>value</key> </xml>
	 * @param map
	 * @return
	 */
	public static String mapToXml(Map<String,Object> map){
		StringBuffer str = new StringBuffer();
		Set<String> set = map.keySet();
		str.append("<xml>");
		for(Iterator<String> it = set.iterator(); it.hasNext();){
			String key = it.next();
			Object value = map.get(key);
			str.append("<"+key+">");
			str.append(value);
			str.append("</"+key+">");
		}
		str.append("</xml>");
		return str.toString();
	}
	
	/**
	 * 将xml转换成对应的bean
	 * @param xml
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xml,Class<T> clazz){
		Object obj = null;
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("xml", clazz);
		obj = xstream.fromXML(xml);
		return (T) obj;
	}
	
	/**
	 * 将xml转换成Map
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> dom2Map(Document doc){
		Map<String, Object> map = new HashMap<String, Object>();
		if(doc == null)
			return map;
		Element root = doc.getRootElement();
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			map.put(e.getName(), e.getText());
		}
		return map;
	}
	
	public static void main(String arg[]){
		
	}
	
}
