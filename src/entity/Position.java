package entity;

public class Position {
	private Integer pid; 	//职位分类编号
	private String pname;	 //职位分类名称
	@Override
	public String toString() {
		return "Position [pid=" + pid + ", pname=" + pname + "]";
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Position(Integer pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}
	public Position(Integer pid) {
		super();
		this.pid = pid;
	}

	
}
