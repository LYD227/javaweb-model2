package com.model2.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model2.dao.UserDao;
import com.model2.util.JDBCUtilsPlus;

public class UserDaoImpl extends UserDao{

	@Override
	public boolean findUser(String name, String password) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		String userName = "";
		String userPassword = "";
		String sql ="select userName,userPassword from user"; 
		try {
			connection = JDBCUtilsPlus.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				userName = rs.getString("userName");
				userPassword = rs.getString("userPassword");
				if(name.equals(userName)&&password.equals(userPassword))
				{
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
