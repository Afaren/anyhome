package service;

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
		if (houseDao.newHouse(houseBean)) {
			return true;
		}

		return false;
	}

}
