package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ReceiveOrders;
import entity.ReleaseOrders;
import service.ReceiveOrdersService;
import service.ReleaseOrdersService;
import service.impl.ReceiveOrdersServiceImpl;
import service.impl.ReleaseOrdersServiceImpl;

public class UserInfoServlet extends HttpServlet {

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
		Integer uid =Integer.parseInt(request.getParameter("uid"));
		ReleaseOrdersService releaseOrdersService = new ReleaseOrdersServiceImpl();
		ReceiveOrdersService receiveOrdersService = new ReceiveOrdersServiceImpl();
		List<ReleaseOrders> relOList = releaseOrdersService.findByUid(uid);
		List<ReceiveOrders> recOList = receiveOrdersService.findByUid(uid);
		List<ReceiveOrders> relRecOList = new ArrayList<ReceiveOrders>();
		for(ReleaseOrders r :relOList){
			List<ReceiveOrders> list=receiveOrdersService.findByOid(r.getOid());
			relRecOList.addAll(list);
		}
		request.setAttribute("relRecOList", relRecOList);
		request.setAttribute("relOList", relOList);
		request.setAttribute("recOList", recOList);
		request.getRequestDispatcher("userinfo.jsp").forward(request, response);
	}

}
