package com.model2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtilsPlus {
	 private static final String DRIVER;
	    private static final String URL;
	    private static final String USER;
	    private static final String PASSWORD;
	    
	    private JDBCUtilsPlus(){}
	    
	    static {
	        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	        
	        DRIVER = bundle.getString("driver");
	        URL = bundle.getString("url");
	        USER = bundle.getString("user");
	        PASSWORD = bundle.getString("password");
	        
	        /**
	         * ����ע��
	         */
	        try {
	            Class.forName(DRIVER);
	        } catch (ClassNotFoundException e) {
	            throw new ExceptionInInitializerError(e);
	        }
	    }
	    
	    /**
	     * ��ȡ Connetion
	     * @return
	     * @throws SQLException
	     */
	    public static Connection getConnection() throws SQLException{
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	    
	    /**
	     * �ͷ���Դ
	     * @param conn
	     * @param st
	     * @param rs
	     */
	    public static void colseResource(Connection conn,Statement st,ResultSet rs) {
	        closeResultSet(rs);
	        closeStatement(st);
	        closeConnection(conn);
	    }
	    
	    /**
	     * �ͷ����� Connection
	     * @param conn
	     */
	    public static void closeConnection(Connection conn) {
	        if(conn !=null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        //�ȴ���������
	        conn = null;
	    }
	    
	    /**
	     * �ͷ����ִ���� Statement
	     * @param st
	     */
	    public static void closeStatement(Statement st) {
	        if(st !=null) {
	            try {
	                st.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        //�ȴ���������
	        st = null;
	    }
	    
	    /**
	     * �ͷŽ���� ResultSet
	     * @param rs
	     */
	    public static void closeResultSet(ResultSet rs) {
	        if(rs !=null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        //�ȴ���������
	        rs = null;
	    }
}
