package service;

import java.util.List;

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
		// �ж��û����Ƿ���ڣ�
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

	// �ֻ��������������ȷ�����е�¼
	public UserBean allowLogin(UserBean user) {

		System.out.println(user.getPassword() + user.getPhone());
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

	public boolean resetUserInfo(UserBean user) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		if (userDaoImpl.resetMailAndGender(user.getUser_id(), user.getMail(),
				user.getGender())) {
			return true;
		}
		return false;
	}

	public boolean checkPwd(UserBean userBean, String oldpwd) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		if (userDaoImpl.isCorrectPwd(userBean, oldpwd)) {
			return true;
		}

		return false;
	}

	public void resetPwd(UserBean userBean, String newpwd) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.resetPwd(userBean, newpwd);
	}

	public boolean deleteUser(int user_id) {

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		boolean isDelete = userDaoImpl.deleteUser(user_id);
		return isDelete;
	}

	public List<UserBean> getAllUser() {
		// TODO Auto-generated method stub
		// �����ҵ���߼�û�����ƣ��ҽ���ֱ��д��users.jsp���ˡ�
		return null;
	}
}
