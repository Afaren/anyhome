package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.HouseService;
import entity.HouseBean;
import entity.UserBean;

/**
 * Servlet implementation class ReleaseHouseInfoServlet
 */
@WebServlet("/ReleaseHouseServlet")
public class ReleaseHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReleaseHouseServlet() {
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

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.print("<h1>��������</h1>");
		// 1. address s_province + s_city + s_country + s_address
		// 2. description description
		// 3. photo_path photo
		// 4. house_title house_title
		// 5. price price
		String address = request.getParameter("s_province").trim()
				+ request.getParameter("s_city").trim()
				+ request.getParameter("s_country").trim();
		String description = request.getParameter("description");
		String photo = request.getParameter("photo");
		String house_title = request.getParameter("house_title");
		String price = request.getParameter("price");
		System.out.println("s_province: " + request.getParameter("s_province"));
		out.print("s_province: " + request.getParameter("s_province"));

		System.out.println("address: " + address);
		System.out.println("description: " + description);
		System.out.println("photo: " + photo);
		System.out.println("house_title: " + house_title);
		System.out.println("price: " + price);

		// ϵͳ��ܴ����֮��
		// **
		// **
		// ����Ҫ�����뷽ʽ��ת��

		// ���÷���houseService.releaseHouse(house)
		// ����HouseDaoImpl�ĺ�����addHouse(house)�����ݿ��в���һ����¼
		// ������ȷ����ı�ʶ
		// ����������Ч��Ϣ��HouseBean��
		// UserBean userBean = (UserBean)
		// request.getSession(false).getAttribute(
		// "loginedUser");

		HouseBean houseBean = new HouseBean();
		houseBean.setAddress(address);
		houseBean.setDescription(description);
		// ���������session����ȡ���Ծͻ������������ᱨ��*************************************
		houseBean.setHost_id(((UserBean) request.getSession(false)
				.getAttribute("loginedUser")).getUser_id());// ��ȡsession��UserBean��usert_id
		// houseBean.setHouse_id(house_id);auto_increment������Ҫ����
		houseBean.setHouse_title(house_title);
		// houseBean.setNote(note);releaseҳ����û����һ��
		houseBean.setPhoto_path(photo);
		houseBean.setPrice(Integer.parseInt(price));// ���ַ���ת��Ϊ����
		HouseService houseService = new HouseService();
		if (houseService.releaseHouse(houseBean)) {
			// �ɹ��������ݣ���ת�����ݹ���ҳ��
			response.sendRedirect("houseCenter.jsp");
		} else {
			out.print("<h1>�޷���������</h1>");

		}

	}
}
