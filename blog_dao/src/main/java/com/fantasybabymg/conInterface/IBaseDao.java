package com.fantasybabymg.conInterface;

import java.util.List;
import java.util.Map;

import com.fantasybabymg.page.Pager;

public interface IBaseDao<T> {
	public  void add(T t);
	public void delete(T t);
	
	public void update(T t);
	
	public T load(Class<T> cl,int id);
	/**
	 * 查询全部的
	 * @return
	 */
	public List<T> findAll(Class<T> cl);
	/**
	 * 拿到分页数据
	 * @param t
	 * @param map 
	 * @return
	 */
	public Pager<T> findPage(Class<T> cl,Map<String, Object> map);
	/**
	 * 找到分页个数
	 * @param t
	 * @param map
	 * @return
	 */
	public int  findPageCount(Class<T> cl,Map<String, Object> map);
}
