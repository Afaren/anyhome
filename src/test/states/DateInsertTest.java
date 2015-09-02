package test.states;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author : Chen
 * @fileName : test.states.DateInsertTest.java
 * 
 * @date: Sep 1, 2015 10:42:48 AM
 * @user: Chen
 * @version:
 * @describe :�����в���ʱ�䣬�ֱ�Ϊ��ǰʱ���ָ��ʱ��
 * 
 */
public class DateInsertTest {
	public static void main(String[] args) throws SQLException {

		// ��ȡ���ݿ�����
		// Ԥ����������
		// sql��� ��Ϊ ָ����һ��ʱ�����
		// ִ��
		// �鿴

		String insert_datetest_record = "insert into datetest(`when`) values(?)";
		PreparedStatement prst = Date_DbTool.getConnection().prepareStatement(
				insert_datetest_record);
		// prst.prepareStatement(insert_datetest_record);
		// prst.setTimestamp(1, new Timestamp(System.currentTimeMillis()));

		prst.setString(1,
				new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss").format(new Date()));
		int execute = prst.executeUpdate();
		System.out.println("execure result   " + execute);

		// ��һ��������ָ����ʱ������ǵ�ǰʱ��
		// ���ȣ��ҵ�֪�����ָ��һ��ʱ��
		// Ȼ�󣬲�����Ǻܼ򵥵�һ������

		Scanner s = new Scanner(System.in);
		System.out.println("input a day: ");
		int day = s.nextInt();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, day);
		// Date d = c.getTime();
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		// Timestamp timestamp = (Timestamp) c.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");

		// Date date = new Date();
		// sdf.format(date);\

		// java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis());
		// sdf.format(date2);
		// System.out.println(date2.getTime());

		// java.sql.Timestamp timestamp = new Timestamp(date.getTime());
		// // System.out.println(sdf.format(timestamp));
		// System.out.println("timestamp:  " + timestamp);
		// // java.sql.Timestamp timestamp = new
		// // SimpleDateFormat("yyyy-MM-dd  hh:mm:ss").format(new Date(
		// // System.currentTimeMillis()).getTime();
		// //
		// // System.out.println("&&&&&&&&&&&&&&&&&&&&&&"
		// // + );
		// System.out.println("insert a designed day---------");
		// // prst.setTimestamp(1, sdf.format(timestamp));
		// // prst.setTimestamp(1, sdf.format(timestamp));
		//
		// // Scanner s=new Scanner(System.in);
		// // int day=s.nextInt();
		// // Calendar c=Calendar.getInstance();
		// // c.add(Calendar.DAY_OF_MONTH, day);
		// // Date d=c.getTime();
		// // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//
		// // System.out.println(sdf.format(d));
	}
}
