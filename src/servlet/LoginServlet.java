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
			HttpServletResponse response) throws IOException {

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

			System.out.println("��ת��home");
			// ��ӡuser���ݣ����Ƿ���ȷbox
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

			if (user.getUser_type() == 0) {
				response.sendRedirect("mainScreen2.jsp");
			} else {
				try {
					request.getRequestDispatcher("WEB-INF/manager/main.jsp")
							.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else if (userService.userExists(tempUserBean)) {
			out.print("<h2>�û�����������������µ�¼</h2>");// ��ʾ��Ϣ������Ҫ��װ�ڻỰ�򣬴��ݵ�login.jsp

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
					"<h1 align=\"center\">�û�" + tempUserBean.getPhone()
							+ "  �����ڣ���ע��</h1>");
			response.sendRedirect("sign_up.jsp");
		}
		out.println("phone: " + phone + "\r\n");
		out.print("   password: " + password);

		System.out.println("�û���¼-------login_password: "
				+ password
				+ " login_cellphone: "
				+ phone
				+ new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss")
						.format(new Date()) + "  " + "-------"
				+ this.getClass().getName());

	}
}
