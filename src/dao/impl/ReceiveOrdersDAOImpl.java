package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import dao.ReceiveOrdersDAO;
import dao.ReleaseOrdersDAO;
import dao.UserDAO;
import entity.ReceiveOrders;
import entity.ReleaseOrders;
import entity.User;
import utils.DBUtil;

public class ReceiveOrdersDAOImpl implements ReceiveOrdersDAO {
	DBUtil dbUtil= new DBUtil();
	UserDAO userDAO = new UserDAOImpl();
	ReleaseOrdersDAO releaseOrderDAO = new ReleaseOrdersDAOImpl();
	@Override
	public int save(ReceiveOrders receiveOrders) {
		String sql ="INSERT INTO `campuspt`.`tab_receiveorders`(`oid`, `uid`, `status`,receivetime) VALUES (?,?, ?, ?)";
		int i = dbUtil.update(sql, receiveOrders.getReleaseOrders().getOid(),receiveOrders.getUser().getUid(),receiveOrders.getStatus(),receiveOrders.getReceiveTime());
		return i;
	}

	@Override
	public int deleteById(Integer id) {
		String sql="DELETE FROM `campuspt`.`tab_receiveorders` WHERE `id` = ?";
		int i = dbUtil.update(sql, id);
		return i;
	}

	@Override
	public int update(ReceiveOrders receiveOrders) {
		String sql="UPDATE `campuspt`.`tab_receiveorders` SET `oid` = ?, `uid` = ?, `status` = ? , where receivetime= ? WHERE `id` = ?";
		int i = dbUtil.update(sql,receiveOrders.getReleaseOrders().getOid(),receiveOrders.getUser().getUid(),receiveOrders.getStatus(),receiveOrders.getReceiveTime(),receiveOrders.getId() );
		return i;
	}

	@Override
	public int count() {
		String sql ="select count(*) from tab_receiveorders";
		ResultSet rs = dbUtil.query(sql);
		int count=0;
		try {
			while(rs.next()){
				 count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<ReceiveOrders> findAll() {
		String sql ="SELECT * FROM `campuspt`.`tab_receiveorders` by uid desc";
		ResultSet rs = dbUtil.query(sql);
		List<ReceiveOrders> list = new ArrayList<ReceiveOrders>();
		handleList(rs, list);
		return list;
	}

	private void handleList(ResultSet rs, List<ReceiveOrders> list) {
		try {
			while(rs.next()){
				int id=rs.getInt("id");
				int oid =rs.getInt("oid");
				int uid = rs.getInt("uid");
				int status =rs.getInt("status");
				String receiveTime = rs.getString("receivetime");
				ReleaseOrders releaseOrders =releaseOrderDAO.findById(oid);
				User user  = userDAO.findUserById(uid);
				ReceiveOrders receiveOrders = new  ReceiveOrders(id, releaseOrders, user, status,receiveTime);
				list.add(receiveOrders);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ReceiveOrders findById(Integer id) {
		String sql ="SELECT * FROM `campuspt`.`tab_receiveorders`  where id=? ";
		ResultSet rs = dbUtil.query(sql, id);
		return handleData(rs);
	}

	private ReceiveOrders handleData(ResultSet rs) {
		ReceiveOrders receiveOrders=null;
		try {
			while(rs.next()){
				int id=rs.getInt("id");
				int oid =rs.getInt("oid");
				int uid = rs.getInt("uid");
				int status =rs.getInt("status");
				String receiveTime =rs.getString("receivetime");
				ReleaseOrders releaseOrders =releaseOrderDAO.findById(oid);
				User user  = userDAO.findUserById(uid);
				receiveOrders = new  ReceiveOrders(id, releaseOrders, user, status,receiveTime);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receiveOrders;
	}

	@Override
	public List<ReceiveOrders> findByUid(Integer uid) {
		String sql ="SELECT * FROM `campuspt`.`tab_receiveorders` where uid =? order by uid desc";
		ResultSet rs = dbUtil.query(sql,uid);
		List<ReceiveOrders> list = new ArrayList<ReceiveOrders>();
		handleList(rs, list);
		return list;
	}

	@Override
	public int findByUOid(Integer uid, Integer oid) {
		String sql ="select count(*) from tab_receiveorders where uid=? and oid=?";
		ResultSet rs = dbUtil.query(sql,uid,oid);
		int count=0;
		try {
			while(rs.next()){
				 count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<ReceiveOrders> findByOid(Integer oid) {
		String sql ="SELECT * FROM `campuspt`.`tab_receiveorders` where oid =? order by receivetime desc";
		ResultSet rs = dbUtil.query(sql,oid);
		List<ReceiveOrders> list = new ArrayList<ReceiveOrders>();
		handleList(rs, list);
		return list;
	}

	@Override
	public int updateByStatus(Integer status,Integer id) {
		String sql ="UPDATE `campuspt`.`tab_receiveorders` SET `status` = ? WHERE `id` = ?";
		int i = dbUtil.update(sql, status,id);
		return i;
	}

	@Override
	public int countByStatus(Integer status) {
		String sql ="select count(*) from tab_receiveorders where status=?";
		ResultSet rs = dbUtil.query(sql,status);
		int count=0;
		try {
			while(rs.next()){
				count+=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return count;
	}

}
