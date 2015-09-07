package entity;

/**
 * @author : Chen
 * @fileName : entity.AccountBean.java
 * 
 * @date: Sep 1, 2015 2:23:19 PM
 * @user: Chen
 * @version:
 * @describe : states 1. 支付 2. 收取退款 3. 收款 4. 房东退款
 * 
 */
class AccountStates {
	public static final int PAY = 1;
	public static final int RECEIVE_REFUND = 2;
	public static final int RECEIVE = 3;
	public static final int HOST_REFUND = 4;
}

public class AccountBean {

	private String account_num;
	private String password;
	private int balance;
	private String trade_time;
	private AccountStates state;

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getTrade_time() {
		return trade_time;
	}

	public void setTrade_time(String trade_time) {
		this.trade_time = trade_time;
	}

	public AccountStates getState() {
		return state;
	}

	public void setState(AccountStates state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AccountBean [account_num=" + account_num + ", password="
				+ password + ", balance=" + balance + ", trade_time="
				+ trade_time + ", state=" + state + "]";
	}
}
