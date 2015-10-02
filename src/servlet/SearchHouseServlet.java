package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.HouseService;
import entity.HouseBean;

/**
 * Servlet implementation class SearchHouseServlet
 */
@WebServlet("/SearchHouseServlet")
public class SearchHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchHouseServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String whereToG0 = request.getParameter("where");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String numbers = request.getParameter("numbers");

		// if (start_time == null) {
		// start_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date(
		// System.currentTimeMillis()));
		// }
		// if (end_time == null) {
		// end_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date(
		// System.currentTimeMillis()));
		// }
		HouseService houseService = new HouseService();
		// List<HouseBean> targetHouseList = houseService.getTargetHouse(
		// whereToG0, start_time, end_time);
		List<HouseBean> targetHouseList = houseService.getTargetHouse(
				whereToG0, start_time, end_time);

		// out.print("<img src=\"http" + util.Config.filePath + "/ "
		// + targetHouseList.get(0).getPhoto_path()
		// + "\"   alt=\"house\"  />");

		// System.out.println("<img src=\"" + util.Config.filePath + "/"
		// + targetHouseList.get(0).getPhoto_path()
		// + "\"   alt=\"house\"  />");

		Iterator<HouseBean> iterator = targetHouseList.iterator();
		for (HouseBean houseBean : targetHouseList) {
			System.out.println(houseBean.toString());
		}

		// request.getSession().setAttribute("houseList", targetHouseList);
		// HttpSession session = request.getSession();

		// 原来我一早就看到这个需求了***
		HttpSession session = request.getSession();
		// session.setAttribute("start_time", start_time);
		// session.setAttribute("end_time", end_time);

		session.setAttribute("houseList", targetHouseList);
		// session.set
		// request.setAttribute("start_time", start_time);
		// request.setAttribute("end_time", end_time);

		session.setAttribute("start_time", start_time);
		session.setAttribute("end_time", end_time);
		// response.sendRedirect("targetHouse.jsp");
		response.sendRedirect("houseList.jsp");

	}
}
