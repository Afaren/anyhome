package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HouseStateServlet
 */
@WebServlet("/HouseStateServlet")
public class HouseStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HouseStateServlet() {
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

	// CHECKING_ORDER = 1; // �������ɣ���ȷ�ϣ������
	// ACCEPT_WAIT_PAY_ORDER = 2; // host���ܶ�����������
	// CANCEL_ORDER = 3; // ����ȡ������
	// REJECT_ORDER = 4; // �����ܾ�����
	// WAIT_CHECKIN_ORDER = 5; // �����Ѹ������ס
	// LIVING_ORDER = 6; // ��ס��
	// ACCOMPLISH_ORDER = 7; // �����

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {

		String state = request.getParameter("state");
		// order
		if (state.equals("checking")) {

		}

	}
}
