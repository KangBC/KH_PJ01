package Main;

import Dao.MemberDao;
import Dto.MemberDto;
import Singleton.Singleton;
import View.LoginView;

public class MainClass {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		dao.updateRTime(new MemberDto(1, 2, "ID"));
		Singleton sgt = Singleton.getInstance();
		sgt.memCtrl.draw_login();
	}

}
