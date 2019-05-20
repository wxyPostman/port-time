package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AdminDAO;
import entity.Admin;
import utils.DBUtil;

public class AdminDAOImpl implements AdminDAO {
	DBUtil dbUtil = new DBUtil();

	@Override
	public Admin findByAdminname(String adminName) {
		Admin admin=null;
		String sql="select *from tab_admin where adminname=?";
		ResultSet resultSet = dbUtil.query(sql, adminName);
		try {
			while (resultSet.next()) {
				int id=resultSet.getInt("id");
				String adminname = resultSet.getString("adminname");
				String password = resultSet.getString("password");
			 
				admin=new Admin(id, adminname, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return admin ;
	}

}
