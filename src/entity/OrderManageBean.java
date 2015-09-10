package entity;

/**
 * @author : Chen
 * @fileName : entity.OrderManageBean.java
 * 
 * @date: Sep 10, 2015 12:06:07 AM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class OrderManageBean {
	private String phone;
	private String house_title;
	private String start_time;
	private String end_time;
	private int total_price;
	private int state;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHouse_title() {
		return house_title;
	}

	public void setHouse_title(String house_title) {
		this.house_title = house_title;
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

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "OrderManageBean [phone=" + phone + ", house_title="
				+ house_title + ", start_time=" + start_time + ", end_time="
				+ end_time + ", total_price=" + total_price + ", state="
				+ state + "]";
	}
}
