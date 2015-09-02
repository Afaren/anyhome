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

	public boolean isValidUser(String username);

	public boolean insertUser(UserBean user);

	public boolean userExistsQueryByPhone(String phone);

	public UserBean queryByPhoneAndPassword(String phone, String password);
}
