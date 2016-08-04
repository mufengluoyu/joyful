package com.joyful.common.base;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joyful.common.util.StringEscapeEditor;

/**
 * controller公用层主要防止数据的注入攻击
 * @author seven
 *
 */
public abstract class BaseController {	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false, false));
	}
	/**
	 * 添加Flash消息
	 * @param message
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		
		redirectAttributes.addFlashAttribute("message", sb.toString());
		
	}
}
