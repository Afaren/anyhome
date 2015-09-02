package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : Chen
 * @fileName : chen.friend.dbtool.DbTool.java
 * 
 * @date: Aug 6, 2015 11:35:30 AM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class DbTool {
	private static final String DB_NAME = "anyhome";// 数据库的名字
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String DB_USER = "root";
	private static final String DB_PWD = "chen";
	private static Connection connection = null;

	static {
		try {
			Class.forName(DB_DRIVER).newInstance();
			System.out.println("******************载入驱动程序");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub

		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);// 这条语句不能放在static代码块中

			if (connection != null) {
				System.out.println("获取数据库连接->DB:   " + DB_NAME);
			} else {
				System.out.println("无法获取数据库连接>DB:   " + DB_NAME);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void close(ResultSet rSet, PreparedStatement prst,
			Connection connection) {
		// TODO Auto-generated method stub
		closeResultSet(rSet);
		closePreparedStatement(prst);
		closeConnection(connection);
	}

	public static void close(PreparedStatement prst, Connection connection) {
		// TODO Auto-generated method stub
		closePreparedStatement(prst);
		closeConnection(connection);
	}

	private static void closeConnection(Connection connection) {
		// TODO Auto-generated method stub
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("关闭连接");

		}
	}

	private static void closePreparedStatement(PreparedStatement prst) {
		// TODO Auto-generated method stub
		if (prst != null) {
			try {
				prst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("关闭预编译语句");
		}

	}

	private static void closeResultSet(ResultSet rSet) {
		// TODO Auto-generated method stub
		if (rSet != null) {
			try {
				rSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("关闭结果集对象");

		}
	}

}
