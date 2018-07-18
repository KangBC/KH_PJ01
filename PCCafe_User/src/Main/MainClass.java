package Main;

import Dao.MemberDao;
import Dto.MemberDto;
import Singleton.Singleton;
import View.ChatView;

public class MainClass {
	public static ChatView chatview = new ChatView();

	public static void main(String[] args) {
<<<<<<< HEAD
		MemberDao dao = new MemberDao();
		dao.updateRTime(new MemberDto(1, 2, "ID"));
=======
>>>>>>> 86ecf272e9df3e0a48e23b0a6bc47e042d5b7b1f
		Singleton sgt = Singleton.getInstance();

		// LoginView
		sgt.memCtrl.draw_login();

		// ChatView
		chatview.setVisible(false);
		
		// Connect Server
		sgt.serCtrl.connectServer();
	}
}