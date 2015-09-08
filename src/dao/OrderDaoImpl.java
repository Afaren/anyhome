package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbTool;
import entity.OrderBean;
import entity.OrderStates;

/**
 * @author : Chen
 * @fileName : dao.OrderDaoImpl.java
 * 
 * @date: Sep 8, 2015 11:08:16 AM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class OrderDaoImpl implements OrderDao {
	// CHECKING_ORDER = 1; // 订单生成，待确认，审核中
	// ACCEPT_WAIT_PAY_ORDER = 2; // host接受订单，待付款
	// CANCEL_ORDER = 3; // 房客取消订单
	// REJECT_ORDER = 4; // 房东拒绝订单
	// WAIT_CHECKIN_ORDER = 5; // 房客已付款，待入住
	// LIVING_ORDER = 6; // 入住中
	// ACCOMPLISH_ORDER = 7; // 已完成

	@Override
	public boolean changeOrderState(OrderBean orderBean) {
		int result = 0;
		Connection connection = DbTool.getConnection();
		PreparedStatement prst = null;
		String sql_orderOp = "UPDATE anyhome.order SET states = ? WHERE order_id = ?";
		try {
			prst = connection.prepareStatement(sql_orderOp);
			prst.setInt(1, orderBean.getStates());
			prst.setInt(2, orderBean.getOrder_id());
			result = prst.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean newOrder(OrderBean orderBean) {
		int result = 0;
		Connection connection = DbTool.getConnection();
		PreparedStatement prst = null;

		System.out.println(orderBean);
		String sql_insertOneOrder = "INSERT INTO anyhome.order(states, order_num, host_id, user_id, start_time, end_time, total_price) VALUES(?, ?, ?, ?, ?, ?, ?)";
		// 生成订单——在数据库中插入一条记录
		try {
			prst = connection.prepareStatement(sql_insertOneOrder);
			prst.setInt(1, OrderStates.CHECKING_ORDER);// 设置订单状态为新建，等待审核
			prst.setString(2,
					orderBean.getUser_id() + "_" + System.currentTimeMillis());// 生成订单编号
			prst.setInt(3, orderBean.getHost_id());
			prst.setInt(4, orderBean.getUser_id());
			prst.setString(5, orderBean.getStart_time());
			prst.setString(6, orderBean.getEnd_time());
			prst.setInt(7, orderBean.getTotal_price());

			result = prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DbTool.close(prst, connection);
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<OrderBean> getAllOrder(String type, int id) {
		// TODO Auto-generated method stub
		List<OrderBean> orderList = new ArrayList<OrderBean>();
		Connection connection = DbTool.getConnection();
		PreparedStatement prst = null;
		String sql_query_orders_by_id = null;
		ResultSet rSet = null;
		if (type.equals("host")) {
			// orderList = getAllOrderOfHost(id);
			sql_query_orders_by_id = "SELECT * FROM anyhome.order WHERE host_id = ?";
		} else {
			// orderList = getAllOrderOfUser(id);
			sql_query_orders_by_id = "SELECT * FROM anyhome.order WHERE user_id = ?";
		}
		try {
			prst = connection.prepareStatement(sql_query_orders_by_id);
			prst.setInt(1, id);
			rSet = prst.executeQuery();

			while (rSet.next()) {
				OrderBean orderBean = new OrderBean();
				orderBean.setEnd_time(rSet.getString("end_time"));// 这里有数据类型的变化，暂且定为string，要是出了问题再做修改
				orderBean.setHost_id(rSet.getInt("host_id"));
				orderBean.setOrder_id(rSet.getInt("order_id"));
				orderBean.setOrder_num(rSet.getString("order_num"));
				orderBean.setStart_time(rSet.getString("start_time"));// 这里有数据类型的变化，暂且定为string，要是出了问题再做修改
				orderBean.setStates(rSet.getInt("states"));
				orderBean.setTotal_price(rSet.getInt("total_price"));
				orderBean.setUser_id(rSet.getInt("user_id"));
				orderList.add(orderBean);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}
		return orderList;
	}
}
