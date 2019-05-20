package dao;

import entity.Admin;

public interface AdminDAO {
	public Admin findByAdminname(String adminName);
}
