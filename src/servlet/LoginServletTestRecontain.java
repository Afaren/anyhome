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

		// ������Ϣ��䵽UserBean
		UserBean user = new UserBean();
		user.setPhone(phone);
		user.setPassword(password);
		// ֻ����ύ�����ݣ���������Ϊ��
		// ����һ��tempUserBean������user�����ã���Ϊ�����һ���жϾ��ӻ�ı�ԭ��user��ָ��
		// ���ң����tempUserBean���п������ò��ŵģ�����û��������붼��ȷ�û�

		UserBean tempUserBean = user;// ��������

		// �Ϸ��û���ֱ��ע��
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
			out.print("<h2>�û�����������������µ�¼</h2>");

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
