package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DbTool;
import entity.OrderManageBean;

/**
 * Servlet implementation class OrderClassedByStateServlet
 */
@WebServlet("/OrderClassedByStateServlet")
public class OrderClassedByStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderClassedByStateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int state = Integer.parseInt(request.getParameter("state"));
		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));
		List<OrderManageBean> ordersList = new ArrayList<OrderManageBean>();
		Connection connection = DbTool.getConnection();
		PreparedStatement prst = null;
		String sql_query_orders_by_id = null;
		ResultSet rSet = null;
		sql_query_orders_by_id = "select user.phone, house.house_title, order.start_time, order.end_time, order.total_price FROM user, house, anyhome.order WHERE anyhome.order.host_id = user.user_id AND house.host_id = user.user_id AND	anyhome.order.host_id = ? AND order.states = ?;";
		try {
			prst = connection.prepareStatement(sql_query_orders_by_id);
			prst.setInt(1, id);
			prst.setInt(2, state);
			rSet = prst.executeQuery();
			while (rSet.next()) {
				OrderManageBean orderManageBean = new OrderManageBean();
				orderManageBean.setEnd_time(rSet.getString("end_time"));
				orderManageBean.setHouse_title(rSet.getString("house_title"));
				orderManageBean.setPhone(rSet.getString("phone"));
				orderManageBean.setStart_time(rSet.getString("start_time"));
				orderManageBean.setTotal_price(rSet.getInt("total_price"));
				ordersList.add(orderManageBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();// 3 h
		} finally {
			DbTool.close(rSet, prst, connection);
		}
		request.setAttribute("orderList", ordersList);
		try {
			request.getRequestDispatcher("userCenter/orderManage.jsp").forward(
					request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
