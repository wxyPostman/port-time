package entity;

public class ReleaseOrders {
	private Integer oid;
	private School school;
	private Position position;
	private String title;
	private String description;
	private String payMethod;
	private Integer recruitNum;
	private String releaseTime;
	private User user;
	private Double salary;
	private Integer status;
	public ReleaseOrders(Integer oid, School school, Position position, String title, String description,
			String payMethod, Integer recruitNum, String releaseTime, User user, Double salary, Integer status) {
		super();
		this.oid = oid;
		this.school = school;
		this.position = position;
		this.title = title;
		this.description = description;
		this.payMethod = payMethod;
		this.recruitNum = recruitNum;
		this.releaseTime = releaseTime;
		this.user = user;
		this.salary = salary;
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReleaseOrders [oid=" + oid + ", school=" + school + ", position=" + position + ", title=" + title
				+ ", description=" + description + ", payMethod=" + payMethod + ", recruitNum=" + recruitNum
				+ ", releaseTime=" + releaseTime + ", user=" + user + ", salary=" + salary + ", status=" + status + "]";
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public Integer getRecruitNum() {
		return recruitNum;
	}
	public void setRecruitNum(Integer recruitNum) {
		this.recruitNum = recruitNum;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public ReleaseOrders(Integer oid) {
		super();
		this.oid = oid;
	}
	
	
	
}
