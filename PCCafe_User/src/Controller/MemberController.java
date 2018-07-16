package Controller;

import javax.swing.JOptionPane;

import Dao.MemberDao;
import Dto.MemberDto;
import Serviece.MemeberServiece;
import Singleton.Singleton;
import View.BbsListView;
import View.ChatView;
import View.ControlView;
import View.LoginView;
import View.OrderView;
import View.SignUpView;

public class MemberController {
	
	private MemeberServiece memSvc = new MemeberServiece();
	
	private ChatView chatView = null;
	OrderView orderView = null;
	
	public void tictoc(MemberDto dto) {
		memSvc.updateRTime(dto);
		Singleton.getInstance().dto.setR_time(memSvc.getRTime(dto));
	}
	
	public void draw_login() {
		new LoginView();
	}

	public void draw_Signup() {
		new SignUpView();
	}
	
	public void draw_Chat() {
		if(chatView == null) {
			chatView = new ChatView();
		}else {
			chatView.setVisible(true);
		}
	}
	
	
	
	public void draw_orderView() {
		if(orderView == null) {
			orderView = new OrderView();
		}else {
			orderView.dispose();
			orderView = new OrderView();
		}
	}
	
	public boolean login(String id, String pw) {
		MemberDto dto = memSvc.login(id, pw);
		
		if(dto != null) {
			Singleton.getInstance().dto = dto;
			new ControlView();
			
			return true;
		}
		JOptionPane.showMessageDialog(null, "ID와 비밀번호를 확인해 주세요");
		return false;
	}
	
	public boolean signUp(MemberDto dto) {
		if(memSvc.signUp(dto)) {
			new LoginView();
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
			return false;
		}
	}
	
	public boolean checkId(String id) {
		return memSvc.checkId(id);
	}
}
