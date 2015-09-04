package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	@Override
	public boolean isValidUser(String username) {
		// TODO Auto-generated method stub
		// ���ݿ��в�ѯ�Ƿ��Ѵ��ڴ��û���
		// ��ȡ���ӣ�����Ԥ�������
		// ִ����䣬�鿴������Ƿ�Ϊ�գ�
		// �գ�������Ч�û�������false
		// �ǿգ��û��Ѵ��ڣ�����true
		Connection connection = null;
		PreparedStatement prst = null;
		ResultSet rSet = null;

		try {
			connection = DbTool.getConnection();
			String sql_query_by_username = "SELECT username FROM user WHERE username = ?";// �������ֻ��ѯ��username����ôpassword�ǲ��ܵõ���
			prst = connection.prepareStatement(sql_query_by_username);
			prst.setString(1, username);
			rSet = prst.executeQuery();

			if (rSet.next()) {
				return false;// �û����ڣ�����false
			} else {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbTool.close(rSet, prst, connection);// �ر����ݿ���Դ
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
		// ��ѯphone�Ƿ����

		Connection connection = null;
		PreparedStatement prst = null;
		ResultSet rSet = null;

		try {
			connection = DbTool.getConnection();
			String sql_query_by_phone = "SELECT phone FROM user WHERE phone = ?";// �������ֻ��ѯ��username����ôpassword�ǲ��ܵõ���
			prst = connection.prepareStatement(sql_query_by_phone);
			prst.setString(1, phone);
			rSet = prst.executeQuery();

			// ��Щ�߼��Ƿ������⣬���Ǻ�������ڹر���Դ֮ǰ�ͷ��أ��Ƿ����Ӱ��
			if (rSet.next()) {
				return true;// �û����ڣ�����false
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbTool.close(rSet, prst, connection);// �ر����ݿ���Դ
		}
		return false;
	}

	@Override
	public UserBean queryByPhoneAndPassword(String phone, String password) {

		UserBean userBean = null;// �����ѯ�õ��ļ�¼
		Connection connection = null;
		PreparedStatement prst = null;
		ResultSet rSet = null;

		try {
			connection = DbTool.getConnection();
			String sql_query_by_phoneAndPassword = "SELECT * FROM user WHERE phone=? AND password=?";// �������ֻ��ѯ��username����ôpassword�ǲ��ܵõ���
			prst = connection.prepareStatement(sql_query_by_phoneAndPassword);
			prst.setString(1, phone);
			prst.setString(2, password);
			rSet = prst.executeQuery();

			if (rSet.next()) {

				userBean = new UserBean();// �����ѯ�õ��ļ�¼

				// ������������ڣ�����password��phone�ǿ��Բ�д��ȥ�ģ��Ȳ�����
				userBean.setUser_id(rSet.getInt("user_id"));
				userBean.setAccount_id(rSet.getInt("account_id"));
				userBean.setUsername(rSet.getString("username"));
				userBean.setPassword(rSet.getString("password"));
				userBean.setPhone(rSet.getString("phone"));
				userBean.setMail(rSet.getString("mail"));
				userBean.setGender(rSet.getString("gender"));
				userBean.setUser_type(rSet.getInt("user_type"));

				// ����Ҫ����������userBean����Ȼ�����õ�Īһ������ʱ���Ҳ�����
			}
			//
			// return userBean;// �û����ڣ��������������UserBean������δ���ǹ���Ա��¼�������
			// } else {
			// return null;
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbTool.close(rSet, prst, connection);// �ر����ݿ���Դ
		}
		// return null;
		return userBean;// �û����ڣ��������������UserBean�������ڵĻ���UserBeanû����䣬����NULL������δ���ǹ���Ա��¼�������
	}

	@Override
	/*
	 * �˸��²����漰���ű� user & account
	 */
	public boolean updateMailGenderAccount_num(String mail, String gender,
			String account_num) {
		// TODO Auto-generated method stub
		return false;
	}
}
