package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dao.PositionDAO;
import dao.ReleaseOrdersDAO;
import dao.SchoolDAO;
import dao.UserDAO;
import entity.Position;
import entity.ReleaseOrders;
import entity.School;
import entity.User;
import utils.DBUtil;

public class ReleaseOrdersDAOImpl implements ReleaseOrdersDAO {
	DBUtil dbUtil = new DBUtil();
	SchoolDAO schoolDAO=new SchoolDAOImpl();
	PositionDAO positionDAO = new PositionDAOImpl();
	UserDAO userDAO = new UserDAOImpl();
	@Override
	public int save(ReleaseOrders releaseOrders) {
		String sql="INSERT INTO `campuspt`.`tab_releaseorders`(`sid`, `pid`, `title`, `description`, `paymethod`, `recruitnum`, `releasetime`, `uid`, `salary`, `status`) VALUES (?,?,?,?,?,?,?,?,?,?)";
		int i = dbUtil.update(sql,releaseOrders.getSchool().getSid(),releaseOrders.getPosition().getPid(),releaseOrders.getTitle(),releaseOrders.getDescription(),
				releaseOrders.getPayMethod(),releaseOrders.getRecruitNum(),releaseOrders.getReleaseTime(),releaseOrders.getUser().getUid(),releaseOrders.getSalary(),releaseOrders.getStatus());
		return i;
	}

	@Override
	public int update(ReleaseOrders releaseOrders) {
		String sql = "UPDATE `campuspt`.`tab_releaseorders` SET `sid` = ?, `pid` = ?, `title` = ?, `description` = ?, `paymethod` = ?, `recruitnum` = ?, `releasetime` = ?, `uid` = ?, `salary` = ?, `status` = ? WHERE `oid` = ?";
		int i = dbUtil.update(sql, releaseOrders.getSchool().getSid(),releaseOrders.getPosition().getPid(),releaseOrders.getTitle(),releaseOrders.getDescription(),releaseOrders.getPayMethod(),releaseOrders.getRecruitNum(),releaseOrders.getReleaseTime(),releaseOrders.getUser().getUid(),releaseOrders.getSalary(),releaseOrders.getStatus(),releaseOrders.getOid());
		return i;
	}

	@Override
	public List<ReleaseOrders> findAll() {
		String sql="select * from tab_releaseorders ORDER BY releasetime desc";
		ResultSet rs = dbUtil.query(sql);
		List<ReleaseOrders> list = new ArrayList<ReleaseOrders>();
		handOrdersList(rs, list);
		return list;
	}

	private void handOrdersList(ResultSet rs, List<ReleaseOrders> list) {
		try {
			while(rs.next()){
				int oid =rs.getInt("oid");
				int sid = rs.getInt("sid");
				int pid = rs.getInt("pid");
				String title = rs.getString("title");
				String description =rs.getString("description");
				String payMethod  =rs.getString("paymethod");
				int recruitNum  = rs.getInt("recruitNum");
				String releaseTime = rs.getString("releasetime");
				int uid = rs.getInt("uid");
				Double salary = rs.getDouble("salary");
				int status = rs.getInt("status");
				User user = userDAO.findUserById(uid);
				School school = schoolDAO.findById(sid);
				Position position =positionDAO.findPositionById(pid);
				
				ReleaseOrders releaseOrders = new ReleaseOrders(oid, school, position, title, description, payMethod, recruitNum, releaseTime, user, salary, status);
				list.add(releaseOrders);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int deleteById(Integer id) {
		String sql="DELETE FROM `campuspt`.`tab_releaseorders` WHERE `oid` = ?";
		int i = dbUtil.update(sql, id);
		return i;
	}

	@Override
	public ReleaseOrders findById(Integer id) {
		String sql="select * from tab_releaseorders where oid=? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.query(sql, id);
		return handleOrders(rs);
	}

	private ReleaseOrders handleOrders(ResultSet rs) {
		ReleaseOrders releaseOrders=null;
		try {
			while(rs.next()){
				int oid =rs.getInt("oid");
				int sid = rs.getInt("sid");
				int pid = rs.getInt("pid");
				String title = rs.getString("title");
				String description =rs.getString("description");
				String payMethod  =rs.getString("paymethod");
				int recruitNum  = rs.getInt("recruitNum");
				String releaseTime = rs.getString("releasetime");
				int uid = rs.getInt("uid");
				Double salary = rs.getDouble("salary");
				int status = rs.getInt("status");
				User user = userDAO.findUserById(uid);
				School school = schoolDAO.findById(sid);
				Position position =positionDAO.findPositionById(pid);
				
				releaseOrders = new ReleaseOrders(oid, school, position, title, description, payMethod, recruitNum, releaseTime, user, salary, status);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return releaseOrders;
	}

	@Override
	public List<ReleaseOrders> findByTitle(String title) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		title="%"+title+"%";
		String sql="select * from tab_releaseorders where title like ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.query(sql, title);
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findByPid(Integer pid) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where pid = ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.query(sql, pid);
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySid(Integer sid) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where sid = ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.query(sql, sid);
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySidAndPid(Integer sid, Integer pid) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where sid like ? and pid like ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.query(sql, "%"+sid+"%","%"+pid+"%");
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findByPiTi(Integer pid,String title) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where  pid = ? and title like ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.query(sql, pid,"%"+title+"%");
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySiTi(Integer sid,String title) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where  sid = ? and title like ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.query(sql, sid,"%"+title+"%");
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySiPiTi(Integer sid, Integer pid,String title) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where sid =? and pid =? and title like ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.query(sql, sid,pid,"%"+title+"%");
		handOrdersList(rs, list);
		return list;
	}
	
	
	@Override
	public List<ReleaseOrders> findAllByPage(Integer currentPage, Integer pageSize) {
		String sql="select * from tab_releaseorders ORDER BY releasetime desc";
		ResultSet rs = dbUtil.queryByPage(sql, currentPage, pageSize);
		List<ReleaseOrders> list = new ArrayList<ReleaseOrders>();
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public int count() {
		String sql ="select count(*) from tab_releaseorders";
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
	public List<ReleaseOrders> findByPidPage(Integer pid, Integer currentPage, Integer pageSize) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where  pid= ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.queryByPage(sql, currentPage, pageSize,pid);
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySidPage(Integer sid, Integer currentPage, Integer pageSize) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where sid = ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.queryByPage(sql, currentPage, pageSize, sid);
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySidAndPidPage(Integer sid, Integer pid, Integer currentPage, Integer pageSize) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where sid = ? and pid= ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.queryByPage(sql, currentPage, pageSize, sid,pid);
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findByPiTiPage(Integer pid,String title,  Integer currentPage, Integer pageSize) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where  pid= ? and title like ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.queryByPage(sql, currentPage, pageSize,pid,"%"+title+"%");
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySiTiPage(Integer sid,String title, Integer currentPage,  Integer pageSize) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where  sid= ? and title like ?  ORDER BY releasetime desc";
		ResultSet rs = dbUtil.queryByPage(sql, currentPage, pageSize,sid,"%"+title+"%");
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySiPiTiPage(Integer sid, Integer pid, String title, Integer currentPage,
			Integer pageSize) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		String sql="select * from tab_releaseorders where  pid= ? and sid=? and title like ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.queryByPage(sql, currentPage, pageSize,pid,sid,"%"+title+"%");
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findTitleByPage(String title, Integer currentPage, Integer pageSize) {
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		title="%"+title+"%";
		String sql="select * from tab_releaseorders where title like ? ORDER BY releasetime desc";
		ResultSet rs = dbUtil.queryByPage(sql, currentPage, pageSize, title);
		handOrdersList(rs, list);
		return list;
	
	}

	@Override
	public int countByUid(Integer uid) {
		String sql ="select count(*) from tab_releaseorders where uid =?";
		ResultSet rs = dbUtil.query(sql,uid);
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
	public List<ReleaseOrders> findThree(Integer uid) {
		String sql="SELECT * FROM `campuspt`.`tab_releaseorders` where uid = ?   ORDER BY releasetime desc LIMIT 0, 3";
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		ResultSet rs = dbUtil.query(sql, uid);
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public List<ReleaseOrders> findByUid(Integer uid) {
		String sql="SELECT * FROM `campuspt`.`tab_releaseorders` where uid = ?   ORDER BY releasetime desc ";
		List<ReleaseOrders> list=new ArrayList<ReleaseOrders>();
		ResultSet rs = dbUtil.query(sql, uid);
		handOrdersList(rs, list);
		return list;
	}

	@Override
	public int deleteByUid(Integer uid) {
		String sql="DELETE FROM `campuspt`.`tab_releaseorders` WHERE `uid` = ?";
		int i = dbUtil.update(sql, uid);
		return i;
	}

	

}
