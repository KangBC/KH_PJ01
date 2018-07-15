package Controller;

public class BbsController {
<<<<<<< HEAD
	
	BbsDaoService bbsService = new BbsDaoService();
	
	//DB에 저장된 게시글 목록을 전부 가져온다.
	public void getBbsList() {
		List<BbsDto> list = bbsService.getBbsList();
		new BbsListView(list);
	}
	
	//DB에 해당 게시글이 있는지 검색
	public void getBbsFindList(String fStr, String fword){
		List<BbsDto> list = bbsService.getFindList(fStr.trim(), fword);
		
		if(list.size() == 0 || fStr.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "데이터를 찾을 수 없습니다");
			List<BbsDto> _list = bbsService.getBbsList();
			new BbsListView(_list);
		}else {
			new BbsListView(list);
		}				
	}
	
	public void bbsDetail(int seq) {
		bbsService.readCount(seq);	
		BbsDto dto = bbsService.getBBS(seq);			
		new BbsDetailView(dto);
	}
	
	public void bbsWrite() {
		new BbsAddView();
	}
	
	//게시글 글쓰기
	public void bbsWriteAf(BbsDto dto){
		boolean b = bbsService.writeBbs(dto);
		if(b){			
			JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다");
			getBbsList();
		}else{
			JOptionPane.showMessageDialog(null, "추가되지 못했습니다");
			bbsWrite();
		}
	}
	
	public void bbsDelete(int seq) {
		boolean b =  bbsService.bbsDelete(seq);
		if(b){
			JOptionPane.showMessageDialog(null, "성공적으로 삭제되었습니다");
			getBbsList();
		}else{
			JOptionPane.showMessageDialog(null, "삭제하지 못했습니다");
			bbsDetail(seq);
		}
	}
	
	
	public void bbsUpdate(int seq) {
		BbsDto dto = bbsService.getBBS(seq);
		new BbsUpateview(dto);
	}
	
	//게시글 수정
	public void bbsUpdateAf(int seq, String title, String content) {
		boolean b = bbsService.bbsUpdate(seq, title, content);
		if(b) {
			JOptionPane.showMessageDialog(null, "성공적으로 수정되었습니다");
			getBbsList();
		}else {
			JOptionPane.showMessageDialog(null, "수정되지 못했습니다");
			BbsDto dto = bbsService.getBBS(seq);
			new BbsUpateview(dto);
		}
	}
=======

>>>>>>> origin/Hyeonseok
}




