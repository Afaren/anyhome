package entity;

/**
 * @author : Chen
 * @fileName : entity.OrderBean.java
 * 
 * @date: Sep 1, 2015 2:17:36 PM
 * @user: Chen
 * @version:
 * @describe : order javabean
 * 
 */

class OrderStates {
	// state属性应该设为public，否则不能使用类名直接访问
	public static final int CHECKING_ORDER = 1; // 订单生成，待确认，审核中
	public static final int ACCEPT_WAIT_PAY_ORDER = 2; // host接受订单，待付款
	public static final int CANCEL_ORDER = 3; // 房客取消订单
	public static final int REJECT_ORDER = 4; // 房东拒绝订单
	public static final int WAIT_CHECKIN_ORDER = 5; // 房客已付款，待入住
	public static final int LIVING_ORDER = 6; // 入住中
	public static final int ACCOMPLISH_ORDER = 7; // 已完成

}

public class OrderBean {
	private String order_num;// 订单编号
	private OrderStates states;
	private int total_price;
	private String start_time;
	private String end_time;
	private int user_id;
	private int host_id;

	public String getOrder_num() {
		return order_num;
	}

	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}

	public OrderStates getStates() {
		return states;
	}

	public void setStates(OrderStates states) {
		this.states = states;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getHost_id() {
		return host_id;
	}

	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}

	@Override
	public String toString() {
		return "OrderBean [order_num=" + order_num + ", states=" + states
				+ ", total_price=" + total_price + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", user_id=" + user_id
				+ ", host_id=" + host_id + "]";
	}

}
