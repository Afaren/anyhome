package service;

import dao.UserDaoImpl;
import entity.UserBean;

/**
 * @author : Chen
 * @fileName : service.UserService.java
 * 
 * @date: Aug 30, 2015 5:45:32 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class UserService {

	public boolean isValidUser(UserBean user) {
		// TODO Auto-generated method stub
		boolean validUser = false;
		// 判断用户名是否存在，
		UserDaoImpl userdao = new UserDaoImpl();
		if (userdao.isValidUser(user.getUsername())) {
			validUser = true;
			return validUser;
		}
		return false;
	}

	public void addUser(UserBean user) {
		// TODO Auto-generated method stub
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.insertUser(user);

	}

	// 手机号码与密码均正确，运行登录
	public UserBean allowLogin(UserBean user) {

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		if ((user = userDaoImpl.queryByPhoneAndPassword(user.getPhone(),
				user.getPassword())) != null) {
			return user;
		}

		return null;
	}

	public boolean userExists(UserBean user) {
		// TODO Auto-generated method stub
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		if (userDaoImpl.userExistsQueryByPhone(user.getPhone())) {
			return true;
		}
		return false;
	}

	public UserBean resetInfo(UserBean user) {
		// TODO Auto-generated method stub

		return null;
	}

}
