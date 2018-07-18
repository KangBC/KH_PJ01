package Controller;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import Dto.MemberDto;
import Serviece.MemeberServiece;
import View.ManageMemView;

public class MemberController {

	MemeberServiece memServiece = new MemeberServiece();

	// 회원정보 체크 유무 확인
	public MemberDto getSearchUser(String member_id) {

		MemberDto dto = memServiece.getMem(member_id);
		if (dto == null)
			JOptionPane.showMessageDialog(null, "유저가 없습니다.");
		return dto;
	}

	// 회원정보 pw 수정
	public void changePW(String id, String pw) {
		if (memServiece.changePW(id, pw)) {
			JOptionPane.showMessageDialog(null, "변경 성공");
		} else {
			JOptionPane.showMessageDialog(null, "변경 실패");
		}
	}

	// 회원정보view
	public void manager() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMemView frame = new ManageMemView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
