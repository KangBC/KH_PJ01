package Controller;

import java.util.Timer;
import java.util.TimerTask;

import Dao.BbsDao;
import Dao.MemberDao;
import Dto.MemberDto;
import Singleton.Singleton;

public class MemberController {
	MemberDao memdao = new MemberDao();

	public void tictoc(MemberDto dto) {
		memdao.updateRTime(dto);
		Singleton.getInstance().dto.setR_time(memdao.getRTime(dto));
	}
}
