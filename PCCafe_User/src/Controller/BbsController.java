package Controller;

import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

import Dto.BbsDto;
import Serviece.BbsServiece;
import View.BbsAddView;
import View.BbsDetailView;
import View.BbsListView;
import View.BbsUpateview;
import View.ChatView;
import View.OrderView;

public class BbsController {

	private static final Socket Socket = null;
	BbsListView bbsLV = null;
	BbsDetailView bbsDV = null;
	BbsServiece bbsService = new BbsServiece();

	// DB에 저장된 게시글 목록을 전부 가져온다.
	public List<BbsDto> getBbsList() {
		return bbsService.getBbsList();
	}
	
	public void repaintBbsList() {
		bbsLV.repaintBBS();
	}
	public void drawBbsList() {
		List<BbsDto> list = bbsService.getBbsList();
		if (bbsLV == null) {
			bbsLV = new BbsListView(list);
		} else {
			bbsLV = null;
			bbsLV = new BbsListView(list);
		}
	}

	// DB에 해당 게시글이 있는지 검색
	public void getBbsFindList(String column, String contain) {
		List<BbsDto> list = bbsService.getFindList(column.trim(), contain);

		if (list.size() == 0 || contain.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "데이터를 찾을 수 없습니다");
			List<BbsDto> _list = bbsService.getBbsList();
			new BbsListView(list);
		} else {
			new BbsListView(list);
		}
	}

	public void bbsDetail(int seq) {
		bbsService.readCount(seq);
		BbsDto dto = bbsService.getBBS(seq);

		repaintBbsList();
		if (bbsDV == null) {
			bbsDV = new BbsDetailView(dto);
		} else {
			bbsDV.dispose();
			bbsDV = new BbsDetailView(dto);
		}
	}

	// 게시글 글쓰기 view
	public void bbsWrite() {
		new BbsAddView();
	}

	// 게시글 글쓰기
	public void bbsWriteAf(BbsDto dto) {
		boolean b = bbsService.writeBbs(dto);
		if (b) {
			JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다");
			drawBbsList();
		} else {
			JOptionPane.showMessageDialog(null, "추가되지 못했습니다");
			bbsWrite();
		}
	}

	// 삭제
	public void bbsDelete(int seq) {
		boolean b = bbsService.bbsDelete(seq);
		if (b) {
			JOptionPane.showMessageDialog(null, "성공적으로 삭제되었습니다");
			drawBbsList();
		} else {
			JOptionPane.showMessageDialog(null, "삭제하지 못했습니다");
			bbsDetail(seq);
		}
	}

	// 게시글 view
	public void bbsUpdate(int seq) {
		BbsDto dto = bbsService.getBBS(seq);
		new BbsUpateview(dto);
	}

	// 게시글 수정
	public void bbsUpdateAf(int seq, String title, String content) {
		boolean b = bbsService.bbsUpdate(seq, title, content);
		if (b) {
			JOptionPane.showMessageDialog(null, "성공적으로 수정되었습니다");
			drawBbsList();
		} else {
			JOptionPane.showMessageDialog(null, "수정되지 못했습니다");
			BbsDto dto = bbsService.getBBS(seq);
			new BbsUpateview(dto);
		}
	}

	// ControlView 공간

}
