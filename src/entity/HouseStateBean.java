package entity;

import java.io.Serializable;

/**
 * @author : Chen
 * @fileName : entity.house_state.java
 * 
 * @date: Sep 1, 2015 10:17:11 AM
 * @user: Chen
 * @version:1.0
 * @describe : house_state
 * 
 */

class States implements Serializable {
	public static final int HOUSE_CREATED = 1;// 创建房屋
	public static final int HOUSE_REVIEWING = 2;// 审核中
	public static final int HOUSE_RELEASED = 3;// 成功发布房屋
	public static final int HOUSE_REJECT = 4;// 发布被拒绝
}

public class HouseStateBean implements Serializable {

	private String start_time;
	private String end_time;
	private States states;
	private int house_id;

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

	public States getStates() {
		return states;
	}

	public void setStates(States states) {
		this.states = states;
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	@Override
	public String toString() {
		return "HouseStateBean [start_time=" + start_time + ", end_time="
				+ end_time + ", states=" + states + ", house_id=" + house_id
				+ "]";
	}

}
