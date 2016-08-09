package com.joyful.service.keywordrank;

import java.util.Date;
import java.util.List;

import com.joyful.common.page.PageHelper.Page;
import com.joyful.entity.keywordrank.KeywordRankEntity;
import com.joyful.service.base.BaseService;

public interface IKeywordRankService extends BaseService<KeywordRankEntity>{
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
	
	/**
	 * 批量插入数据
	 * @param list
	 * @return
	 */
	public int keywordRankInserts(List<KeywordRankEntity> list);
}
