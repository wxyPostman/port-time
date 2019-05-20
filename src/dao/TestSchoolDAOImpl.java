package dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;



import dao.impl.SchoolDAOImpl;
import entity.School;

public class TestSchoolDAOImpl {
SchoolDAO schoolDAO ;
	
	@Before
	public void init(){
		schoolDAO = new SchoolDAOImpl();
	}
	
	@Test
	public void testfindAll(){
		List<School> list = schoolDAO.findAll();
		list.forEach(System.out::println);
	}
	
	@Test
	public void testaddSchool(){
		School school = new School(0, "浙江理工大学");
		int i = schoolDAO.addSchool(school);
		System.out.println(i);
	}
	
	@Test
	public void testupdateSchool(){
		School school = new School(2, "浙江大学");
		int i = schoolDAO.updateSchool(school);
		System.out.println(i);
	}
	
	@Test
	public void testdeleteSchoolById(){
		int i = schoolDAO.deleteSchoolById(4);
		System.out.println(i);
	}
}
