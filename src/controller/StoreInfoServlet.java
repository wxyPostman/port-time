package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReleaseOrdersDAO;
import entity.ReleaseOrders;
import entity.User;
import service.ReleaseOrdersService;
import service.UserService;
import service.impl.ReleaseOrdersServiceImpl;
import service.impl.UserServiceImpl;

public class StoreInfoServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer uid = Integer.parseInt(request.getParameter("uid"));
		ReleaseOrdersService releaseOrdersService = new ReleaseOrdersServiceImpl();
		UserService userService = new UserServiceImpl();
		User user = userService.findUserById(uid);
		int count =releaseOrdersService.countByUid(uid);
		List<ReleaseOrders> threeOrdersList=releaseOrdersService.findThree(uid);
		request.setAttribute("list", threeOrdersList);
		request.setAttribute("user", user);
		request.setAttribute("count", count);
		request.getRequestDispatcher("storeinfo.jsp").forward(request, response);
	}

}
