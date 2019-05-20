package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dao.SchoolDAO;
import dao.UserDAO;
import entity.School;
import entity.User;
import utils.DBUtil;

public class UserDAOImpl implements UserDAO{
	DBUtil dbUtil = new DBUtil();
	SchoolDAO schoolDAO = new SchoolDAOImpl(); 
	@Override
	public List<User> findAll() {
		String sql="select *from tab_user";
		ResultSet rs = dbUtil.query(sql);
		List<User> userlist = new ArrayList<User>();
		try {
			while(rs.next()){
				handleUserList(rs, userlist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userlist;
	}

	private void handleUserList(ResultSet rs, List<User> userlist) throws SQLException {
		int uid = rs.getInt("uid");
		int sid = rs.getInt("sid");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String gender = rs.getString("gender");
		String phone = rs.getString("phone");
		String email=rs.getString("email");
		int  totalScore = rs.getInt("totalscore");
		int  appraiseNum = rs.getInt("appraisenum");
		int permission =rs.getInt("permission");
		School school = schoolDAO.findById(sid);
		User user = new User(uid, school, username, password, gender, phone, email, totalScore, appraiseNum,permission);
		userlist.add(user);
	}

	@Override
	public User findUserById(int uid) {
		String sql="select *from tab_user where uid=?";
		ResultSet rs = dbUtil.query(sql, uid);
		User user = null;
		try {
			while(rs.next()){
				int sid = rs.getInt("sid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email=rs.getString("email");
				int  totalScore = rs.getInt("totalscore");
				int appraiseNum = rs.getInt("appraisenum");
				int permission =rs.getInt("permission");
				School school = schoolDAO.findById(sid);
				user = new User(uid, school, username, password, gender, phone, email, totalScore, appraiseNum,permission);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User>  findByUsername(String username) {
		String sql="select *from tab_user where username like ?";
		ResultSet rs = dbUtil.query(sql,"%"+username+"%");
		List<User> userlist = new ArrayList<User>();
		try {
			while(rs.next()){
				handleUserList(rs, userlist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userlist;
	}



	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO `campuspt`.`tab_user`(`sid`, `username`, `password`, `gender`, `phone`, `email`, `totalscore`,`appraisenum`, `permission`) VALUES (?,?,?,?,?,?,?,?,?)";
		return dbUtil.update(sql, user.getSchool().getSid(),user.getUsername(),user.getPassword(),user.getGender(),user.getPhone(),user.getEmail(),user.getTotalScore(),user.getAppraiseNum(),user.getPermission());
	}

	@Override
	public int deleteById(int uid) {
		String sql="DELETE FROM `campuspt`.`tab_user` WHERE `uid` =?";
		return dbUtil.update(sql, uid);
	}

//	@Override
//	public int updateUserByUsername(User user) {
//	
//		return 0;
//	}

//	@Override
//	public int updateUser(User user) {
//		//String sql ="UPDATE `campuspt`.`user` SET sid=?,gender=?,phone=?,email=? WHERE `uid` = 4"
//		return 0;
//	}

	public int updatePwd(Integer uid,String password) {
		String sql="UPDATE `campuspt`.`tab_user` SET `password` = ? WHERE `uid` = ?";	
		return dbUtil.update(sql, password,uid);
	}

	@Override
	public int updateUser(User user) {
		String sql="UPDATE `campuspt`.`tab_user` SET `sid` = ?, `username` = ?, `password` = ?, `gender` = ?, `phone` = ?, `email` = ?, `totalscore` = ?, `appraisenum` = ?, `permission` = ? WHERE `uid` = ? ";
		int i = dbUtil.update(sql, user.getSchool().getSid(),user.getUsername(),user.getPassword(),user.getGender(),user.getPhone(),user.getEmail(),user.getTotalScore(),user.getAppraiseNum(),user.getPermission(),user.getUid());
		return i;
	}

	@Override
	public int countByUserName(String username) {
		String sql="select count(*) from tab_user where username=?";
		ResultSet resultSet = dbUtil.query(sql, username);
		int count =1;
		try{
			while(resultSet.next()){
				count=resultSet.getInt(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	@Override
	public int countByPhone(String phone) {
		String sql="select count(*) from tab_user where phone=?";
		ResultSet resultSet = dbUtil.query(sql, phone);
		int count=1;
		try{
			while(resultSet.next()){
				count=resultSet.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	@Override
	public int count() {
		String sql="select count(*) from tab_user";
		int count=0;
		ResultSet resultSet = dbUtil.query(sql);
		try {
			while(resultSet.next()){
				count+=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	@Override
	public User findUserByUsername(String username) {
		String sql="select *from tab_user where username=?";
		ResultSet rs = dbUtil.query(sql, username);
		User user = null;
		try {
			while(rs.next()){
				int sid = rs.getInt("sid");
				Integer uid = rs.getInt("uid");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email=rs.getString("email");
				int  totalScore = rs.getInt("totalscore");
				int appraiseNum = rs.getInt("appraisenum");
				int permission =rs.getInt("permission");
				School school = schoolDAO.findById(sid);
				user = new User(uid, school, username, password, gender, phone, email, totalScore, appraiseNum,permission);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int findTotalScore(Integer uid) {
		String sql="select `totalscore` from tab_user where uid= ?";
		ResultSet rs = dbUtil.query(sql, uid);
		Integer totalScore=null;
		try {
			while(rs.next()){
				totalScore=rs.getInt("totalscore");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalScore;
	}

	@Override
	public int findAppraiseNum(Integer uid) {
		String sql="select `appraisenum` from tab_user where uid= ?";
		ResultSet rs = dbUtil.query(sql, uid);
		Integer appraiseNum=null;
		try {
			while(rs.next()){
				appraiseNum=rs.getInt("appraisenum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appraiseNum;

	}
}
