package com.joyful.service.base;

import java.util.List;

import com.joyful.common.page.PageHelper.Page;

public interface BaseService<T> {
	/**
	 * 返回结果集
	 * @param t
	 * @return
	 */
	public List<T> findList(T t);
	
	/**
	 * 返回分页
	 * @param t
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Page findPage(T t,String pageNum,String pageSize);
	
	/**
	 * 插入
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
	 * 修改
	 * @param t
	 * @return
	 */
	public int update(T t);
}
