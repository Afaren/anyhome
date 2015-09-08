package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;
import entity.OrderBean;
import entity.OrderStates;

/**
 * Servlet implementation class Order
 */
@WebServlet("/OrderOrperateServlet")
// 忘了这里是不是改过了******************************************************************************************
public class OrderOrperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderOrperateServlet() {
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

	// CHECKING_ORDER = 1; // 订单生成，待确认，审核中
	// ACCEPT_WAIT_PAY_ORDER = 2; // host接受订单，待付款
	// CANCEL_ORDER = 3; // 房客取消订单
	// REJECT_ORDER = 4; // 房东拒绝订单
	// WAIT_CHECKIN_ORDER = 5; // 房客已付款，待入住
	// LIVING_ORDER = 6; // 入住中
	// ACCOMPLISH_ORDER = 7; // 已完成

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		OrderBean orderBean = new OrderBean();
		int state = Integer.parseInt(request.getParameter("state"));
		OrderService orderService = new OrderService();
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		String type = request.getParameter("type");// 标识查询订单的用户类型——host||user
		orderBean.setOrder_id(order_id);
		switch (state) {
		case OrderStates.CHECKING_ORDER:// 生成新订单，这里需要所有的数据
			createNewOrder(request, response, orderBean);
			break;
		case OrderStates.SEARCH_ALL_ORDER:// 查询所有订单
			getAllOrder(request, response, type);
			break;
		case OrderStates.ACCEPT_WAIT_PAY_ORDER:
			orderBean.setStates(OrderStates.ACCEPT_WAIT_PAY_ORDER);
			break;
		case OrderStates.ACCOMPLISH_ORDER:
			orderBean.setStates(OrderStates.ACCOMPLISH_ORDER);
			break;
		case OrderStates.CANCEL_ORDER:
			orderBean.setStates(OrderStates.CANCEL_ORDER);
			break;
		case OrderStates.REJECT_ORDER:
			orderBean.setStates(OrderStates.REJECT_ORDER);
			break;
		case OrderStates.WAIT_CHECKIN_ORDER:
			orderBean.setStates(OrderStates.WAIT_CHECKIN_ORDER);
			break;
		case OrderStates.LIVING_ORDER:
			orderBean.setStates(OrderStates.LIVING_ORDER);
			break;
		default:
			break;
		}
		orderService.changeOrderState(orderBean);

		// if (state.equals("checking")) {
		// // 生成订单的操作，根据host_id跟user_id生成新订单
		// orderService.checkingOrder(host_id, user_id);
		// }else if (state.equals("accept_wait_pay")) {
		// // 房东接受订单，等待付款
		// }

	}

	private void getAllOrder(HttpServletRequest request,
			HttpServletResponse response, String type) throws IOException {
		List<OrderBean> orderList = new ArrayList<OrderBean>();
		// id统指host_id跟user_id，因为这里无法得到一个唯一的命名
		int id = Integer.parseInt(request.getParameter("id"));

		orderList = new OrderService().getAllOrder(type, id);

		// if (type.equals("host")) {
		// orderList = getAllOrderOfHost(id);
		// } else {
		// orderList = getAllOrderOfUser(id);
		// }
		// 封装于请求域，转发到orderManage.jsp
		request.setAttribute("orderList", orderList);
		response.sendRedirect("orderManage.jsp");
		// TODO Auto-generated method stub

	}

	private void createNewOrder(HttpServletRequest request,
			HttpServletResponse response, OrderBean orderBean) {

		int host_id = Integer.parseInt(request.getParameter("host_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");

		orderBean.setStates(OrderStates.CHECKING_ORDER);

		orderBean.setHost_id(host_id);
		orderBean.setUser_id(user_id);
		orderBean.setStart_time(start_time);
		orderBean.setEnd_time(end_time);
		orderBean.setOrder_num(user_id + "_" + System.currentTimeMillis());
		// 还没有实现计算两天之间日期差的方法，故此虚拟总价
		int total_price = 200;
		orderBean.setTotal_price(total_price);

		System.out.println(orderBean);
		OrderService orderService = new OrderService();
		orderService.newOrder(orderBean);

		// 这里应该重定向了，上层函数继续的话，会执行下一个函数

	}

	// private void getAllOrder(HttpServletRequest request,
	// HttpServletResponse response, int id) {
	// // TODO Auto-generated method stub
	// request.getParameter(arg0);
	// OrderService orderService = new OrderService();
	// orderService.getAllOrdersOfHost();

	// }
	// private List<OrderBean> getAllOrderOfUser(int id) {
	// // TODO Auto-generated method stub
	// List<OrderBean> orderList = new ArrayList<OrderBean>();
	// orderList = new OrderService().getAllOrder(id);
	// return orderList;
	// }

	// private List<OrderBean> getAllOrderOfHost(int id) {
	// // TODO Auto-generated method stub
	// List<OrderBean> orderList = new ArrayList<OrderBean>();
	// orderList = new OrderService().getAllOrder(id);
	// return orderList;
	//
	// }
}
