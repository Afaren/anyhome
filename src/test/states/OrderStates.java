package test.states;

/**
 * @author : Chen
 * @fileName : test.states.OrderStates.java
 * 
 * @date: Aug 30, 2015 3:19:04 PM
 * @user: Chen
 * @version:
 * @describe :用常量值描述订单状态 1. 待受理 --房客成功下订单 2. 已取消 --在待受理的状态下房客取消订单 3. 已受理
 *           --房东受理房客订单 4. 退订 --对受理后的订单退订 5. 已拒绝 --房东拒绝房客订单
 * 
 */
public class OrderStates {
	private static final int GENERATE_ORDER = 1;
	private static final int CANCEL_ORDER = 2;
	private static final int REVIEW_ORDER = 3;
	private static final int REJECT_ORDER = 4;
	private static final int ACCEPT_ORDER = 5;

}
