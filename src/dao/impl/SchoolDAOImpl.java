package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SchoolDAO;
import entity.School;
import utils.DBUtil;

public class SchoolDAOImpl implements SchoolDAO {

	DBUtil dbUtil = new DBUtil();
	@Override
	public List<School> findAll() {
		String sql = "select *from tab_school";
		ResultSet rs = dbUtil.query(sql);
		ArrayList<School> list = new ArrayList<School>();
		try {
			while(rs.next()){
				int sid = rs.getInt("sid");
				String sname=rs.getString("sname");
				School school = new School(sid, sname);
				list.add(school);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addSchool(School school) {
		String sql = "INSERT INTO `campuspt`.`tab_school`(`sname`) VALUES (?)";
		return dbUtil.update(sql, school.getSname());

	}

	@Override
	public int deleteSchoolById(int sid) {
		String sql="DELETE FROM `campuspt`.`tab_school` WHERE `sid` =?";
		return dbUtil.update(sql, sid);
	}

	@Override
	public int updateSchool(School school) {
		String sql="UPDATE `campuspt`.`tab_school` SET `sname` = ? WHERE `sid` = ?";
		return dbUtil.update(sql, school.getSname(),school.getSid());
	}

	@Override
	public School findById(int sid) {
		String sql = "select *from tab_school where sid=?";
		ResultSet rs = dbUtil.query(sql, sid);
		School school = null;
		try {
			while(rs.next()){
				String sname=rs.getString("sname");
				school=new School(sid, sname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return school;
	}

	@Override
	public School findBySname(String sname) {
		String sql = "select *from tab_school where sname=?";
		ResultSet rs = dbUtil.query(sql, sname);
		School school = null;
		try {
			while(rs.next()){
				Integer sid =rs.getInt("sid");
				school=new School(sid, sname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return school;
	}

}
