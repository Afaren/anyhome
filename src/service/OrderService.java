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
		// ���ɶ������ȴ�����ȷ��
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		orderDaoImpl.newOrder(orderBean);
	}

	public List<OrderBean> getAllOrder(String type, int id) {
		// ��ѯid�µ����ж����� �û���������һ����������Ѿ�������
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		List<OrderBean> orderList = orderDaoImpl.getAllOrder(type, id);

		return orderList;
	}
	// CHECKING_ORDER = 1; // �������ɣ���ȷ�ϣ������
	// ACCEPT_WAIT_PAY_ORDER = 2; // host���ܶ�����������
	// CANCEL_ORDER = 3; // ����ȡ������
	// REJECT_ORDER = 4; // �����ܾ�����
	// WAIT_CHECKIN_ORDER = 5; // �����Ѹ������ס
	// LIVING_ORDER = 6; // ��ס��
	// ACCOMPLISH_ORDER = 7; // �����

}
