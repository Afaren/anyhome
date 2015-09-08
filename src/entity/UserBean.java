package entity;

import java.io.Serializable;

/**
 * @author : Chen
 * @fileName : entity.UserBean.java
 * 
 * @date: Aug 30, 2015 5:45:54 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class UserBean implements Serializable {

	// user表设计时，有一些属性是为空的，所以这个bean可以不完全填充？
	private int user_id;
	private int user_type;
	private int account_id;
	private String username;
	private String password;
	private String gender;
	private String mail;
	private String phone;

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUser_type() {
		return user_type;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "UserBean [user_id=" + user_id + ", user_type=" + user_type
				+ ", account_id=" + account_id + ", username=" + username
				+ ", password=" + password + ", gender=" + gender + ", mail="
				+ mail + ", phone=" + phone + "]";
	}

}
