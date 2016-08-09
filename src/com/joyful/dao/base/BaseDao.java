package com.joyful.dao.base;

import java.util.List;

public interface BaseDao<T> {
	
	/**
	 * 单条插入
	 * @param t
	 * @return
	 */
	public int insert(T t);
	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	public int insertAll(List<T> list);
	
	/**
	 * 查询数据集
	 * @param t
	 * @return
	 */
	public List<T> findList(T t);
	
	/**
	 * 修改所有数据
	 * @param t
	 * @return
	 */
	public int update(T t);

}
