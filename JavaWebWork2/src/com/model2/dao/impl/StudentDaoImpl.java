package com.model2.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model2.dao.BaseDao;
import com.model2.pojo.Student;
import com.model2.util.JDBCUtilsPlus;

public class StudentDaoImpl implements BaseDao<Student>{
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	@Override
	public boolean save(Student t) {
		String sql ="insert into student(stuName,major,gender,birthday) "
				+ "values(?,?,?,?)";
		try {
			connection = JDBCUtilsPlus.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, t.getStuName());
			stmt.setString(2, t.getMajor());
			stmt.setString(3, t.getGender());
			stmt.setString(4, t.getBirthday());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtilsPlus.colseResource(connection, stmt, null);
		}
		return false;
	}

	@Override
	public boolean update(Student t) {
		String sql ="update student set stuName=?,major=?,gender=?,birthday=?"
				+ "where stuId=?";
		try {
			connection = JDBCUtilsPlus.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, t.getStuName());
			stmt.setString(2, t.getMajor());
			stmt.setString(3, t.getGender());
			stmt.setString(4, t.getBirthday());
			stmt.setInt(5, t.getStuId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtilsPlus.colseResource(connection, stmt, null);
		}
		return false;
	}


	@Override
	public boolean delete(Student t) {
		String sql ="delete from student where stuId=?";
		try {
			connection = JDBCUtilsPlus.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, t.getStuId());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtilsPlus.colseResource(connection, stmt, null);
		}
		return false;
	}

	@Override
	public Student findById(Serializable id) {
		String sql ="select * from student where stuId = ?";
		try {
			connection = JDBCUtilsPlus.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, (int) id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setStuName(rs.getString(2));
				stu.setMajor(rs.getString("major"));
				stu.setGender(rs.getString("gender"));
				stu.setBirthday(rs.getString("birthday"));
				return stu;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtilsPlus.colseResource(connection, stmt, rs);
		}
		return null;
	}

	@Override
	public List<Student> findAll() {
		String sql ="select * from student";
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JDBCUtilsPlus.getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setStuId(rs.getInt(1));
				stu.setStuName(rs.getString(2));
				stu.setMajor(rs.getString("major"));
				stu.setGender(rs.getString("gender"));
				stu.setBirthday(rs.getString("birthday"));
				list.add(stu);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtilsPlus.colseResource(connection, stmt, rs);
		}
		return null;
	}

	@Override
	public List<Student> findAll(String condition, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
