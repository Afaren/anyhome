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
 * Servlet implementation class LoginServletTestRecontain
 */
@WebServlet("/LoginServletTestRecontain")
public class LoginServletTestRecontain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServletTestRecontain() {
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
		// 获取WritePrint对象
		// 获取请求参数
		// 打印到页面
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		// 将表单信息填充到UserBean
		UserBean user = new UserBean();
		user.setPhone(phone);
		user.setPassword(password);
		// 只填充提交的数据，其它属性为空
		// 增加一个tempUserBean，保存user的引用，因为下面第一个判断句子会改变原先user的指向
		// 而且，这个tempUserBean极有可能是用不着的，如果用户名跟密码都正确得话

		UserBean tempUserBean = user;// 保存引用

		// 合法用户，直接注册
		UserService userService = new UserService();

		// 用户存在，密码正确，允许登录，发送查询得到的user到主页home
		// 用户存在，密码错误，要求重新登录
		// 用户不存在，跳转到注册页面，要求注册
		if ((user = userService.allowLogin(user)) != null) {

			// 封装到会话，redirect到主页
			request.getSession().setAttribute("loginedUser", user);//
			// 07:50 封装到请求域
			// request.setAttribute("loginedUser", user);
			// response.sendRedirect("login.jsp");
			// System.out.println("跳转到home");
			// 打印user内容，看是否正确box
			System.out
					.println("****************************************************"
							+ this.getClass().getName());
			System.out.println(user.getAccount_id());
			System.out.println(user.getGender());
			System.out.println(user.getMail());
			System.out.println(user.getPassword());
			System.out.println(user.getPhone());
			System.out.println(user.getUser_type());
			System.out.println(user.getUsername());
			System.out
					.println("****************************************************"
							+ this.getClass().getName());
			// 这里用重定向无法得到数据 user，请求转发可以吗？
			response.sendRedirect("userCenterJsp/setting.jsp");
			// 9/1/2015 07:41 使用请求转发******************************
			// try {
			// request.getRequestDispatcher("home.jsp").forward(request,
			// response);
			// } catch (ServletException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		} else if (userService.userExists(tempUserBean)) {
			// out.print("<h2>用户名已存在，请选用其它用户名</h2>");
			out.print("<h2>用户名或密码错误，请重新登录</h2>");// 提示信息可能需要封装在会话域，传递到login.jsp
			// response.sendRedirect("login.jsp");
			// request.getRequestDispatcher("login.jsp")
			// .include(request, response);

			try {
				request.getRequestDispatcher(
						"login_test_for_form_recontain.jsp").include(request,
						response);

			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// response.sendRedirect("sign_up.jsp");

		} else {
			// 不存在这个用户，跳转到注册页面
			// out.print("用户" + user.getPhone() +
			// "  不存在，请注册");用户不存在时，无法从数据库中提取出这个字段，所以应该用tempUser
			// out.print("用户" + tempUserBean.getPhone() + "  不存在，请注册");
			// 封装到请求中，不然无法显示错误信息的提示unlogin_message
			// request.setAttribute("unlogin_message",
			// "用户" + tempUserBean.getPhone() + "  不存在，请注册");
			// 封装到请求域中，还是无法在下一次请求得到

			request.getSession(false).setAttribute(
					"unlogin_message",
					"<h1 align=\"center\">用户" + tempUserBean.getPhone()
							+ "  不存在，请注册</h1>");
			response.sendRedirect("sign_up.jsp");
		}

		out.println("phone: " + phone + "\r\n");
		out.print("   password: " + password);

		System.out.println("用户登录-------login_password: "
				+ password
				+ " login_cellphone: "
				+ phone
				+ new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss")
						.format(new Date()) + "  " + "-------"
				+ this.getClass().getName());

	}

}
