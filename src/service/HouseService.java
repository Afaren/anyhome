package service;

import java.util.ArrayList;
import java.util.List;

import dao.HouseDaoImpl;
import entity.HouseBean;

/**
 * @author : Chen
 * @fileName : service.HouseService.java
 * 
 * @date: Sep 2, 2015 5:14:09 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class HouseService {

	public boolean releaseHouse(HouseBean houseBean) {
		// TODO Auto-generated method stub
		HouseDaoImpl houseDao = new HouseDaoImpl();
		if (houseDao.insertAHouse(houseBean)) {
			return true;
		}

		return false;
	}

	public List<HouseBean> getTargetHouse(String whereToG0, String start_time,
			String end_time) {
		// TODO Auto-generated method stub
		// 1. 获取目标地址下的house list
		// 2. 获取目标时间下的house list
		// 求交集， 涉及房屋状态的筛选，这里先不考虑

		List<HouseBean> targetAddressList = new ArrayList<HouseBean>();
		HouseDaoImpl houseDaoImpl = new HouseDaoImpl();
		targetAddressList = houseDaoImpl.getTargetAddressHouses(whereToG0);

		List<HouseBean> targetTimeList = new ArrayList<HouseBean>();
		targetTimeList = houseDaoImpl.getTargetTimeHouses(start_time, end_time);

		return targetAddressList; // 测试看是否能打印出图片
		// return null;
	}
}
