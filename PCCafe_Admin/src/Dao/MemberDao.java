package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DB.DBClose;
import DB.DBConnection;
import Dto.BbsDto;
import Dto.MemberDto;

public class MemberDao {

	private MemberDto dto = null;
	private String sql;
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public MemberDao() {
	}

	public MemberDao(MemberDto dto) {
		this.dto = dto;
	}

	// 회원검색
	// 회원이름으로 검색 하기위해 String으로 받음.
	// 기존 public MemberDto getDto(int seq) {
	public MemberDto getDto(String member_id) {
		dto = null;
		// 기존 sql = " SELECT MEMBER_ID, MEMBER_MINUTE FROM PC_MEMBER WHERE SEQ_MEMBER =
		// " + seq;
		sql = " SELECT MEMBER_NAME, MEMBER_MINUTE FROM PC_MEMBER WHERE MEMBER_ID = " + "'" + member_id + "'";
		try {
			System.out.println("getDto member_id(4) : " + member_id);
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				dto = new MemberDto(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBClose.close(psmt, conn, rs);
		}

		return dto;
	}

	// 수정한 내용을 DB에 적용하기 위한 메서드
	public boolean changePw(String id, String pw) {
		int count = 0;

		sql = " UPDATE PC_MEMBER SET MEMBER_PW = '" + pw + "' WHERE MEMBER_ID = '" + id + "' ";

		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBClose.close(psmt, conn, rs);
		}

		return count > 0 ? true : false;
	}
}