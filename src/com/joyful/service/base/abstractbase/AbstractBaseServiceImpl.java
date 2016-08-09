package com.joyful.service.base.abstractbase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.joyful.common.page.PageHelper;
import com.joyful.common.page.PageHelper.Page;
import com.joyful.common.util.StringUtil;
import com.joyful.dao.base.BaseDao;
import com.joyful.service.base.BaseService;

public abstract class AbstractBaseServiceImpl<T> implements BaseService<T>{
	@Autowired
	public BaseDao<T> baseDao;
	
	public List<T> findList(T t){
		return baseDao.findList(t);
	}
	
	public Page<T> findPage(T t,String pageNumStr,String pageSizeStr){
		int pageNum = 1;
		int pageSize = 15;
		if(StringUtil.isNumeric(pageNumStr)){
			pageNum = Integer.parseInt(pageNumStr);
		}
		if(StringUtil.isNumeric(pageSizeStr)){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageHelper.startPage(pageNum, pageSize);
		baseDao.findList(t);
		return PageHelper.endPage();
		
	}
	
	public int insert(T t){
		return baseDao.insert(t);
	}
	
	public int insertAll(List<T> list){
		//主要是防止大量数据库插入超时链接导致数据插入失败
		if(list.size() > 10000){
			int sumCount = 0;
			for(int i = 0 ; i < (list.size()/10000) +1 ;i++){
				if(list.size() % 10000 == 0 || i < list.size()/10000){
					List<T> list1 = list.subList(i*10000, (i+1)*10000);
					sumCount += baseDao.insertAll(list1);
				}else if(list.size() % 10000 != 0){
					List<T> list1 = list.subList(i*10000, list.size());
					sumCount += baseDao.insertAll(list1);
				}
			}
			return sumCount;
		}else{
			return baseDao.insertAll(list);
		}
	}
	
	public int update(T t){
		return baseDao.update(t);
	}
}
