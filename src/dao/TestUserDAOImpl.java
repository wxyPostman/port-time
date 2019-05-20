package dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.impl.UserDAOImpl;
import entity.School;
import entity.User;


public class TestUserDAOImpl {
	UserDAO userDAO ;
	
	@Before
	public void init(){
		userDAO=new UserDAOImpl();
	}
	
	
	@Test
	public void  testFindAll(){
		List<User> list = userDAO.findAll();
		list.forEach(System.out::println);
	}
	
	@Test
	public void testAddUser(){
		School school =new School(1);
		User user = new User(0, school, "yyy", "123456", "男", "18758157701", "123@qq.com", 90, 100, 0);
		int i = userDAO.addUser(user);
		System.out.println(i);
	}
	
	@Test
	public void testfindUserById(){
		User user = userDAO.findUserById(7);
		System.out.println(user);
	}
	
	
	@Test
	public void testdeleteUserById(){
		int i = userDAO.deleteById(8);
		System.out.println(i);
	}
	
	@Test
	public void testupdateUserPwd(){
		
		User user =new User(7,"666");
		//System.out.println(userDAO.updatePwd(user));
	}
}
