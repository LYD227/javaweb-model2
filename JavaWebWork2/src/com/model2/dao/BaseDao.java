package com.model2.dao;

import java.util.List;

public interface BaseDao<T> {
	public boolean save(T t );
	// ����
	public boolean update(T t );	
	// ɾ��
	public boolean delete(T t );
	// ͨ��id��ѯ
	public T findById(java.io.Serializable id);
	//��ѯ����
	public List<T> findAll();
	/**
	 * ����������ѯ����
	 * @param condition ������� ��where֮�����䣩
	 * * ��ʽ�� and ���� �ؼ��� ? 
	 * * ���磺and name like ?
	 * @param params ����
	 */
	public List<T> findAll(String condition, Object ... params);	
	//��ѯ��ҳ����

}
