package com.joyful.common.page;

import com.joyful.common.page.PageHelper.Page;

/**
 * 分页的语句产生分页的数据使用到的是（bootstrap）
 * @author hechangzhi	2016年8月4日09:48:47
 *
 */
public class PageStrUtil {
	/**
	 * 拼接分页的html显示以及时间的触发
	 * @param page				page对象
	 * @param funcParam			其他作为查询条件的值
	 * @return
	 */
	
	@SuppressWarnings("rawtypes")
	public static String pageStr(Page page,String funcParam){
		StringBuilder sb = new StringBuilder();
		String funcName = "page";		//前台界面必须的方法名
		int pageNo = page.getPageNum();		// 当前页码
		int first = 1;	// 首页索引
		int prev = page.getPageNum() -1;	//前一页
		int pageSize = page.getPageSize();	//页的条数
		int length = 8;// 显示页面长度
		int last = page.getPages();		//尾页
		int slider = 1;// 前后显示页面长度
		int next = page.getPageNum()+1;		//下一页
		long count = page.getTotal(); //总条数
		
		if (pageNo == first) {// 如果是首页
			sb.append("<li class=\"previous disabled\"><a href=\"javascript:\">&#171; 上一页</a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+prev+","+pageSize+",'"+funcParam+"');\">&#171; 上一页</a></li>\n");
		}

		int begin = pageNo - (length / 2);

		if (begin < first) {
			begin = first;
		}

		int end = begin + length - 1;

		if (end >= last) {
			end = last;
			begin = end - length + 1;
			if (begin < first) {
				begin = first;
			}
		}

		if (begin > first) {
			int i = 0;
			for (i = first; i < first + slider && i < begin; i++) {
				sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+",'"+funcParam+"');\">"
						+ (i + 1 - first) + "</a></li>\n");
			}
			if (i < begin) {
				sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
			}
		}

		for (int i = begin; i <= end; i++) {
			if (i == pageNo) {
				sb.append("<li class=\"active\"><a href=\"javascript:\">" + (i + 1 - first)
						+ "</a></li>\n");
			} else {
				sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+",'"+funcParam+"');\">"
						+ (i + 1 - first) + "</a></li>\n");
			}
		}

		if (last - end > slider) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
			end = last - slider;
		}

		for (int i = end + 1; i <= last; i++) {
			sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+",'"+funcParam+"');\">"
					+ (i + 1 - first) + "</a></li>\n");
		}

		if (pageNo == last) {
			sb.append("<li class=\"next disabled\"><a href=\"javascript:\">下一页 &#187;</a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+next+","+pageSize+",'"+funcParam+"');\">"
					+ "下一页 &#187;</a></li>\n");
		}
		if(count > pageNo*pageSize){
			sb.append("<li><a>当前  "+(prev*pageSize+1)+"  /  "+(pageNo*pageSize)+"  条，共 " + count + " 条</a></li>\n");
		}else{
			sb.append("<li><a>当前  "+(prev*pageSize+1)+"  /  "+count+"   条，共 " + count + " 条</a></li>\n");
		}
		
		return sb.toString();
	}
}
