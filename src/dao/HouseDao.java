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
	// ����һ����¼
	boolean insertAHouse(HouseBean houseBean);

	// ����Ŀ��ص��house
	List<HouseBean> getTargetAddressHouses(String targetAddress);

	// ���Һ���ʱ�Σ���ʱ��û��Ԥ������ס���ķ��ӣ�
	List<HouseBean> getTargetTimeHouses(String start_time, String end_time);

}
