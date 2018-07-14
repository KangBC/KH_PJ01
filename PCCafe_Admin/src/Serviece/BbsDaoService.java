package Serviece;

import java.util.List;

import Dao.BbsDao;
import Dto.BbsDto;


public class BbsDaoService {

	BbsDao dao = new BbsDao();
	
	
	public List<BbsDto> getBbsList() {		
		return dao.getList();
	}

	//추가예정  //리스트 검색 부분 DB가 없음 ㅂ;
	public List<BbsDto> getFindList(String fStr, String fword){		
		//return dao.getFindList(fStr, fword);	
		return null;
	}

	
	public BbsDto getBBS(int seq) {		
		return dao.getPost(seq);		
	}

	
	public void readCount(int seq) {
		dao.addReadCount(seq);		
	}

	
	public boolean writeBbs(BbsDto dto) {
		// TODO Auto-generated method stub오잉 이거 왜 에러안뜸?너가 수정함? 
		return dao.addPost(dto);		
	}

	
	public boolean bbsDelete(int seq) {		
		return dao.deletePost(seq);		
	}

	
	public boolean bbsUpdate(int seq, String title, String content) {		
		return dao.updatePost(seq, title, content);		
	}

}
