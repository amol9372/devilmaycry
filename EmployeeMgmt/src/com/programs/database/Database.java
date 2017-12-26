package com.programs.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import programs.examples.init.ConfigInititalizer;

public class Database 
{	
	private static BasicDataSource ds = null;
	
	private static void initDataSource(ConfigInititalizer config){
		ds = new BasicDataSource();
		ds.setDriverClassName(config.getProperty("DRIVER_NAME"));
		ds.setUrl(config.getProperty("URL"));
		ds.setUsername(config.getProperty("USERNAME"));
		ds.setPassword(config.getProperty("PASSWORD"));
		ds.setMinIdle(Integer.parseInt(config.getProperty("MIN_IDLE")));
		ds.setMaxIdle(Integer.parseInt(config.getProperty("MAX_IDLE")));
		ds.setMaxTotal(Integer.parseInt(config.getProperty("MAX_TOTAL")));
		ds.setMaxWaitMillis(Integer.parseInt(config
				.getProperty("MAX_WAIT_MILLISECONDS")));
	}
	
	public static Connection getConnection(ConfigInititalizer config) throws SQLException {
		if (ds == null) {
			initDataSource(config);
		}
		return ds.getConnection();
	}
	
}
