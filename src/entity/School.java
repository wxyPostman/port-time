package entity;



public class School {
	private Integer sid;	//学校编号
	private String sname; 	//学校名
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public School(Integer sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "School [sid=" + sid + ", sname=" + sname + "]";
	}
	public School(Integer sid) {
		super();
		this.sid = sid;
	}
	
	
	
}
