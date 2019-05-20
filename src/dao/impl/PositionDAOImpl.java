package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PositionDAO;
import entity.Position;
import utils.DBUtil;

public class PositionDAOImpl implements PositionDAO {

	DBUtil dbUtil = new DBUtil();
	@Override
	public List<Position> findAll() {
		String sql ="select *from tab_position";
		ResultSet rs = dbUtil.query(sql);
		ArrayList<Position> list = new ArrayList<Position>();
		try {
			while(rs.next()){
				int pid = rs.getInt("pid");
				String pname=rs.getString("pname");
				Position position = new Position(pid, pname);
				list.add(position);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deletePositionById(int pid) {
		String sql="DELETE FROM `campuspt`.`tab_position` WHERE `pid` =?";
		return dbUtil.update(sql, pid);

	}

	@Override
	public int updatePosition(Position position) {
		String sql="UPDATE `campuspt`.`tab_position` SET `pname` = ? WHERE `pid` = ?";
		return dbUtil.update(sql, position.getPname(),position.getPid());
	}

	@Override
	public int addPosition(Position position) {
		String sql = "INSERT INTO `campuspt`.`tab_position`(`pname`) VALUES (?)";
		return dbUtil.update(sql, position.getPname());

	}

	@Override
	public Position findPositionById(int pid) {
		String sql = "select *from tab_position where pid=?";
		ResultSet rs = dbUtil.query(sql, pid);
		Position position = null;
		try {
			while(rs.next()){
				String pname=rs.getString("pname");
				position=new	Position(pid, pname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return position;
	}

	@Override
	public Position findPositionByName(String pname) {
		String sql = "select *from tab_position where pname=?";
		ResultSet rs = dbUtil.query(sql, pname);
		Position position = null;
		try {
			while(rs.next()){
				Integer pid=rs.getInt("pid");
				position=new	Position(pid, pname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return position;
	}
}
