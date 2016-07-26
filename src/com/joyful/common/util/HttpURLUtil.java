package com.joyful.common.util;

import javax.servlet.http.HttpServletRequest;

public class HttpURLUtil {
	/**
	 * 返回一个baseUrl基础的url
	 * @param request
	 * @return
	 */
	public static String findRealBaseUrl(HttpServletRequest request){
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    	return basePath;
	}
}
