package test.states;

/**
 * @author : Chen
 * @fileName : test.states.EnumTest.java
 * 
 * @date: Aug 30, 2015 4:04:13 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class EnumTest {
	public static void main(String[] args) {
		System.out.println(OrderStatesEnum.ACCEPT_ORDER.ordinal() == 0);
		// System.out.println(OrderStatesEnum.ACCEPT_ORDER == 0);
		OrderStatesEnum i = OrderStatesEnum.CANCEL_ORDER;
		System.out.println(i);

	}
}
