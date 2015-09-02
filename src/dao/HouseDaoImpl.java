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
	public boolean insertAHouse(HouseBean houseBean) {
		// TODO Auto-generated method stub
		// 获取数据库连接con，预编译语句对象prst，执行语句sql_new_house
		// 返回操作结果
		// boolean insert_a_house = false;
		int result = 0;
		Connection connection = DbTool.getConnection();
		String sql_new_house = "INSERT INTO House(`address`, `description`, `host_id`, `house_title`, `photo_path`, `price`) VALUES(?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement prst = connection.prepareStatement(sql_new_house);
			prst.setString(1, houseBean.getAddress());
			prst.setString(2, houseBean.getDescription());
			prst.setInt(3, houseBean.getHost_id());
			prst.setString(4, houseBean.getHouse_title());
			prst.setString(5, houseBean.getPhoto_path());
			prst.setInt(6, houseBean.getPrice());

			// execute insert sql
			result = prst.executeUpdate();
			System.out.println("insert_a_house:     " + result + "    "
					+ this.getClass().getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == 1) {
			return true;
		} else {
			return false;
		}
		// return insert_a_house;
	}

}
