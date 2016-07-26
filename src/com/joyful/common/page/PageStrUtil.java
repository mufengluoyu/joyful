package com.joyful.common.page;

import com.joyful.common.page.PageHelper.Page;

public class PageStrUtil {
	/**
	 * 拼接分页的html显示以及时间的触发
	 * @param page				page对象
	 * @param funcParam			其他作为查询条件的值
	 * @return
	 */
	public static String pageStr(Page page,String funcParam){
		StringBuffer str = new StringBuffer();
		String fucName = "page";
		int prev = page.getPageNum() -1;
		int next = page.getPageNum() + 1;
		if(page.getPages() == 1 || page.getPageNum() == 1){
			str.append(" <li class=\"previous disabled\"><a href=\"javascript:\">&laquo;</a></li>");
		}else{
			
			str.append(" <li><a href=\"javascript:\" onclick=\""+fucName+"("+prev+","+page.getPageSize()+",'"+funcParam+"');\">&laquo;</a></li>");
		}
		if(page.getPages() > 8){
			
		}else{
			for(int i = 1 ; i <= page.getPages();i++){
				str.append(" <li><a href=\"javascript:\" onclick=\""+fucName+"("+i+","+page.getPageSize()+",'"+funcParam+"');\">"+i+"</a></li>");
			}
		}
		if(page.getPages() == 1 || page.getPageNum() == page.getPages()){
			str.append(" <li class=\"next disabled\"><a href=\"javascript:\">&raquo;</a></li>");
		}else{
			str.append(" <li class=\"next\"><a href=\"javascript:\" onclick=\""+fucName+"("+next+","+page.getPageSize()+",'"+funcParam+"');\">&raquo;</a></li>");
		}
		return str.toString();
	}
}
