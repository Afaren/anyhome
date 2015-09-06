package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.HouseService;
import entity.HouseBean;
import entity.UserBean;

/**
 * Servlet implementation class ReleaseHouseServlet2
 */
@WebServlet("/ReleaseHouseServlet2")
public class ReleaseHouseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String filePath = "E:/ahImg";// 文件上传路径
	private final String tempFilePath = "E:/ahTemp";// 文件临时存储路径

	private String s_province;
	private String s_city;
	private String s_country;
	private String s_address;
	private String photo;

	// private String address;
	// private String photo;
	// private string

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReleaseHouseServlet2() {
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
		precessRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		precessRequest(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		File saveDir = new File(filePath);
		// 如果目录不存在，就创建目录
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		File tempDir = new File(tempFilePath);
		if (!tempDir.exists()) {
			tempDir.mkdir();
		}
	}

	private void precessRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter outNet = response.getWriter();
		// StringBuilder address = new StringBuilder();
		HouseBean houseBean = new HouseBean();// 各字段在两个函数中填充
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置缓冲区大小
			factory.setSizeThreshold(4 * 1024);
			// 设置临时目录
			factory.setRepository(new File(tempFilePath));
			// 文件上传器
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(request);
			// 设置允许上传的文件的最大尺寸，此处为4M
			upload.setSizeMax(4 * 1024 * 1024);

			Iterator<FileItem> iter = items.iterator();
			System.out.println("before");
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (!item.isFormField()) {
					// 复合文件域
					System.out.println("is upload file");
					processUploadFile(item, houseBean, outNet);
				} else {
					// 普通域
					processFormField(item, houseBean, outNet);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// address.append(s_province).append(s_city).append(s_country)
		// .append(s_address);
		// houseBean.setAddress(address);
		houseBean.setAddress(s_province + s_city + s_country + s_address);
		houseBean.setPhoto_path(photo);
		houseBean.setHost_id(((UserBean) request.getSession(false)
				.getAttribute("loginedUser")).getUser_id());
		// 至此，houseBean数据设置完毕
		// 使用service类将house数据写入到数据库
		HouseService houseService = new HouseService();
		if (houseService.releaseHouse(houseBean)) {
			response.sendRedirect("home.jsp");
		} else {
			outNet.print("<h1>无法发布房屋</h1>");
			// 这里应该跳转到主页，现在先将主要的业务逻辑写好，不管这些
			// response.sendRedirect("home.jsp");
		}

		System.out.println(houseBean.getAddress());
		System.out.println(houseBean.getDescription());
		System.out.println(houseBean.getHouse_title());
		System.out.println(houseBean.getPhoto_path());
		System.out.println(houseBean.getPrice());

	}

	private void processFormField(FileItem item, HouseBean houseBean,
			PrintWriter outNet) throws UnsupportedEncodingException {
		String name = item.getFieldName();
		String value = item.getString();

		if (name.equals("house_title") || name == "house_title") {
			houseBean.setHouse_title(new String(value.getBytes("iso-8859-1"),
					"utf-8"));
			return;
		} else if (name.equals("price") || name == "price") {
			houseBean.setPrice(Integer.parseInt(new String(value
					.getBytes("iso-8859-1"), "utf-8")));
			return;
		} else if (name.equals("description") || name == "description") {
			houseBean.setDescription(new String(value.getBytes("iso-8859-1"),
					"utf-8"));
			return;
		} else if (name.equals("s_province") || name == "s_province") {
			s_province = new String(value.getBytes("iso-8859-1"), "utf-8");
			return;
		} else if (name.equals("s_city") || name == "s_city") {
			s_city = new String(value.getBytes("iso-8859-1"), "utf-8");
			return;
		} else if (name.equals("s_country") || name == "s_country") {
			s_country = new String(value.getBytes("iso-8859-1"), "utf-8");
			return;
		} else if (name.equals("s_address") || name == "s_address") {
			s_address = new String(value.getBytes("iso-8859-1"), "utf-8");
			return;
		}

	}

	private void processUploadFile(FileItem item, HouseBean houseBean,
			PrintWriter outNet) throws Exception {
		String filename = item.getName();
		// System.out.println("filename: " + filename);
		int index = filename.lastIndexOf(".");// 获取尾缀
		filename = houseBean.getHouse_title() + System.currentTimeMillis()
				+ filename.substring(index, filename.length());// 更改图片名，加上系统时间使其唯一
		long fileSize = item.getSize();
		System.out.println("filename: after " + filename);

		if (filename.equals("") && fileSize == 0) {
			System.out.println("filename: after " + filename);
			return;
		}
		System.out.println("after  turn filename: " + filename);
		File uploaddedFile = new File(filePath + "/" + filename);
		System.out.println(filePath + "/" + filename);
		item.write(uploaddedFile);// 写入硬盘

		outNet.print(filename + "is saved");
		outNet.print("the size of " + filename + " is " + fileSize + " \r\n");
		System.out.println("the size of " + filename + " is " + fileSize
				+ " \r\n");
		System.out.println(filename + "  " + fileSize);
		photo = filename;// 设置图片名

	}

	private void processFormField(FileItem item, PrintWriter outNet) {
		// TODO Auto-generated method stub
		String name = item.getFieldName();
		String value = item.getString();
		outNet.println(name + ": " + value + "\r\n");
		System.out.println(name + ": " + value + "\r\n");
	}

	private void processUploadFile(FileItem item, PrintWriter outNet)
			throws Exception {
		// TODO Auto-generated method stub

		String filename = item.getName();
		System.out.println("filename: " + filename);
		int index = filename.lastIndexOf("\\");
		filename = filename.substring(index + 1, filename.length());
		long fileSize = item.getSize();
		System.out.println("filename: after " + filename);

		if (filename.equals("") && fileSize == 0) {
			System.out.println("filename: after " + filename);
			return;
		}
		System.out.println("after  turn filename: " + filename);
		File uploaddedFile = new File(filePath + "\\" + filename);
		System.out.println(filePath + "\\" + filename);
		item.write(uploaddedFile);

		outNet.print(filename + "is saved");
		outNet.print("the size of " + filename + " is " + fileSize + " \r\n");
		System.out.println("the size of " + filename + " is " + fileSize
				+ " \r\n");
		System.out.println(filename + "  " + fileSize);
	}

}
