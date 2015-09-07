package dao;

import java.util.List;

import entity.HouseBean;

/**
 * @author : Chen
 * @fileName : dao.HouseDao.java
 * 
 * @date: Sep 2, 2015 5:16:32 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public interface HouseDao {

	// public boolean newHouse(HouseBean houseBean);
	// 插入一条记录
	boolean insertAHouse(HouseBean houseBean);

	// 查找目标地点的house
	List<HouseBean> getTargetAddressHouses(String targetAddress);

	// 查找合适时段（该时段没被预订或入住）的房子，
	List<HouseBean> getTargetTimeHouses(String start_time, String end_time);

}
