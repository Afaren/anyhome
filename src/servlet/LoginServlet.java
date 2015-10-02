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
 * Servlet implementation class LoginServletTest
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
			HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		System.out.println(phone + password);
		UserBean user = new UserBean();
		user.setPhone(phone);
		user.setPassword(password);

		UserBean tempUserBean = user;// ��������

		UserService userService = new UserService();

		// �û����ڣ�������ȷ�������¼�����Ͳ�ѯ�õ���user����ҳhome
		// �û����ڣ��������Ҫ�����µ�¼
		// �û������ڣ���ת��ע��ҳ�棬Ҫ��ע��
		if ((user = userService.allowLogin(user)) != null) {

			// ��װ���Ự��redirect����ҳ
			request.getSession().setAttribute("loginedUser", user);

			// System.out.println("��ת��home");
			// // ��ӡuser���ݣ����Ƿ���ȷbox
			// System.out
			// .println("****************************************************"
			// + this.getClass().getName());
			// System.out.println(user);
			// System.out
			// .println("****************************************************"
			// + this.getClass().getName());

			if (user.getUser_type() == 0) {
				response.sendRedirect("mainScreen2.jsp");
			} else {
				request.getRequestDispatcher("manager/main.jsp").forward(
						request, response);
				// request.getRequestDispatcher("/manager/main.html").forward(
				// request, response);
				// response.sendRedirect("manager/house.jsp");
			}

		} else if (userService.userExists(tempUserBean)) {
			out.print("<h2 align=\"center\"  style=\"color:white\">�û�����������������µ�¼</h2>");// ��ʾ��Ϣ������Ҫ��װ�ڻỰ�򣬴��ݵ�login.jsp

			try {
				request.getRequestDispatcher("login.jsp").include(request,
						response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		} else {
			// ����������û�����ת��ע��ҳ��
			request.getSession(false).setAttribute(
					"unlogin_message",
					"<h1 style=\"color:white\" align=\"center\">�û�"
							+ tempUserBean.getPhone() + "  �����ڣ���ע��</h1>");
			response.sendRedirect("sign_up.jsp");
		}
		// out.println("phone: " + phone + "\r\n");
		// out.print("   password: " + password);

		System.out.println("�û���¼-------login_password: "
				+ password
				+ " login_cellphone: "
				+ phone
				+ new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss")
						.format(new Date()) + "  " + "-------"
				+ this.getClass().getName());

	}
}
