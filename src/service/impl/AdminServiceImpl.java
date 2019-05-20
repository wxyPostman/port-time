package service.impl;

import dao.AdminDAO;
import dao.impl.AdminDAOImpl;
import entity.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService{
public AdminDAO adminDAO=new AdminDAOImpl();
	@Override
	public Admin findByAdminname(String adminName) {
		Admin admin = adminDAO.findByAdminname(adminName);
		return admin;
	}

}
