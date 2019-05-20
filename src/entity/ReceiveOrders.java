package entity;

public class ReceiveOrders {
	private Integer id;
	private ReleaseOrders releaseOrders;
	private User user;
	private Integer status;
	private String receiveTime;
	public ReceiveOrders(Integer id, ReleaseOrders releaseOrders, User user, Integer status, String receiveTime) {
		super();
		this.id = id;
		this.releaseOrders = releaseOrders;
		this.user = user;
		this.status = status;
		this.receiveTime = receiveTime;
	}
	@Override
	public String toString() {
		return "ReceiveOrders [id=" + id + ", releaseOrders=" + releaseOrders + ", user=" + user + ", status=" + status
				+ ", receiveTime=" + receiveTime + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ReleaseOrders getReleaseOrders() {
		return releaseOrders;
	}
	public void setReleaseOrders(ReleaseOrders releaseOrders) {
		this.releaseOrders = releaseOrders;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	
	
	
}
