package dao;

import java.util.List;

import entity.OrderBean;

/**
 * @author : Chen
 * @fileName : dao.OrderDao.java
 * 
 * @date: Sep 8, 2015 10:57:05 AM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public interface OrderDao {

	boolean newOrder(OrderBean orderBean);

	boolean changeOrderState(OrderBean orderBean);

	List<OrderBean> getAllOrder(String type, int id);// id表示用户id，统指host跟user
}
