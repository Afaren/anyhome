package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import entity.UserBean;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
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

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		// 用户注册，获取表单信息：用户名、密码、电话号码
		// 判断是否为合法用户名 service.isValidUser( user )
		// 1. 合法，调用service.addUser写入数据库, 跳转到login.jso，要求登录
		// 2. 不合法， 重定向到注册页面，打印错误信息（用户名重复之类）， 要求重新注册
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");

		// 将表单信息填充到UserBean
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPhone(phone);
		user.setPassword(password);
		// 只填充提交的数据，其它属性为空

		// 合法用户，直接注册
		UserService userService = new UserService();

		if (userService.isValidUser(user)) {
			userService.addUser(user);
			// try {
			// request.getRequestDispatcher("login.jsp").include(request,
			// response);
			// } catch (ServletException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			response.sendRedirect("login.jsp");
		} else {
			out.print("<h2>用户名已存在，请选用其它用户名</h2>");
			try {
				request.getRequestDispatcher("sign_up.jsp").include(request,
						response);

			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// response.sendRedirect("sign_up.jsp");

		}
		out.print("username: " + username);
		out.print("   password: " + password);
		out.print("   phone: " + phone);
		System.out.println("用户注册-------username: "
				+ username
				+ "  password: "
				+ password
				+ "  phone: "
				+ phone
				+ " "
				+ new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss")
						.format(new Date()) + "  " + "-------");

	}
}
