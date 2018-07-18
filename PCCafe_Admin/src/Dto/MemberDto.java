package Dto;

public class MemberDto {

	private String id;			// 회원 id
	private String pass;		// 회원 password
	private int r_time;  		// remaining time : 남은 시간
	
	
	public MemberDto() {
		r_time = -1;
	}
	
	public MemberDto(String id, String pass, String name, String phone) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public MemberDto(String id, int r_time) {
		super();
		this.id = id;
		this.r_time = r_time;
	}

	public String getId() {
		return id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getR_time() {
		return r_time;
	}
	
	public void setR_time(int r_time) {
		this.r_time = r_time;
	}
}

