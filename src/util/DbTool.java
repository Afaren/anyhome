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
	private static final String DB_NAME = "anyhome";// ���ݿ������
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://127.0.0.1/" + DB_NAME;
	// private static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String DB_USER = "root";
	private static final String DB_PWD = "chen";
	private static Connection connection = null;

	static {
		try {
			Class.forName(DB_DRIVER).newInstance();
			System.out.println("******************������������");
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
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);// ������䲻�ܷ���static�������

			if (connection != null) {
				System.out.println("��ȡ���ݿ�����->DB:   " + DB_NAME);
			} else {
				System.out.println("�޷���ȡ���ݿ�����>DB:   " + DB_NAME);
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
			System.out.println("�ر�����");

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
			System.out.println("�ر�Ԥ�������");
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
			System.out.println("�رս��������");

		}
	}

}
