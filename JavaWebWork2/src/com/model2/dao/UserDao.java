package com.model2.dao;

public abstract class UserDao {
	protected abstract boolean findUser(String name,String password);
}
