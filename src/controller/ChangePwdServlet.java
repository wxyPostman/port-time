package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ZhCN_to16;
import entity.JsonMsg;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class ChangePwdServlet extends HttpServlet {

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		PrintWriter out = response.getWriter();
		UserService userService = new UserServiceImpl();
		
		String input_new_pwd=request.getParameter("input_new_pwd");
		String input_new_pwd1=request.getParameter("input_new_pwd1");
		String password=request.getParameter("password");
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		User user = userService.findUserById(uid);
		JsonMsg jsonMsg=null;
		if(!user.getPassword().equals(password)){
			jsonMsg = JsonMsg.makeFail("原密码错误！请重试！", null);
			jsonMsg.setData(1);
		}else if(input_new_pwd==""){
			jsonMsg = JsonMsg.makeFail("新密码不能为空！", null);
			jsonMsg.setData(2);
		}
		else if(!input_new_pwd.equals(input_new_pwd1)){
			jsonMsg = JsonMsg.makeFail("两次输入密码不同！请重试！", null);
			jsonMsg.setData(3);
		}else if(input_new_pwd.equals(password)){
			jsonMsg = JsonMsg.makeFail("新密码与旧密码相同！请重试！", null);
			jsonMsg.setData(4);
		}else{
			boolean isok = userService.updatePwd(uid,input_new_pwd);

			if(isok){
				jsonMsg=JsonMsg.makeSuccess("修改密码成功",null);
			}else{
				jsonMsg=JsonMsg.makeFail("修改密码失败", null);
				
			}
		}
		// 序列化jsonMsg
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writeValueAsString(jsonMsg);
		out.println(ZhCN_to16.Aescape(writeValueAsString));

	}

}
