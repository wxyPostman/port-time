package dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.impl.ReceiveOrdersDAOImpl;
import entity.ReceiveOrders;
import entity.ReleaseOrders;
import entity.User;

public class TestReceiveOrdersImpl {
	ReceiveOrdersDAO receiveOrdersDAO;
	
	@Before
	public void init(){
		receiveOrdersDAO = new ReceiveOrdersDAOImpl();
	}
	
	@Test
	public void testFindAll(){
		List<ReceiveOrders> list = receiveOrdersDAO.findAll();
		list.forEach(System.out::println);
	}
	
	@Test
	public void testSave(){
		for(int a=0;a<1;a++){
			ReleaseOrders releaseOrders = new ReleaseOrders(10);
			User  user = new User(7);
			ReceiveOrders receiveOrders = new ReceiveOrders(0, releaseOrders, user, 0,"2019-05-14");
			int i = receiveOrdersDAO.save(receiveOrders);
			System.out.println(i);
		}
	}
	
	@Test
	public void testDeleteById(){
		int i = receiveOrdersDAO.deleteById(3);
		System.out.println(i);
	}
	
	@Test
	public void testUpdate(){
		ReleaseOrders releaseOrders = new ReleaseOrders(6);
		User  user = new User(7);
		ReceiveOrders receiveOrders = new ReceiveOrders(1, releaseOrders, user, 0,"2019-05-15");
		int i = receiveOrdersDAO.update(receiveOrders);
		System.out.println(i);

	}
	
	@Test
	public void testFindById(){
		ReceiveOrders orders = receiveOrdersDAO.findById(1);
		System.out.println(orders);
	}
	
	@Test
	public void testCount(){
		int i = receiveOrdersDAO.count();
		System.out.println(i);
	}
	
} 
