package Serviece;

import Dao.MemberDao;
import Dto.MemberDto;

public class MemeberServiece {

	private MemberDao memDao = new MemberDao();
	
	public MemberDto login(String id, String pw) {
		return memDao.login(id, pw);
	}
	
	public boolean signUp(MemberDto dto){
		return memDao.signUp(dto);
	}		
	
	public boolean checkId(String id) {
		return memDao.checkId(id);
	}
}
