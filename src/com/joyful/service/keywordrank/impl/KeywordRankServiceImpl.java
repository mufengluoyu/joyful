package com.joyful.service.keywordrank.impl;

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
import com.joyful.entity.keywordrank.orderTypeEnum;
import com.joyful.entity.user.UserEntity;
import com.joyful.service.keywordrank.IKeywordRankService;

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
		PageHelper.startPage(pageNum, pageSize);
		keywordRankDao.findKeywordRankEntity(record, sendDateStart, sendDateEnd, orderByType);
		return PageHelper.endPage();
		
	}
	
	public int keywordRankInsert(KeywordRankEntity record){
		return keywordRankDao.insert(record);
	}
}
