package Dto;

public class BbsDto {

	private int postNum;			// 게시글 번호
	private int del;				// 게시글이 삭제되었는지 여부
	private int notice;				// 공지글인지 아닌지 여부 - ***********user의 글이므로 공지가 아님을 나타내줘야함.
	
	private String userName;		// 작성자 
	private String title;			// 게시글 제목
	private String content;			// 게시글 내용
	private String readCount;		// 게시글 조회수
	private String createdDate;		// 게시글 작성일
	
	public BbsDto() {
	}
	
	public BbsDto(int postNum, String title, String content) {					// 게시글 수정할 때
		super();
		this.postNum = postNum;
		this.title = title;
		this.content = content;
	}
	
	public BbsDto(String userName, String title, String content) {		//게시글 작성할 때
		super();
		this.userName = userName;
		this.title = title;
		this.content = content;
	}

	public BbsDto(int postNum, int del, int notice, String userName, String title, String content, String readCount, String createdDate) {	// 게시글 가져올 때
		super();
		this.postNum = postNum;
		this.del = del;
		this.notice = notice;

		this.userName = userName;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.createdDate = createdDate;
	}

	public int getPostNum() {
		return postNum;
	}

	public String getUserName() {
		return userName;
	}

	public int getDel() {
		return del;
	}

	public int getNotice() {
		return notice;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getReadCount() {
		return readCount;
	}

	public String getCreatedDate() {
		return createdDate;
	}
}
