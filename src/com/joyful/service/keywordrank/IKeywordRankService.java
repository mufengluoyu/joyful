package com.joyful.service.keywordrank;

import java.util.Date;

import com.joyful.common.page.PageHelper.Page;
import com.joyful.entity.keywordrank.KeywordRankEntity;

public interface IKeywordRankService {
	
	public Page<KeywordRankEntity> findKeywordRankEntity(KeywordRankEntity record,Date sendDateStart,Date sendDateEnd,String orderByType,String pageNum,String pageSize);
	
	public int keywordRankInsert(KeywordRankEntity record);
}
