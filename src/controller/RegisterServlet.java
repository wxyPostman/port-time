package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


import duanxin.Duanxin;
import entity.JsonMsg;
import entity.Position;
import entity.School;
import entity.User;
import service.PositionService;
import service.SchoolService;
import service.UserService;
import service.impl.PositionServiceImpl;
import service.impl.SchoolServiceImpl;
import service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

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

		SchoolService schoolService=new SchoolServiceImpl();
		
		String op = request.getParameter("op");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		// 读取参数
		String username = request.getParameter("register_username");
		String password = request.getParameter("register_password");
		String sname=request.getParameter("register_school");
		String register_phone=request.getParameter("register_phone");
		School school = schoolService.findBySname(sname);
		JsonMsg jsonMsg=null;
		
		if(op==null){
			User user = new User(0, school, username, password, "", register_phone, "", 90, 0, 0);
			UserService userService=new UserServiceImpl();
			boolean isok = userService.addUser(user);
			if(isok){
				jsonMsg=JsonMsg.makeSuccess("恭喜你，注册成功！",null);
			} else {
				jsonMsg=JsonMsg.makeFail("注册失败！",null);
			}
			ObjectMapper objectMapper=new ObjectMapper();
			String ss=objectMapper.writeValueAsString(jsonMsg);
			out.println(ss);
		}else if(op.equals("getphone")){
			String phone=request.getParameter("phone");
			String cap="";
			Random random=new Random();
			for(int i=0;i<4;i++){
				int t=random.nextInt(10);
				cap+=String.valueOf(t);
			}
			Duanxin.sendOne("您的注册", cap, phone);
			ObjectMapper objectMapper=new ObjectMapper();
			String writeVaString=objectMapper.writeValueAsString(cap);
			out.println(writeVaString);
		}else if(op.equals("getschool")){
			List<School> list = schoolService.findAll();
			jsonMsg=JsonMsg.makeSuccess("查找完成", list);
			ObjectMapper objectMapper=new ObjectMapper();
			String writeValueAsString = objectMapper.writeValueAsString(list);
			out.println(writeValueAsString);
		}else if(op.equals("getposition")){
			PositionService positionService=new PositionServiceImpl();
			List<Position> list = positionService.findAll();
			jsonMsg=JsonMsg.makeSuccess("查找成功", list);
			ObjectMapper objectMapper=new ObjectMapper();
			String writeValueAsString = objectMapper.writeValueAsString(list);
			out.println(writeValueAsString);
		}
		
		out.flush();
		out.close();
		
	}

}
