package entity;

public class Admin {
public Integer id;
public String adminName;
public String password;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Admin(Integer id, String adminName, String password) {
	super();
	this.id = id;
	this.adminName = adminName;
	this.password = password;
}

@Override
public String toString() {
	return "Admin [id=" + id + ", adminName=" + adminName + ", password=" + password + "]";
}

}
