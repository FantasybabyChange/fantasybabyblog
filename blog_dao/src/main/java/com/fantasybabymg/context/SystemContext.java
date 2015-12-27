package com.fantasybabymg.context;

import com.fantasybabymg.ubean.CategoryPrivilegeT;
import com.fantasybabymg.ubean.Criterion;

public class SystemContext {
	/**
	 * 一页显示的数量
	 */
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	/**
	 * 当前页
	 */
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	/**
	 * 升序 还是降序
	 * @param _pageOrder
	 */
	private static ThreadLocal<String> pageOrder = new ThreadLocal<String>();
	
	private static ThreadLocal<Criterion<Object>> criterionMap = new ThreadLocal<Criterion<Object>>();
	
	private static ThreadLocal<CategoryPrivilegeT> categoryPrivilege = new ThreadLocal<CategoryPrivilegeT>();
	public static void setPageSize(int _pageSize){
		pageSize.set(_pageSize);
	}
	public static Integer getPageSize(){
		return pageSize.get();
	}
	public static void removePageSize(){
		pageSize.remove(); 
	}
	public static void setPageIndex(int _pageIndex){
		pageIndex.set(_pageIndex);
	}
	
	public static Integer getPageIndex(){
		return pageIndex.get();
	}
	public static void removePageIndex(){
		pageIndex.remove(); 
	}
	
	public static void setPageOrder(String _pageOrder){
		pageOrder.set(_pageOrder);
	}
	
	public static String getPageOrder(){
		return pageOrder.get();
	}
	public static void removePageOrder(){
		pageOrder.remove(); 
	}
	
	public static void setCriterionMap(Criterion<Object> _criterionMap){
		criterionMap.set(_criterionMap);
	}
	public static Criterion<Object> getCriterionMap(){
		return criterionMap.get();
	}
	public static void removeCriterionMap(){
		criterionMap.remove(); 
	}
	//
	public static void setCategoryPrivilege(CategoryPrivilegeT _categoryPrivilege){
		categoryPrivilege.set(_categoryPrivilege);
	}
	public static CategoryPrivilegeT getCategoryPrivilege(){
		return categoryPrivilege.get();
	}
	public static void removeCategoryPrivilege(){
		categoryPrivilege.remove(); 
	}
	
}
