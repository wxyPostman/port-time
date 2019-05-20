package dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.impl.ReceiveOrdersDAOImpl;
import dao.impl.ReleaseOrdersDAOImpl;
import entity.Position;
import entity.ReceiveOrders;
import entity.ReleaseOrders;
import entity.School;
import entity.User;
import utils.DBUtil;

public class TestReleaseOrdersDAOImpl {
	ReleaseOrdersDAO releaseOrdersDAO ;
	
	@Before
	public void init(){
		releaseOrdersDAO = new ReleaseOrdersDAOImpl();
	}
	
	@Test
	public void testFindAll(){
		List<ReleaseOrders> list = releaseOrdersDAO.findAll();
		list.forEach(System.out::println);
	}
	
	@Test
	public void testUpdate(){
		School school = new School(1);
		Position position = new Position(1);
		User user = new User(7);
		ReleaseOrders releaseOrders=new ReleaseOrders(6, school, position, "兼职2", "兼职描述2", "月结", 100,"2000-01-01 01:10:10", user, 100d, 0);
		int i=releaseOrdersDAO.update(releaseOrders);
		System.out.println(i);
	}
	
	@Test
	public void testSave(){
		for(int i=12;i<100;i++){
			School school = new School(1);
			Position position = new Position(1);
			User user = new User(7);
			ReleaseOrders releaseOrders=new ReleaseOrders(6, school, position, "兼职"+i, "兼职描述"+i, "月结", 100,"2000-01-01 01:10:10", user, 100d, 0);
			int r=releaseOrdersDAO.save(releaseOrders);
			System.out.println(r);
		}
	}
	
	@Test
	public void testDelete(){
		int i = releaseOrdersDAO.deleteById(7);
		System.out.println(i);
	}
	
	@Test
	public void findById(){
		ReleaseOrders releaseOrders = releaseOrdersDAO.findById(6);
		System.out.println(releaseOrders);
	}
	
	@Test
	public void countByUid(){
		int i = releaseOrdersDAO.countByUid(9);
		System.out.println(i);
	}
}
