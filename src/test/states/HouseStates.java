package test.states;

/**
 * @author : Chen
 * @fileName : test.states.HouseStates.java
 * 
 * @date: Aug 30, 2015 3:20:45 PM
 * @user: Chen
 * @version:
 * @describe : 用常量值描述房屋状态 1. 待审核 --房东成功创建房屋 2. 审核待发布 --房屋经过管理员审核通过 3. 已发布
 *           --房东发布已通过审核的房屋 4. 审核拒绝 --房屋未通过管理员审核
 * 
 */
public class HouseStates {

	// 参考订单状态常量表
	// private static final int GENERATE_ORDER = 1;
	// private static final int CANCEL_ORDER = 2;
	// private static final int REVIEW_ORDER = 3;
	// private static final int REJECT_ORDER = 4;
	// private static final int ACCEPT_ORDER = 5;

	private static final int HOUSE_CREATED_ = 0;
	private static final int HOUSE_REVIEWING = 1;
	private static final int HOUSE_RELEASED = 2;
	private static final int HOUSE_REJECT = 3;

}
