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
		// ��ȡWritePrint����
		// ��ȡ�������
		// ��ӡ��ҳ��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// String phone = request.getParameter("phone");
		// String password = request.getParameter("password");

		// int account_num =
		// Integer.parseInt(request.getParameter("account_num"));
		String gender = request.getParameter("gender");
		String mail = request.getParameter("mail");

		// ������Ϣ��䵽UserBean
		UserBean user = (UserBean) request.getSession().getAttribute(
				"loginedUser");
		// user.setPhone(phone);
		// user.setPassword(password);
		// ֻ�޸���Ҫ�޸ĵ���Ϣ->gender&mail
		user.setGender(gender);
		user.setMail(mail);
		// user.setAccount_id(account_num);
		// ֻ����ύ�����ݣ���������Ϊ��????����������ʵ����session����

		UserService userService = new UserService();

		if (userService.resetUserInfo(user)) {

			// �����û���Ϣ�����ݿ�
			// resetҳ����ʾ���޸���Ϣ
			// ҳ���ϵ�����ȫ����Ϊ��ʾ����ֱ�Ӹ������ݣ�ȫ��Ϊ�����޸ĵģ�ֻ��Ϊ����ʾ

			// ��ӡuser���ݣ����Ƿ���ȷ�޸����ݿ������
			System.out.println("*************�û���Ϣ�޸�*******************"
					+ this.getClass().getName());
			System.out.println(user);
			System.out
					.println("************************************************"
							+ this.getClass().getName());
			// response.sendRedirect("userCenterJsp/setting.jsp");

			// ֱ�Ӵ�ӡ�û����ĵ����ݣ��������У�����
			out.print("mail:    " + user.getMail());
			out.print("gender  " + user.getGender());

		} else {
			out.print("<h4>�޸��û���Ϣʧ��</h4>");
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
