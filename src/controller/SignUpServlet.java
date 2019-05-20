package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import entity.JsonMsg;
import entity.ReceiveOrders;
import entity.ReleaseOrders;
import entity.User;
import service.ReceiveOrdersService;
import service.ReleaseOrdersService;
import service.UserService;
import service.impl.ReceiveOrdersServiceImpl;
import service.impl.ReleaseOrdersServiceImpl;
import service.impl.UserServiceImpl;

public class SignUpServlet extends HttpServlet {

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

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		ReceiveOrdersService receiveOrdersService = new ReceiveOrdersServiceImpl();
		ReleaseOrdersService releaseOrdersService = new ReleaseOrdersServiceImpl();
		UserService userService = new UserServiceImpl();
		
		String uid=request.getParameter("uid");
		Integer oid =Integer.parseInt(request.getParameter("oid"));	
		ReleaseOrders releaseOrders = releaseOrdersService.findById(oid);	
		JsonMsg jsonMsg;
		if(uid==""){
			jsonMsg=JsonMsg.makeFail("请先登录", null);
			jsonMsg.setData(1);
		}else{
			User user = userService.findUserById(Integer.parseInt(uid));
			boolean isOne = receiveOrdersService.findByUOid(Integer.parseInt(uid), oid);
			//我要获取当前的日期
	        Date date = new Date();
	        //设置要获取到什么样的时间
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			ReceiveOrders receiveOrders = new ReceiveOrders(0, releaseOrders, user, 0, sdf.format(date));
			if(isOne){
				jsonMsg=JsonMsg.makeFail("您已报名，不需要重复报名！", null);
			}else{
				boolean isok = receiveOrdersService.save(receiveOrders);
				if(isok){
					jsonMsg=JsonMsg.makeSuccess("报名成功！",null);
				}else{
					jsonMsg=JsonMsg.makeFail("报名失败！", null);
				}
			}
		}
		
		
		//序列化
		ObjectMapper objectMapper=new ObjectMapper();
		String writeVaString=objectMapper.writeValueAsString(jsonMsg);
		out.println(writeVaString);
		out.flush();
		out.close();
	}

}
