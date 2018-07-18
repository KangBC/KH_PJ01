package Main;

import Dao.MemberDao;
import Dto.MemberDto;
import Singleton.Singleton;
import View.ChatView;

public class MainClass {
	public static ChatView chatview = new ChatView();

	public static void main(String[] args) {

		Singleton sgt = Singleton.getInstance();

		// LoginView
		sgt.memCtrl.draw_login();

		// ChatView
		chatview.setVisible(false);
	}
}