package dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.impl.PositionDAOImpl;
import entity.Position;

public class TestPositionDAOImpl {
PositionDAO positionDAO;
	
	@Before
	public void init(){
		positionDAO=new PositionDAOImpl();
	}
	
	@Test
	public void testfindAll(){
		List<Position> list = positionDAO.findAll();
		list.forEach(System.out::println);
	}
	
	@Test
	public void testaddSchool(){
		Position position = new Position(0, "分类1");
		int i = positionDAO.addPosition(position);
		System.out.println(i);
	}
	
	@Test
	public void testupdateSchool(){
		Position position = new Position(2, "分类1");
		int i = positionDAO.updatePosition(position);
		System.out.println(i);
	}
	
	@Test
	public void testdeleteSchoolById(){
		int i = positionDAO.deletePositionById(2);
		System.out.println(i);
	}
}
