package Serviece;

import java.util.List;

import Dao.BbsDao;
import Dto.BbsDto;


public class BbsServiece {

	BbsDao dao = new BbsDao();
	
	//게시판 리스트
	public List<BbsDto> getBbsList() {		
		return dao.getList();
	}
	
    //검색
	public List<BbsDto> getFindList(String column, String contain){		
		return dao.serchPost(column, contain);	
	}

	//게시글 번호
	public BbsDto getBBS(int seq) {		
		return dao.getPost(seq);		
	}

	//게시글 조회수
	public void readCount(int seq) {
		dao.addReadCount(seq);		
	}

	//글쓰기
	public boolean writeBbs(BbsDto dto) {
		return dao.addPost(dto);		
	}

	//게시글 삭제
	public boolean bbsDelete(int seq) {		
		return dao.deletePost(seq);		
	}

	//게시글 수정
	public boolean bbsUpdate(int seq, String title, String content) {		
		return dao.updatePost(seq, title, content);		
	}
	

}
