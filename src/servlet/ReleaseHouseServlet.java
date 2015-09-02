package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.HouseService;
import entity.HouseBean;
import entity.UserBean;

/**
 * Servlet implementation class ReleaseHouseInfoServlet
 */
@WebServlet("/ReleaseHouseServlet")
public class ReleaseHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReleaseHouseServlet() {
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
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.print("<h1>发布房屋</h1>");
		// 1. address s_province + s_city + s_country + s_address
		// 2. description description
		// 3. photo_path photo
		// 4. house_title house_title
		// 5. price price
		String address = request.getParameter("s_province").trim()
				+ request.getParameter("s_city").trim()
				+ request.getParameter("s_country").trim();
		String description = request.getParameter("description");
		String photo = request.getParameter("photo");
		String house_title = request.getParameter("house_title");
		String price = request.getParameter("price");
		System.out.println("s_province: " + request.getParameter("s_province"));
		out.print("s_province: " + request.getParameter("s_province"));

		System.out.println("address: " + address);
		System.out.println("description: " + description);
		System.out.println("photo: " + photo);
		System.out.println("house_title: " + house_title);
		System.out.println("price: " + price);

		// 系统框架搭建起来之后，
		// **
		// **
		// 这里要做编码方式的转换

		// 调用服务houseService.releaseHouse(house)
		// 调用HouseDaoImpl的函数，addHouse(house)在数据库中插入一条记录
		// 返回正确插入的标识
		// 插入所有有效信息到HouseBean中
		// UserBean userBean = (UserBean)
		// request.getSession(false).getAttribute(
		// "loginedUser");

		HouseBean houseBean = new HouseBean();
		houseBean.setAddress(address);
		houseBean.setDescription(description);
		// 如果不存在session，提取属性就会出错，于是这里会报错*************************************
		houseBean.setHost_id(((UserBean) request.getSession(false)
				.getAttribute("loginedUser")).getUser_id());// 提取session中UserBean的usert_id
		// houseBean.setHouse_id(house_id);auto_increment，不需要插入
		houseBean.setHouse_title(house_title);
		// houseBean.setNote(note);release页面上没有这一项
		houseBean.setPhoto_path(photo);
		houseBean.setPrice(Integer.parseInt(price));// 将字符串转化为数字
		HouseService houseService = new HouseService();
		if (houseService.releaseHouse(houseBean)) {
			// 成功发布房屋，跳转到房屋管理页面
			response.sendRedirect("houseCenter.jsp");
		} else {
			out.print("<h1>无法发布房屋</h1>");

		}

	}
}
