package com.joyful.common.util;


import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 防止注入攻击
 * @author hechangzhi 2016年8月4日14:21:18
 *
 */
public class StringEscapeEditor extends PropertyEditorSupport {

	private boolean escapeHTML;

	private boolean escapeJavaScript;

	private boolean escapeXml;

	public StringEscapeEditor() { 
		super(); 
	}

	public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript, boolean escapeXml) {
		super();	
		this.escapeHTML = escapeHTML;
		this.escapeJavaScript = escapeJavaScript;
		this.escapeXml = escapeXml;

	}

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		} else {
			String value = text;
			if (escapeHTML) { 
				value = StringEscapeUtils.escapeHtml4(value); 
			}
			if (escapeJavaScript) {
				value = StringEscapeUtils.escapeEcmaScript(value); 
			}
			if (escapeXml) { 
				value = StringEscapeUtils.escapeXml(value); 
			} 
			setValue(value); 
		}
	}
	public String getAsText(){
		Object value = getValue(); 
		return value != null ? value.toString():""; 
	}

}