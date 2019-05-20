package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ZhCN_to16;
import entity.User;

public class GetSession_login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

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
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Object o = session.getAttribute("user");
		if (o != null) {
			User user = (User) o;
			ObjectMapper objectMapper = new ObjectMapper();
			String writeValueAsString = objectMapper.writeValueAsString(user);
			out.println(ZhCN_to16.Aescape(writeValueAsString));
		} else {
			out.println(400);
		}
	}
}
