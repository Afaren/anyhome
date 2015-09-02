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
		// �û�ע�ᣬ��ȡ����Ϣ���û��������롢�绰����
		// �ж��Ƿ�Ϊ�Ϸ��û��� service.isValidUser( user )
		// 1. �Ϸ�������service.addUserд�����ݿ�, ��ת��login.jso��Ҫ���¼
		// 2. ���Ϸ��� �ض���ע��ҳ�棬��ӡ������Ϣ���û����ظ�֮�ࣩ�� Ҫ������ע��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");

		// ������Ϣ��䵽UserBean
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPhone(phone);
		user.setPassword(password);
		// ֻ����ύ�����ݣ���������Ϊ��

		// �Ϸ��û���ֱ��ע��
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
			out.print("<h2>�û����Ѵ��ڣ���ѡ�������û���</h2>");
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
		System.out.println("�û�ע��-------username: "
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
