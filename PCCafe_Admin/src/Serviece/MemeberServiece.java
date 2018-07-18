package Serviece;

import Dao.MemberDao;
import Dto.MemberDto;

public class MemeberServiece {

	MemberDao dao = new MemberDao();

	// 회원 검색 
	public MemberDto getMem(String member_id) {
		System.out.println("getMem member_id(3) : " + member_id);
		return dao.getDto(member_id);
	}

	// 회원 pw 수정
	public boolean changePW(String id, String pw) {
		return dao.changePw(id, pw);
	}

	public int getRTime(String id) {
		return dao.getRTime(id);
	}
}
