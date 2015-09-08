package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import entity.UserBean;

/**
 * Servlet implementation class ResetUserInfoServlet
 */
@WebServlet("/ResetUserInfoServlet")
public class ResetUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetUserInfoServlet() {
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
		// 获取WritePrint对象
		// 获取请求参数
		// 打印到页面
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// String phone = request.getParameter("phone");
		// String password = request.getParameter("password");

		// int account_num =
		// Integer.parseInt(request.getParameter("account_num"));
		String gender = request.getParameter("gender");
		String mail = request.getParameter("mail");

		// 将表单信息填充到UserBean
		UserBean user = (UserBean) request.getSession().getAttribute(
				"loginedUser");
		// user.setPhone(phone);
		// user.setPassword(password);
		// 只修改需要修改的信息->gender&mail
		user.setGender(gender);
		user.setMail(mail);
		// user.setAccount_id(account_num);
		// 只填充提交的数据，其它属性为空????其它属性其实已在session中了

		UserService userService = new UserService();

		if (userService.resetUserInfo(user)) {

			// 更新用户信息到数据库
			// reset页面提示已修改信息
			// 页面上的内容全部变为提示后面直接跟上数据，全部为不可修改的，只是为了提示

			// 打印user内容，看是否正确修改数据库的内容
			System.out.println("*************用户信息修改*******************"
					+ this.getClass().getName());
			System.out.println(user);
			System.out
					.println("************************************************"
							+ this.getClass().getName());
			// response.sendRedirect("userCenterJsp/setting.jsp");

			// 直接打印用户更改的数据？？？可行？？？
			out.print("mail:    " + user.getMail());
			out.print("gender  " + user.getGender());

		} else {
			out.print("<h4>修改用户信息失败</h4>");
			try {
				request.getRequestDispatcher(
						"login_test_for_form_recontain.jsp").include(request,
						response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
