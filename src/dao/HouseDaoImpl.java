package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DbTool;
import entity.HouseBean;

/**
 * @author : Chen
 * @fileName : dao.HouseDaoImpl.java
 * 
 * @date: Sep 2, 2015 5:16:56 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class HouseDaoImpl implements HouseDao {

	@Override
	public boolean newHouse(HouseBean houseBean) {
		// TODO Auto-generated method stub
		// 获取数据库连接con，预编译语句对象prst，执行语句sql_new_house
		// 返回操作结果
		boolean new_house_ok = false;
		Connection connection = DbTool.getConnection();
		String sql_new_house = "insert into House(";
		try {
			PreparedStatement prst = connection.prepareStatement(sql_new_house);
			new_house_ok = prst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new_house_ok;
	}

}
