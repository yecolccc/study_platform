package com.yecol.study.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0工具类
 * @author yecol
 *
 */ 
public class C3P0Uitls {
	
	//日志记录器
	static Logger logger = Logger.getLogger(C3P0Uitls.class);
	
	private static DataSource ds  = new ComboPooledDataSource();
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			logger.error("取得连接时发生了错误" + e.getMessage());
			throw new RuntimeException("取得连接时发生了错误");
		}
	}
	
	public static void closeAll(Connection conn,Statement statement,ResultSet resultSet){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			resultSet = null;
		}
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			statement = null;
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				conn = null;
			}
		}
	}

}
