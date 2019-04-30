package com.model2.dao;

import java.util.List;

public interface BaseDao<T> {
	public boolean save(T t );
	// 更新
	public boolean update(T t );	
	// 删除
	public boolean delete(T t );
	// 通过id查询
	public T findById(java.io.Serializable id);
	//查询所有
	public List<T> findAll();
	/**
	 * 带有条件查询所有
	 * @param condition 条件语句 （where之后的语句）
	 * * 格式： and 属性 关键字 ? 
	 * * 例如：and name like ?
	 * @param params 条件
	 */
	public List<T> findAll(String condition, Object ... params);	
	//查询分页数据

}
