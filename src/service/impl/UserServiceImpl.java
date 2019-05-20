package service.impl;

import java.util.List;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO userDAO = new UserDAOImpl();
	@Override
	public List<User> findAll() {
		List<User> list = userDAO.findAll();
		return list;
	}

	@Override
	public User findUserById(int uid) {
		User user = userDAO.findUserById(uid);
		return user;
	}

	@Override
	public List<User> findByUsername(String username) {
		 List<User> list = userDAO.findByUsername(username);
		return list;
	}

	@Override
	public boolean addUser(User user) {
		int i = userDAO.addUser(user);
		return i==1?true:false;
	}

	@Override
	public boolean deleteById(int uid) {
		int i = userDAO.deleteById(uid);
		return i==1?true:false;
	}

	@Override
	public boolean updateUser(User user) {
		int i = userDAO.updateUser(user);
		return i==1?true:false;
	}

	@Override
	public boolean updatePwd(Integer uid,String password) {
		int i = userDAO.updatePwd(uid,password);
		return i==1?true:false;
	}

	@Override
	public boolean countByPhone(String phone) {
		int i = userDAO.countByPhone(phone);
		return i==0?true:false;
	}

	@Override
	public boolean countByUserName(String username) {
		int i = userDAO.countByUserName(username);
		return i==1?false:true;
	}

	@Override
	public int count() {
		int count = userDAO.count();
		return count;
	}

	@Override
	public User findUserByUsername(String username) {
		User user =userDAO.findUserByUsername( username);
		return user;
	}

	@Override
	public int findTotalScore(Integer uid) {
		int totalScore = userDAO.findTotalScore(uid);
		return totalScore;
	}

	@Override
	public int findAppraiseNum(Integer uid) {
		int appraiseNum = userDAO.findAppraiseNum(uid);
		return appraiseNum;
	}

}
