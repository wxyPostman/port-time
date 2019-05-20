package entity;

public class JsonMsg {

	public final static int STATUS_SUCCESS = 200; // 成功标志
	public final static int STATUS_FAIL = 400; // 失败表示
	public final static int STATUS_ERROR = 500; // 服务出错
	public final static int STATUS_AUTH = 100; // 未授权服务

	private int status; // 标志位，代表处理结果
	private String msg; // 提示消息
	private Object data; // 数据

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonMsg(int status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public JsonMsg(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	// 处理成功消息
	public static JsonMsg makeSuccess(String msg, Object data) {
		JsonMsg jsonMsg = new JsonMsg();
		jsonMsg.status = STATUS_SUCCESS;
		jsonMsg.data = data;
		jsonMsg.msg = msg;
		return jsonMsg;
	}

	// 处理失败消息
	public static JsonMsg makeFail(String msg, Object data) {
		JsonMsg jsonMsg = new JsonMsg();
		jsonMsg.status = STATUS_FAIL;
		jsonMsg.data = data;
		jsonMsg.msg = msg;
		return jsonMsg;
	}
	// 处理认证失败的消息

}
