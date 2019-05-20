package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ZhCN_to16;
import entity.JsonMsg;
import entity.Position;
import entity.ReleaseOrders;
import entity.School;
import entity.User;
import service.PositionService;
import service.ReceiveOrdersService;
import service.ReleaseOrdersService;
import service.SchoolService;
import service.UserService;
import service.impl.PositionServiceImpl;
import service.impl.ReceiveOrdersServiceImpl;
import service.impl.ReleaseOrdersServiceImpl;
import service.impl.SchoolServiceImpl;
import service.impl.UserServiceImpl;
import sun.misc.Perf.GetPerfAction;

public class AdminServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		List<User> list = null;
		UserService userService = new UserServiceImpl();
		SchoolService schoolService=new SchoolServiceImpl();
		ReleaseOrdersService releaseOrdersService=new ReleaseOrdersServiceImpl();
		ReceiveOrdersService receiveOrdersServiceDAO=new ReceiveOrdersServiceImpl();
		JsonMsg jsonMsg = null;
		String op = request.getParameter("op");
		if(op.equals("count_all")){
			
			int completedNum = receiveOrdersServiceDAO.countByStatus(3);
			int applyNum=receiveOrdersServiceDAO.countByStatus(0);
			int releasedOrdersNum = releaseOrdersService.count();
			int registedUserNum = userService.count();
			request.setAttribute("registedUserNum", registedUserNum);
			request.setAttribute("releasedOrdersNum", releasedOrdersNum);
			request.setAttribute("completedNum", completedNum);
			request.setAttribute("applyNum", applyNum);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			//序列化
			ObjectMapper objectMapper=new ObjectMapper();
			String writeVaString=objectMapper.writeValueAsString(jsonMsg);
			out.println(writeVaString);
		}else if(op.equals("alluser")){
			String username = request.getParameter("username");
			if (username == null) {
				list = userService.findAll();
				jsonMsg = JsonMsg.makeSuccess("查找所有用户", list);
			} else {
				list = userService.findByUsername(username);
				jsonMsg = JsonMsg.makeFail("查找部分存在用户", list);
			}
			ObjectMapper objectMapper = new ObjectMapper();
			String writeValueAsString = objectMapper.writeValueAsString(list);
			out.println(ZhCN_to16.Aescape(writeValueAsString));
		}else if(op.equals("delUser")){
			Integer uid = Integer.parseInt(request.getParameter("uid"));
			boolean isok = userService.deleteById(uid);
			if (isok) {
				jsonMsg = JsonMsg.makeSuccess("删除用户成功", null);
			} else {
				jsonMsg = JsonMsg.makeFail("删除用户失败", null);
			}
			//序列化
			ObjectMapper objectMapper=new ObjectMapper();
			String writeVaString=objectMapper.writeValueAsString(jsonMsg);
			out.println(writeVaString);
		}else if(op.equals("allSchool")){
			List<School> slist = schoolService.findAll();
			jsonMsg=JsonMsg.makeSuccess("查找所有类型", slist);
			ObjectMapper objectMapper=new ObjectMapper();
			String writeValueAsString = objectMapper.writeValueAsString(slist);
			out.println(writeValueAsString);
		}else if(op.equals("delSchool")){
			Integer id =Integer.parseInt(request.getParameter("sid")) ;
			boolean isok = schoolService.deleteSchoolById(id);
			if (isok) {
				jsonMsg = JsonMsg.makeSuccess("删除学校成功！", null);
			} else {
				jsonMsg = JsonMsg.makeFail("删除学校失败！", null);
			}
			//序列化
			ObjectMapper objectMapper=new ObjectMapper();
			String writeVaString=objectMapper.writeValueAsString(jsonMsg);
			out.println(writeVaString);
		}else if(op.equals("saveSchool")){
			String sname=request.getParameter("sname");
			School school = new School(0, sname);
			boolean isok = schoolService.addSchool(school);
			if (isok) {
				jsonMsg = JsonMsg.makeSuccess("添加学校成功！", null);
			} else {
				jsonMsg = JsonMsg.makeFail("添加学校失败！", null);
			}
			//序列化
			ObjectMapper objectMapper=new ObjectMapper();
			String writeVaString=objectMapper.writeValueAsString(jsonMsg);
			out.println(writeVaString);
		}else if(op.equals("allOrders")){
			String id=request.getParameter("oid");
			if(id==null){
				List<ReleaseOrders> relList = releaseOrdersService.findAll();
				jsonMsg=JsonMsg.makeSuccess("查找所有兼职", relList);
				ObjectMapper objectMapper=new ObjectMapper();
				String writeValueAsString = objectMapper.writeValueAsString(relList);
				out.println(writeValueAsString);
			}else{
				
				boolean isok = releaseOrdersService.deleteById(Integer.parseInt(id));
				if(isok){
					jsonMsg = JsonMsg.makeSuccess("删除成功！", null);
				}else{
					jsonMsg = JsonMsg.makeFail("删除失败！", null);
				}
				ObjectMapper objectMapper = new ObjectMapper();
				String ss = objectMapper.writeValueAsString(jsonMsg);
				out.println(ss);
			}
		
		}else if(op.equals("allposition")){
			String pid=request.getParameter("pid");
			String pname=request.getParameter("pname");
			PositionService positionService=new PositionServiceImpl();
			 if(pid!=null){
				boolean isok = positionService.deletePositionById(Integer.parseInt(pid));
				if(isok){
					jsonMsg = JsonMsg.makeSuccess("删除成功！", null);
				}else{
					jsonMsg = JsonMsg.makeFail("删除失败！", null);
				}
				ObjectMapper objectMapper = new ObjectMapper();
				String ss = objectMapper.writeValueAsString(jsonMsg);
				out.println(ss);
			}else if(pname!=null){
				Position position=new Position(0, pname);
				boolean isok = positionService.addPosition(position);
				if(isok){
					jsonMsg=JsonMsg.makeSuccess("添加成功", null);
				}else{
					jsonMsg=JsonMsg.makeFail("添加失败", null);
				}
				ObjectMapper objectMapper = new ObjectMapper();
				String ss = objectMapper.writeValueAsString(jsonMsg);
				out.println(ss);
			}else{
				List<Position> plist = positionService.findAll();
				jsonMsg=JsonMsg.makeSuccess("查找所有类型", plist);
				ObjectMapper objectMapper=new ObjectMapper();
				String writeValueAsString = objectMapper.writeValueAsString(plist);
				out.println(writeValueAsString);
			}
		}
	}
}
