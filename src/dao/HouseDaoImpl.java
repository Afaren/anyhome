package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.DbTool;
import dao.HouseDao;
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
		// 锟斤拷取锟斤拷锟捷匡拷锟斤拷锟斤拷con锟斤拷预锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷prst锟斤拷执锟斤拷锟斤拷锟絪ql_new_house
		// 锟斤拷锟截诧拷锟斤拷锟斤拷锟�
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

	@Override
	public List<HouseBean> getTargetAddressHouses(String targetAddress) {
		List<HouseBean> targetHouseList = new ArrayList<HouseBean>();
		Connection connection = DbTool.getConnection();
		PreparedStatement prst = null;
		ResultSet rSet = null;
		String sql_queryTargetHouse = "SELECT * FROM anyhome.house WHERE address LIKE ?";
		try {
			prst = connection.prepareStatement(sql_queryTargetHouse);
			prst.setString(1, "%" + targetAddress + "%");// 模锟斤拷锟斤拷询
			// prst.setString(1, targetAddress);
			rSet = prst.executeQuery();
			if (rSet.next()) {
				System.out.println("鏈夌鍚堢殑鎴垮瓙");
			} else {
				System.out.println("娌℃湁绗﹀悎鏉′欢鐨勬埧瀛�");
			}
			System.out.println("鏌ヨ绗﹀悎鐨勬埧瀛愬湴鍧�" + targetAddress);
			while (rSet.next()) {
				System.out.println("琛ㄧず瀛樺湪绗﹀悎鐨勬埧瀛�");
				HouseBean houseBean = new HouseBean();
				houseBean.setAddress(rSet.getString("address"));
				houseBean.setDescription(rSet.getString("description"));
				houseBean.setHost_id(rSet.getInt("host_id"));
				houseBean.setHouse_id(rSet.getInt("house_id"));
				houseBean.setHouse_title(rSet.getString("house_title"));
				houseBean.setNote(rSet.getString("note"));
				houseBean.setPhoto_path(rSet.getString("photo_path"));
				houseBean.setPrice(rSet.getInt("price"));
				System.out.println(houseBean);
				targetHouseList.add(houseBean);
			}
			System.out.println("鏌ヨ瀹屾瘯");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return targetHouseList;
	}

	@Override
	public List<HouseBean> getTargetTimeHouses(String start_time,
			String end_time) {

		// 锟斤拷锟斤拷锟芥及锟斤拷锟斤拷状态锟侥变化锟斤拷锟斤拷锟斤拷时锟斤拷蔚锟斤拷卸锟�
		return null;
	}

	public static void main(String[] args) {
		List<HouseBean> list = new HouseDaoImpl()
				.getTargetAddressHouses("锟斤拷锟斤拷");

		Iterator<HouseBean> iterator = list.iterator();
		for (HouseBean houseBean : list) {
			System.out.println(houseBean.toString());
		}
	}
}
