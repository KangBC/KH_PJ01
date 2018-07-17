package Dto;

public class MemberDto {

	private int userNum;		// 회원번호 
	private int remainTime;  	// 남은 시간
	private String id;			// 회원 id
	private String pass;		// 회원 password
	private String name;		// 회원 이름
	private String phone;		// 전화번호
	private String entry_date;	// 외원가입 날짜
	
	public MemberDto() {
	
	}
	
	public MemberDto(String id, String pass) {	
		super();
		this.id = id;
		this.pass = pass;
	}
	
	public MemberDto(int userNum, int r_time, String id) {
		super();
		this.userNum = userNum;
		this.remainTime = r_time;
		this.id = id;
	}

	public MemberDto(String id, String pass, String name, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.phone = phone;
	}

	public int getUserNum() {
		return userNum;
	}
	
	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}
	
	public int getR_time() {
		return remainTime;
	}
	
	public void setR_time(int rTime) {
		this.remainTime = rTime;
	}

	public String getPhone() {
		return phone;
	}
}
