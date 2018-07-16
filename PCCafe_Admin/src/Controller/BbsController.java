package Controller;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JOptionPane;

import Dto.BbsDto;
import Serviece.BbsDaoService;
import View.BbsAddView;
import View.BbsDetailView;
import View.BbsListView;
import View.BbsUpateview;
import View.ChatView;
import View.OrderListView사용안함;
import View.OrderView;
import View.UserDetailView;

public class BbsController {

	BbsListView bbsLV = null;
	BbsDetailView bbsDV = null;
	BbsDaoService bbsService = new BbsDaoService();

	// DB에 저장된 게시글 목록을 전부 가져온다.
	public List<BbsDto> getBbsList() {
		List<BbsDto> list = bbsService.getBbsList();

		if (bbsLV == null) {
			bbsLV = new BbsListView(list);
		} else {
			bbsLV.dispose();
			bbsLV = new BbsListView(list);
		}
		return list;
	}

	// DB에 해당 게시글이 있는지 검색
	public void getBbsFindList(String column, String contain) {

		List<BbsDto> list = bbsService.getFindList(column.trim(), contain);
		System.out.println("List<BbsDto> list");
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

		if (bbsDV == null) {
			bbsDV = new BbsDetailView(dto);
		} else {
			bbsDV.dispose();
			bbsDV = new BbsDetailView(dto);
		}
	}

	// 게시글 뷰
	public void bbsWrite() {
		new BbsAddView();
	}

	// 게시글 글쓰기
	public void bbsWriteAf(BbsDto dto) {
		boolean b = bbsService.writeBbs(dto);
		if (b) {
			JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다");
			getBbsList();
		} else {
			JOptionPane.showMessageDialog(null, "추가되지 못했습니다");
			bbsWrite();
		}
	}

	public void bbsDelete(int seq) {
		boolean b = bbsService.bbsDelete(seq);
		if (b) {
			JOptionPane.showMessageDialog(null, "성공적으로 삭제되었습니다");
			getBbsList();
		} else {
			JOptionPane.showMessageDialog(null, "삭제하지 못했습니다");
			bbsDetail(seq);
		}
	}

	// 게시글 수정
	public void bbsUpdate(int seq) {
		BbsDto dto = bbsService.getBBS(seq);
		new BbsUpateview(dto);
	}

	// 게시글 수정
	public void bbsUpdateAf(int seq, String title, String content) {
		boolean b = bbsService.bbsUpdate(seq, title, content);
		if (b) {
			JOptionPane.showMessageDialog(null, "성공적으로 수정되었습니다");
			getBbsList();
		} else {
			JOptionPane.showMessageDialog(null, "수정되지 못했습니다");
			BbsDto dto = bbsService.getBBS(seq);
			new BbsUpateview(dto);
		}
	}

	// ControlView 공간

	// UserDetailView
	public void UserDetai() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetailView frame = new UserDetailView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	// 게시판 List view
	public void gasipanList() { // 객체 이름 변경예정

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BbsListView frame = new BbsListView(bbsService.getBbsList());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	// chatview
	public void chat() { 

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatView frame = new ChatView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// OrderView
	public void order() { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderView frame = new OrderView(bbsService.getBbsList());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
	
/*	// OrderListView
	public void orderList() { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderListView frame = new OrderListView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}*/
