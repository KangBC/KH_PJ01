package Dto;

public class member_Dto {
	private String id;
	private String pw;
	private int time;

	public member_Dto() {

	}

	public member_Dto(String id, String pw, int time) {
		super();
		this.id = id;
		this.pw = pw;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}