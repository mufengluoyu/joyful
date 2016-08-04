package com.joyful.service.keywordrank;

import java.util.Date;

import com.joyful.common.page.PageHelper.Page;
import com.joyful.entity.keywordrank.KeywordRankEntity;

public interface IKeywordRankService {
	/**
	 * 查询所有结果
	 * @param record
	 * @param sendDateStart
	 * @param sendDateEnd
	 * @param orderByType
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page<KeywordRankEntity> findKeywordRankEntity(KeywordRankEntity record,Date sendDateStart,Date sendDateEnd,String orderByType,String pageNum,String pageSize);
	
	/**
	 * 插入
	 * @param record
	 * @return
	 */
	public int keywordRankInsert(KeywordRankEntity record);
}
