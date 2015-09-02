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
	private static final int GENERATE_ORDER = 1;
	private static final int CANCEL_ORDER = 2;
	private static final int REVIEW_ORDER = 3;
	private static final int REJECT_ORDER = 4;
	private static final int ACCEPT_ORDER = 5;

}

public class OrderBean {
	private String order_num;// ¶©µ¥±àºÅ
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

}
