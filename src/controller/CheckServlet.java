package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Admin;
import entity.JsonMsg;
import entity.User;
import service.AdminService;
import service.UserService;
import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;

public class CheckServlet extends HttpServlet {

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

		/* 允许跨域的主机地址 */
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* 允许跨域的请求方法GET, POST, HEAD 等 */
		response.setHeader("Access-Control-Allow-Methods", "*");
		/* 重新预检验跨域的缓存时间 (s) */
		response.setHeader("Access-Control-Max-Age", "3600");
		/* 允许跨域的请求头 */
		response.setHeader("Access-Control-Allow-Headers", "*");
		/* 是否携带cookie */
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String phone=request.getParameter("register_phone");
		String op = request.getParameter("op");
		
		
		UserService userService=new UserServiceImpl();
		JsonMsg jsonMsg = null;
		if(op.equals("check_phone")){
			
			boolean isok = userService.countByPhone(phone);
			if(phone==null){
				jsonMsg=JsonMsg.makeFail("请填写手机号码", null);
			}else{
				if(isok){
					jsonMsg=JsonMsg.makeSuccess("",null);
				}else{
					jsonMsg=JsonMsg.makeFail("该号码已被注册！请更换", null);
				}
			}
			
		}else if(op.equals("check_un")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = userService.findUserByUsername(username);
			if (user != null) {
				if (user.getPassword().equals(password)) {
					//user.setPassword(null);
					// 取得session
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					jsonMsg = JsonMsg.makeSuccess("成功", user);
				} else {
					// 密码输错
					jsonMsg = JsonMsg.makeFail("用户名或密码错误！请重试！", null);
				}
			} else {
				System.out.println("没找到! ");
				// 没有找到该用户
				jsonMsg = JsonMsg.makeFail("用户名或密码错误！请重试！", null);
			}
		}else if(op.equals("check_run")){
			String username=request.getParameter("register_username");
			boolean b = userService.countByUserName(username);
			if(b){
				jsonMsg=JsonMsg.makeSuccess("",null);
			}else{
				jsonMsg=JsonMsg.makeFail("该用户名已被占用！", null);
			}
		}else if(op.equals("check_an")){			//管理员登录
			String adminname = request.getParameter("adminname");
			String password = request.getParameter("password");
			AdminService adminService=new AdminServiceImpl();
			Admin admin = adminService.findByAdminname(adminname);
			if(admin!=null){
				if(admin.getPassword().equals(password)){
					admin.setPassword("");
					HttpSession session = request.getSession();
					session.setAttribute("admin", admin);
					jsonMsg = JsonMsg.makeSuccess("登录成功", admin);
				} else {
					// 密码输错
					jsonMsg = JsonMsg.makeFail("用户名或密码错误！请重试！", null);
				}
			} else {
				System.out.println("没找到! ");
				// 没有找到该用户
				jsonMsg = JsonMsg.makeFail("用户名或密码错误！请重试！", null);
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
