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

public class MyOrdersServlet extends HttpServlet {

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
			String op =request.getParameter("op");
			
			ReceiveOrdersService receiveOrdersService = new ReceiveOrdersServiceImpl();
			ReleaseOrdersService releaseOrdersService = new ReleaseOrdersServiceImpl();
			SchoolService schoolService = new SchoolServiceImpl();
			PositionService positionService=new PositionServiceImpl();
			UserService userService = new UserServiceImpl();
			PrintWriter out = response.getWriter();
			JsonMsg jsonMsg=null;
			System.out.println("操作:"+op);
			if(op.equals("delrel")){
				Integer oid =Integer.parseInt(request.getParameter("oid"));
				boolean isok = releaseOrdersService.deleteById(oid);
				if(isok){
					jsonMsg=JsonMsg.makeSuccess("删除成功",null);
				}else{
					jsonMsg=JsonMsg.makeFail("删除失败", null);
					
				}
			}else if(op.equals("delrec")){
				Integer id =Integer.parseInt(request.getParameter("id"));
				boolean isok = receiveOrdersService.deleteById(id);
				if(isok){
					jsonMsg=JsonMsg.makeSuccess("删除成功",null);
				}else{
					jsonMsg=JsonMsg.makeFail("删除失败", null);
					
				}
			}else if(op.equals("save")){
				String title = request.getParameter("rel_title");
				String recuritnum = request.getParameter("rel_recuritnum");
				String salary = request.getParameter("rel_salary");
				String sname = request.getParameter("rel_sname");
				String pname = request.getParameter("rel_pname");
				String paymethod = request.getParameter("rel_paymethod");
				String description = request.getParameter("rel_description");
				Integer uid =Integer.parseInt(request.getParameter("uid"));
				if(title==null||title==""){
					jsonMsg=JsonMsg.makeFail("标题栏不能为空!", null);
				}else if(recuritnum==null||recuritnum==""){
					jsonMsg=JsonMsg.makeFail("招聘人数栏不能为空", null);
				}else if(!isNumeric3(recuritnum)){
					jsonMsg=JsonMsg.makeFail("招聘人数要为整数", null);
				}
				else if(salary==null||salary==""){
					jsonMsg=JsonMsg.makeFail("招聘薪资不能为空", null);
				}else if(sname.equals("无")){
					jsonMsg=JsonMsg.makeFail("招聘学校不能为空", null);
				}else if(pname.equals("无")){
					jsonMsg=JsonMsg.makeFail("招聘岗位为空", null);
				}else if(paymethod.equals("无")){
					jsonMsg=JsonMsg.makeFail("招聘方式为空", null);
				}else if(description==null||description==""){
					jsonMsg=JsonMsg.makeFail("招聘描述为空", null);
				}else{
					School school = schoolService.findBySname(sname);
					Position position = positionService.findPositionByName(pname);
					User user =userService.findUserById(uid);
					//我要获取当前的日期
			        Date date = new Date();
			        //设置要获取到什么样的时间
			        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					ReleaseOrders releaseOrders = new ReleaseOrders(0, school, position, title, description, paymethod, Integer.parseInt(recuritnum), sdf.format(date), user, Double.parseDouble(salary), 0);
					System.out.println(releaseOrders);
					
					boolean isok = releaseOrdersService.save(releaseOrders);
					if(isok){
						jsonMsg=JsonMsg.makeSuccess("发布成功",null);
					}else{
						jsonMsg=JsonMsg.makeFail("发布失败", null);
						
					}
				}
				
			}else if(op.equals("modify")){
				String title = request.getParameter("rel_title");
				String recuritnum = request.getParameter("rel_recuritnum");
				String salary = request.getParameter("rel_salary");
				String sname = request.getParameter("rel_sname");
				String pname = request.getParameter("rel_pname");
				String paymethod = request.getParameter("rel_paymethod");
				String description = request.getParameter("rel_description");
				Integer uid =Integer.parseInt(request.getParameter("uid"));
				Integer oid =Integer.parseInt(request.getParameter("oid"));
				if(title==null||title==""){
					jsonMsg=JsonMsg.makeFail("标题栏不能为空!", null);
				}else if(recuritnum==null||recuritnum==""){
					jsonMsg=JsonMsg.makeFail("招聘人数栏不能为空", null);
				}else if(!isNumeric3(recuritnum)){
					jsonMsg=JsonMsg.makeFail("招聘人数要为整数", null);
				}
				else if(salary==null||salary==""){
					jsonMsg=JsonMsg.makeFail("招聘薪资不能为空", null);
				}else if(sname.equals("无")){
					jsonMsg=JsonMsg.makeFail("招聘学校不能为空", null);
				}else if(pname.equals("无")){
					jsonMsg=JsonMsg.makeFail("招聘岗位为空", null);
				}else if(paymethod.equals("无")){
					jsonMsg=JsonMsg.makeFail("招聘方式为空", null);
				}else if(description==null||description==""){
					jsonMsg=JsonMsg.makeFail("招聘描述为空", null);
				}else{
					School school = schoolService.findBySname(sname);
					Position position = positionService.findPositionByName(pname);
					User user =userService.findUserById(uid);
					//我要获取当前的日期
			        Date date = new Date();
			        //设置要获取到什么样的时间
			        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					ReleaseOrders releaseOrders = new ReleaseOrders(oid, school, position, title, description, paymethod, Integer.parseInt(recuritnum), sdf.format(date), user, Double.parseDouble(salary), 0);
					System.out.println(releaseOrders);
					
					boolean isok = releaseOrdersService.update(releaseOrders);
					if(isok){
						jsonMsg=JsonMsg.makeSuccess("修改成功",null);
					}else{
						jsonMsg=JsonMsg.makeFail("修改失败", null);
						
					}
				}
			}else if(op.equals("admit")){
				Integer id =Integer.parseInt(request.getParameter("id"));
				boolean isok = receiveOrdersService.updateByStatus(1, id);
				if(isok){
					jsonMsg=JsonMsg.makeSuccess("录取成功",null);
				}else{
					jsonMsg=JsonMsg.makeFail("录取失败", null);
					
				}
			}else if(op.equals("refuse")){
				Integer id =Integer.parseInt(request.getParameter("id"));
				boolean isok = receiveOrdersService.updateByStatus(2, id);
				if(isok){
					jsonMsg=JsonMsg.makeSuccess("拒绝成功",null);
				}else{
					jsonMsg=JsonMsg.makeFail("拒绝失败", null);
					
				}
			}else if(op.equals("success")){
				Integer id =Integer.parseInt(request.getParameter("id"));
				boolean isok = receiveOrdersService.updateByStatus(3, id);
//				if(isok){
//					jsonMsg=JsonMsg.makeSuccess("订单已完成",null);
//				}else{
//					jsonMsg=JsonMsg.makeFail("拒绝失败", null);
//					
//				}
			}else if(op.equals("score")){
				Integer id  =  Integer.parseInt(request.getParameter("id"));
				Integer oid  =  Integer.parseInt(request.getParameter("oid"));
				Integer score = Integer.parseInt(request.getParameter("score"));
				System.out.println("id:"+id +"   oid:"+oid+"   score:"+score);
				
				//修改用户信息
				User user = releaseOrdersService.findById(oid).getUser();
				System.out.println(user);
				Integer totalScore =user.getTotalScore()+score;
				Integer appraiseNum =user.getAppraiseNum()+1;
				user.setTotalScore(totalScore);
				user.setAppraiseNum(appraiseNum);
				System.out.println(user);
				boolean b = userService.updateUser(user);
				System.out.println(b);
				//修改为状态为 4评分
				boolean c = receiveOrdersService.updateByStatus(4, id);
				if(b && c){
					jsonMsg=JsonMsg.makeSuccess("评分成功",null);
				}else{
					jsonMsg=JsonMsg.makeFail("评分失败", null);
				}
				
			}
			// 序列化jsonMsg
			ObjectMapper objectMapper = new ObjectMapper();
			String writeValueAsString = objectMapper.writeValueAsString(jsonMsg);
			out.println(ZhCN_to16.Aescape(writeValueAsString));
		
	}

	
	public static boolean isNumeric3(String str)
	{
	  final String number = "0123456789";
	  for(int i = 0;i < str.length(); i ++)
		  if(number.indexOf(str.charAt(i)) == -1)
		        return false;  
	  return true;
	}
}
