package entity;

public class User {
	private int uid;
	private School school;
	private String username;
	private String password;
	private String gender;
	private String phone;
	private String email;
	private int totalScore;
	private int appraiseNum;
	private int permission;
	public User(int uid, School school, String username, String password, String gender, String phone, String email,
			int totalScore, int appraiseNum, int permission) {
		super();
		this.uid = uid;
		this.school = school;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.totalScore = totalScore;
		this.appraiseNum = appraiseNum;
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", school=" + school + ", username=" + username + ", password=" + password
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", totalScore=" + totalScore
				+ ", appraiseNum=" + appraiseNum + ", permission=" + permission + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getAppraiseNum() {
		return appraiseNum;
	}
	public void setAppraiseNum(int appraiseNum) {
		this.appraiseNum = appraiseNum;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public User(int uid, String password) {
		super();
		this.uid = uid;
		this.password = password;
	}
	public User(int uid) {
		super();
		this.uid = uid;
	}
	
	
}
