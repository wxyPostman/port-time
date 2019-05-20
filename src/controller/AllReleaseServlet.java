package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReleaseOrdersDAO;
import entity.Position;
import entity.ReleaseOrders;
import entity.School;
import service.PositionService;
import service.ReleaseOrdersService;
import service.SchoolService;
import service.impl.PositionServiceImpl;
import service.impl.ReleaseOrdersServiceImpl;
import service.impl.SchoolServiceImpl;
import utils.PageBean;

public class AllReleaseServlet extends HttpServlet {
	private final String PAGESIZE="5";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);

		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String currentPage=request.getParameter("currentPage");
		String pageSize=request.getParameter("pageSize");
		int iCurrentPage=1;
		int iPageSize=5;
		if(currentPage!=null){
			iCurrentPage=Integer.parseInt(currentPage);
		}
		if(pageSize==null){
			pageSize=PAGESIZE;
		}
		

		
		
		
		ReleaseOrdersService releaseOrdersService = new ReleaseOrdersServiceImpl();
		PositionService positionService = new PositionServiceImpl();
		SchoolService schoolService = new SchoolServiceImpl();
		List<School> schoolList = schoolService.findAll();
		List<Position> positionList = positionService.findAll();
		//List<ReleaseOrders> ordersList =releaseOrdersService.findAllByPage(iCurrentPage, iPageSize);
		
		PageBean<ReleaseOrders> pb = null ;
		Position position = null;
		School school = null;
		String sname = request.getParameter("sname");
		String pname =request.getParameter("pname");
		String title=request.getParameter("title");
		if(sname==null){
			sname="";
		}
		if(pname==null)
			pname="";
		
		if(title==null){
			title="";
		}
		if(sname!=""&&pname!=""){	
			position =positionService.findPositionByName(pname);
			school =schoolService.findBySname(sname);
			pb=releaseOrdersService.findBySiPiTiPageBean(school.getSid(), position.getPid(), title,iCurrentPage, iPageSize);
		}
		if(pname!="" && sname==""){	
			position =positionService.findPositionByName(pname);
			pb=releaseOrdersService.findByPiTiPageBean( position.getPid(),title, iCurrentPage, iPageSize);
		}
		if(pname=="" && sname!=""){	
			
			school =schoolService.findBySname(sname);
			System.out.println(school);
			pb=releaseOrdersService.findBySiTiPageBean(school.getSid(), title, iCurrentPage, iPageSize);
		}
		if(pname=="" && sname==""){
			pb=releaseOrdersService.findByTitlePageBean(title, iCurrentPage, iPageSize);
		}

		//request.setAttribute("currentPage", currentPage);
		request.setAttribute("position", position);
		request.setAttribute("title", title);
		request.setAttribute("school", school);
		request.setAttribute("PageBean", pb);
		request.setAttribute("schoolList", schoolList);
		request.setAttribute("positionList", positionList);
		request.getRequestDispatcher("resource-index.jsp").forward(request, response);
		
	}

}
