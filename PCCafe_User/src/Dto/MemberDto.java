package Dto;

public class MemberDto {

	private int userNum;		// 외원번호 
	private int r_time;  		// remaining time : 남은 시간
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
	
	public MemberDto(String id, String pass, String name, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.phone = phone;
	}

	public MemberDto(int userNum, int r_time, String id, String pass, String name, String phone, String entry_date) {
		super();
		this.userNum = userNum;
		this.r_time = r_time;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.phone = phone;
		this.entry_date = entry_date;
	}

	public int getUserNum() {
		return userNum;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getR_time() {
		return r_time;
	}
	
	public void setR_time(int r_time) {
		this.r_time = r_time;
	}
}
