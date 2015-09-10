package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbTool;
import entity.UserBean;

/**
 * @author : Chen
 * @fileName : dao.UserDaoImpl.java
 * 
 * @date: Aug 31, 2015 5:08:08 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class UserDaoImpl implements UserDao {

	public List<UserBean> AllUsers() {
		Connection connection = null;
		PreparedStatement prst = null;
		ResultSet rSet = null;
		List<UserBean> userList = new ArrayList<UserBean>();
		try {
			connection = DbTool.getConnection();
			String sql_query_all_users = "SELECT * FROM user;";// 这里如果只查询了username，那么password是不能得到的
			prst = connection.prepareStatement(sql_query_all_users);
			rSet = prst.executeQuery();

			if (rSet.next()) {
				UserBean userBean = new UserBean();
				userBean.setUser_id(rSet.getInt("user_id"));
				userBean.setAccount_id(rSet.getInt("account_id"));
				userBean.setUsername(rSet.getString("username"));
				userBean.setPassword(rSet.getString("password"));
				userBean.setPhone(rSet.getString("phone"));
				userBean.setMail(rSet.getString("mail"));
				userBean.setGender(rSet.getString("gender"));
				userBean.setUser_type(rSet.getInt("user_type"));
				userList.add(userBean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbTool.close(rSet, prst, connection);// 关闭数据库资源
		}

		return userList;
	}

	@Override
	public boolean isValidUser(String username) {
		// TODO Auto-generated method stub
		// 数据库中查询是否已存在此用户、
		// 获取连接，传输预编译语句
		// 执行语句，查看结果集是否为空，
		// 空，则是有效用户，返回false
		// 非空，用户已存在，返回true
		Connection connection = null;
		PreparedStatement prst = null;
		ResultSet rSet = null;

		try {
			connection = DbTool.getConnection();
			String sql_query_by_username = "SELECT username FROM user WHERE username = ?";// 这里如果只查询了username，那么password是不能得到的
			prst = connection.prepareStatement(sql_query_by_username);
			prst.setString(1, username);
			rSet = prst.executeQuery();

			if (rSet.next()) {
				return false;// 用户存在，返回false
			} else {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbTool.close(rSet, prst, connection);// 关闭数据库资源
		}
		return false;
	}

	@Override
	public boolean insertUser(UserBean user) {
		System.out.println("insertUser**********************************");
		Connection connection = null;
		PreparedStatement prst = null;
		String sql_insert_a_user = "INSERT INTO user(user_type, username, password, gender, mail, phone ) VALUES(?, ?, ?, ?, ?, ?)";
		connection = DbTool.getConnection();
		int insertResult = 0;
		try {
			prst = connection.prepareStatement(sql_insert_a_user);
			prst.setInt(1, user.getUser_type());
			prst.setString(2, user.getUsername());
			prst.setString(3, user.getPassword());
			prst.setString(4, user.getGender());
			prst.setString(5, user.getMail());
			prst.setString(6, user.getPhone());

			insertResult = prst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			DbTool.close(prst, connection);
		}

		if (insertResult == 0) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean userExistsQueryByPhone(String phone) {
		// 查询phone是否存在

		Connection connection = null;
		PreparedStatement prst = null;
		ResultSet rSet = null;

		try {
			connection = DbTool.getConnection();
			String sql_query_by_phone = "SELECT phone FROM user WHERE phone = ?";// 这里如果只查询了username，那么password是不能得到的
			prst = connection.prepareStatement(sql_query_by_phone);
			prst.setString(1, phone);
			rSet = prst.executeQuery();

			// 这些逻辑是否有问题，不是很清楚。在关闭资源之前就返回，是否会有影响
			if (rSet.next()) {
				return true;// 用户存在，返回false
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbTool.close(rSet, prst, connection);// 关闭数据库资源
		}
		return false;
	}

	@Override
	public UserBean queryByPhoneAndPassword(String phone, String password) {

		UserBean userBean = null;// 保存查询得到的记录
		Connection connection = null;
		PreparedStatement prst = null;
		ResultSet rSet = null;

		try {
			connection = DbTool.getConnection();
			String sql_query_by_phoneAndPassword = "SELECT * FROM user WHERE phone=? AND password=?";// 这里如果只查询了username，那么password是不能得到的
			prst = connection.prepareStatement(sql_query_by_phoneAndPassword);
			prst.setString(1, phone);
			prst.setString(2, password);
			rSet = prst.executeQuery();

			if (rSet.next()) {

				userBean = new UserBean();// 保存查询得到的记录

				// 这里的疑问在于，可能password跟phone是可以不写上去的，先不考虑
				userBean.setUser_id(rSet.getInt("user_id"));
				userBean.setAccount_id(rSet.getInt("account_id"));
				userBean.setUsername(rSet.getString("username"));
				userBean.setPassword(rSet.getString("password"));
				userBean.setPhone(rSet.getString("phone"));
				userBean.setMail(rSet.getString("mail"));
				userBean.setGender(rSet.getString("gender"));
				userBean.setUser_type(rSet.getInt("user_type"));

				// 这里要返回完整的userBean，不然后面用到莫一个属性时就找不到了
			}
			//
			// return userBean;// 用户存在，返回填充完整的UserBean（这里未考虑管理员登录的情况）
			// } else {
			// return null;
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbTool.close(rSet, prst, connection);// 关闭数据库资源
		}
		// return null;
		return userBean;// 用户存在，返回填充完整的UserBean；不存在的话，UserBean没有填充，还是NULL（这里未考虑管理员登录的情况）
	}

	@Override
	public boolean resetMailAndGender(int user_id, String mail, String gender) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prst = null;
		int result = 0;

		connection = DbTool.getConnection();
		String sql_reset_mailAndGender = "UPDATE user set mail = ?, gender=? WHERE user_id = ? ";// 这里如果只查询了username，那么password是不能得到的
		try {
			prst = connection.prepareStatement(sql_reset_mailAndGender);
			prst.setString(1, mail);
			prst.setString(2, gender);
			prst.setInt(3, user_id);
			result = prst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (result != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCorrectPwd(UserBean userBean, String password) {
		if (userBean.getPassword().equals(password)) {
			return true;
		}
		return false;

	}

	@Override
	public void resetPwd(UserBean userBean, String newPassword) {

		Connection connection = null;
		PreparedStatement prst = null;
		int result = 0;

		try {
			connection = DbTool.getConnection();
			String sql_reset_password = "UPDATE user SET password=? WHERE user_id=?";

			prst = connection.prepareStatement(sql_reset_password);
			prst.setString(1, newPassword);
			prst.setInt(2, userBean.getUser_id());
			result = prst.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("更新用户密码结果：      " + result);

	}

	@Override
	public boolean deleteUser(int user_id) {

		int result = 0;
		Connection connection = DbTool.getConnection();
		PreparedStatement prst = null;
		String sql_deleteUserByUserID = "DELETE FROM anyhome.user WHERE user_id = ?";
		try {
			prst = connection.prepareStatement(sql_deleteUserByUserID);
			prst.setInt(1, user_id);
			result = prst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result != 0) {
			return true;
		}
		return false;
	}

	// @Override
	// /*
	// * 此更新操作涉及两张表 user & account
	// */
	// public boolean updateMailGenderAccount_num(String mail, String gender,
	// String account_num) {
	// // TODO Auto-generated method stub
	//
	// return false;
	// }
}
