package service;

import java.util.List;

import dao.OrderDaoImpl;
import entity.OrderBean;

/**
 * @author : Chen
 * @fileName : service.OrderService.java
 * 
 * @date: Sep 8, 2015 10:53:42 AM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class OrderService {

	public void changeOrderState(OrderBean orderBean) {
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		orderDaoImpl.changeOrderState(orderBean);
	}

	public void newOrder(OrderBean orderBean) {
		// 生成订单，等待房东确认
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		orderDaoImpl.newOrder(orderBean);
	}

	public List<OrderBean> getAllOrder(String type, int id) {
		// 查询id下的所有订单， 用户类型在上一层调用者中已经分流了
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		List<OrderBean> orderList = orderDaoImpl.getAllOrder(type, id);

		return orderList;
	}
	// CHECKING_ORDER = 1; // 订单生成，待确认，审核中
	// ACCEPT_WAIT_PAY_ORDER = 2; // host接受订单，待付款
	// CANCEL_ORDER = 3; // 房客取消订单
	// REJECT_ORDER = 4; // 房东拒绝订单
	// WAIT_CHECKIN_ORDER = 5; // 房客已付款，待入住
	// LIVING_ORDER = 6; // 入住中
	// ACCOMPLISH_ORDER = 7; // 已完成

}
