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

	boolean deleteUser(int user_id);

	void resetPwd(UserBean userBean, String newPassword);

	boolean isCorrectPwd(UserBean userBean, String password);

	boolean resetMailAndGender(int user_id, String mail, String gender);

	// public boolean updateMailGenderAccount_num(String mail, String gender,
	// String account_num);

	boolean isValidUser(String username);

	boolean insertUser(UserBean user);

	boolean userExistsQueryByPhone(String phone);

	UserBean queryByPhoneAndPassword(String phone, String password);
}
