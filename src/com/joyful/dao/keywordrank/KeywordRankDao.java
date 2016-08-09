package com.joyful.dao.keywordrank;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.joyful.common.annotation.MyBatisDao;
import com.joyful.dao.base.BaseDao;
import com.joyful.entity.keywordrank.KeywordRankEntity;

@MyBatisDao
public interface KeywordRankDao extends BaseDao<KeywordRankEntity>{
	/**
	 * 插入表格当中 单条记录插入
	 * @param record
	 * @return
	 */
	int insert(KeywordRankEntity record);
	
	int deleteByPrimaryKey(String id);

    int insertSelective(KeywordRankEntity record);

    KeywordRankEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(KeywordRankEntity record);

    int updateByPrimaryKey(KeywordRankEntity record);
	/**
	 * 查出结果
	 * @param record
	 * @param sendDateStart
	 * @param sendDateEnd
	 * @param orderByType
	 * @return
	 */
	public List<KeywordRankEntity> findKeywordRankEntity(@Param(value="keywordRank")KeywordRankEntity record,@Param(value="sendDateStart")Date sendDateStart,@Param(value="sendDateEnd")Date sendDateEnd,@Param(value="orderByType")String orderByType);
	
	/**
	 * 批量插入功能
	 * @param list
	 * @return
	 */
	public int insertAll(List<KeywordRankEntity> list);
}
