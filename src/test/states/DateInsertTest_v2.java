package test.states;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Chen
 * @fileName : test.states.DateInsertTest_v2.java
 * 
 * @date: Sep 1, 2015 1:21:20 PM
 * @user: Chen
 * @version:
 * @describe :继续时间插入，只尝试是否可以打印出格式化的指定日期
 * 
 */
public class DateInsertTest_v2 {
	public static void main(String[] args) throws SQLException {

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd  hh:mm:ss");
		Date date = new Date();

		System.out.println(dateFormat.format(date));

		Connection connection = Date_DbTool.getConnection();
		String sql_getTimeStamp_string = "select * from datetest";
		PreparedStatement prst = connection
				.prepareStatement(sql_getTimeStamp_string);

		ResultSet rSet = prst.executeQuery();
		while (rSet.next()) {
			System.out.println(rSet.getInt(1) + " " + rSet.getString("when"));
		}

		String sql_insertByString = "insert into datetest(`when`) values(?)";
		PreparedStatement prst_2 = connection
				.prepareStatement(sql_insertByString);
		prst_2.setString(1, "2015-12-12  12:12:12");
		int result = prst_2.executeUpdate();
		System.out.println("插入result  " + result);

	}
}
