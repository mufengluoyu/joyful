package com.joyful.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joyful.common.page.PageHelper.Page;
import com.joyful.common.page.PageStrUtil;
import com.joyful.common.util.StringEscapeEditor;
import com.joyful.service.base.BaseService;

/**
 * controller公用层主要防止数据的注入攻击
 * @author seven
 *
 */
public abstract class BaseController<T> {	
	
	
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
	
	/**
	 * 返回
	 * @return
	 */
	public BaseService<T> getBaseService(){
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list" )  
	public String list(T t ,HttpServletRequest request,Model model){
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		Page<T> page = getBaseService().findPage(t, pageNum, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("pageStr", PageStrUtil.pageStr(page, ""));
		return getListJspStr();
	}
	
	public String getListJspStr(){
		return null;
	}
	public String getFormJspStr(){
		return null;
	}
}
