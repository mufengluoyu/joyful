package com.joyful.service.keywordrank.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyful.common.page.PageHelper;
import com.joyful.common.page.PageHelper.Page;
import com.joyful.common.util.StringUtil;
import com.joyful.dao.keywordrank.KeywordRankDao;
import com.joyful.entity.keywordrank.KeywordRankEntity;
import com.joyful.service.keywordrank.IKeywordRankService;

/** 
 * 关键字业务数据
 * @author hechangzhi 2016年8月4日09:49:51
 *
 */
@Transactional
@Service("keywordRankService")
public class KeywordRankServiceImpl implements IKeywordRankService{
	
	@Autowired
	private KeywordRankDao keywordRankDao;
	
	@SuppressWarnings("unchecked")
	public Page<KeywordRankEntity> findKeywordRankEntity(KeywordRankEntity record,Date sendDateStart,Date sendDateEnd,String orderByType,String pageNumStr,String pageSizeStr){
		int pageNum = 1;
		int pageSize = 10;
		if(StringUtil.isNotEmpty(pageNumStr)){
			pageNum = Integer.parseInt(pageNumStr);
		}
		if(StringUtil.isNotEmpty(pageSizeStr)){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		//启动分页，增加一个分页
		PageHelper.startPage(pageNum, pageSize);
		keywordRankDao.findKeywordRankEntity(record, sendDateStart, sendDateEnd, orderByType);
		return PageHelper.endPage();
		
	}
	
	/**
	 * 单条插入语句
	 */
	@Transactional(readOnly=false)
	public int keywordRankInsert(KeywordRankEntity record){
		return keywordRankDao.insert(record);
	}
	/**
	 * 批量插入
	 * @param record
	 * @return
	 */
	@Transactional(readOnly=false)
	public int keywordRankInserts(List<KeywordRankEntity> list){
//		//主要是防止大量数据库插入超时链接导致数据插入失败
//		int sumCount = 0;
//		for(int i = 0 ; i < (list.size()/2000) +1 ;i++){
//			if(list.size() % 2000 == 0 || i < list.size()/2000){
//				List<KeywordRankEntity> list1 = list.subList(i*2000, (i+1)*2000);
//				sumCount += keywordRankDao.insertAll(list1);
//			}else if(list.size() % 2000 != 0){
//				List<KeywordRankEntity> list1 = list.subList(i*2000, list.size());
//				sumCount += keywordRankDao.insertAll(list1);
//			}
//		}
//		return sumCount;
		return keywordRankDao.insertAll(list);
	}
	
}
