package main;

import java.sql.*;

public class DataSource {
	
	private static final String server = "jdbc:mysql://140.119.19.79/";
	private static final String database = "TG01";
	private static final String encoding = "?useUnicode=true&characterEncoding=utf8";
	private static final String username = "TG01";
	private static final String password = "tr95s4";
	
	public static Connection getConnection() throws SQLException {
		
		String url = server + database + encoding;
		return DriverManager.getConnection(url, username, password);
	}

}
