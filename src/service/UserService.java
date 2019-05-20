package service;

import java.util.List;

import entity.User;

public interface UserService {
	//查询所有用户
			public List<User> findAll();
			
			//通过Id查询用户
			public User findUserById(int uid);
			
			//通过用户名查询用户
			public List<User> findByUsername(String username);
			
//			//通过用户名查找用户是否存在
//			public int isExit(String username);
		//	
//			//判断用户名密码是否正确
//			public int isValid(User user);
			
			//添加用户
			public boolean addUser(User user);
			
			//通过id删除用户
			public boolean deleteById(int uid);
			
//			//通过用户名修改用户基本信息
//			public int updateUserByUsername(User user);
			
			//通过Id修改用户基本信息
			public boolean updateUser(User user);
			
			//通过Id修改用户密码
			public boolean updatePwd(Integer uid,String password);
			
//			分页查找所有用户
//			public List<User> findAllUsersByPage();
			
			public boolean countByPhone(String phone);
			
			public boolean countByUserName(String username);
			
			public int count();

			public User findUserByUsername(String username);
			
			public int findTotalScore(Integer uid);
			
			
			public int findAppraiseNum(Integer uid);
}
