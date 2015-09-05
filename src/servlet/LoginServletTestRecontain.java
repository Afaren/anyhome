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
		// ��ȡWritePrint����
		// ��ȡ�������
		// ��ӡ��ҳ��
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

		// �û����ڣ�������ȷ�������¼�����Ͳ�ѯ�õ���user����ҳhome
		// �û����ڣ��������Ҫ�����µ�¼
		// �û������ڣ���ת��ע��ҳ�棬Ҫ��ע��
		if ((user = userService.allowLogin(user)) != null) {

			// ��װ���Ự��redirect����ҳ
			request.getSession().setAttribute("loginedUser", user);//
			// 07:50 ��װ��������
			// request.setAttribute("loginedUser", user);
			// response.sendRedirect("login.jsp");
			// System.out.println("��ת��home");
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
			// �������ض����޷��õ����� user������ת��������
			response.sendRedirect("userCenterJsp/setting.jsp");
			// 9/1/2015 07:41 ʹ������ת��******************************
			// try {
			// request.getRequestDispatcher("home.jsp").forward(request,
			// response);
			// } catch (ServletException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		} else if (userService.userExists(tempUserBean)) {
			// out.print("<h2>�û����Ѵ��ڣ���ѡ�������û���</h2>");
			out.print("<h2>�û�����������������µ�¼</h2>");// ��ʾ��Ϣ������Ҫ��װ�ڻỰ�򣬴��ݵ�login.jsp
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
			// ����������û�����ת��ע��ҳ��
			// out.print("�û�" + user.getPhone() +
			// "  �����ڣ���ע��");�û�������ʱ���޷������ݿ�����ȡ������ֶΣ�����Ӧ����tempUser
			// out.print("�û�" + tempUserBean.getPhone() + "  �����ڣ���ע��");
			// ��װ�������У���Ȼ�޷���ʾ������Ϣ����ʾunlogin_message
			// request.setAttribute("unlogin_message",
			// "�û�" + tempUserBean.getPhone() + "  �����ڣ���ע��");
			// ��װ���������У������޷�����һ������õ�

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
