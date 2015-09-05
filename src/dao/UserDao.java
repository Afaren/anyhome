package dao;

import entity.UserBean;

/**
 * @author : Chen
 * @fileName : dao.UserDao.java
 * 
 * @date: Aug 30, 2015 5:45:13 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public interface UserDao {

	public void resetPwd(UserBean userBean, String newPassword);

	public boolean isCorrectPwd(UserBean userBean, String password);

	public boolean resetMailAndGender(int user_id, String mail, String gender);

	// public boolean updateMailGenderAccount_num(String mail, String gender,
	// String account_num);

	public boolean isValidUser(String username);

	public boolean insertUser(UserBean user);

	public boolean userExistsQueryByPhone(String phone);

	public UserBean queryByPhoneAndPassword(String phone, String password);
}
