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
		if ((user = userService.allowLogin(user)) != null) {

			request.getSession().setAttribute("loginedUser", user);//

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
			response.sendRedirect("userCenterJsp/setting.jsp");
		} else if (userService.userExists(tempUserBean)) {
			out.print("<h2>用户名或密码错误，请重新登录</h2>");

			try {
				request.getRequestDispatcher(
						"login_test_for_form_recontain.jsp").include(request,
						response);

			} catch (ServletException e) {
				e.printStackTrace();
			}

		} else {

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
