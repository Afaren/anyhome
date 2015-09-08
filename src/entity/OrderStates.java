package entity;

import java.io.Serializable;

/**
 * @author : Chen
 * @fileName : entity.OrderStates.java
 * 
 * @date: Sep 8, 2015 10:10:32 AM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class OrderStates implements Serializable {
	// state属性应该设为public，否则不能使用类名直接访问
	public static final int SEARCH_ALL_ORDER = 0;// 查询所有订单
	public static final int CHECKING_ORDER = 1; // 订单生成，待确认，审核中
	public static final int ACCEPT_WAIT_PAY_ORDER = 2; // host接受订单，待付款
	public static final int CANCEL_ORDER = 3; // 房客取消订单
	public static final int REJECT_ORDER = 4; // 房东拒绝订单
	public static final int WAIT_CHECKIN_ORDER = 5; // 房客已付款，待入住
	public static final int LIVING_ORDER = 6; // 入住中
	public static final int ACCOMPLISH_ORDER = 7; // 已完成

}
