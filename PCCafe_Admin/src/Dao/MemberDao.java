package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBClose;
import DB.DBConnection;
import Dto.MemberDto;

public class MemberDao {
	private MemberDto dto = null;
	private String sql;
	
	public MemberDao() {
	}
	
	public MemberDao(MemberDto dto) {
		this.dto = dto;
	}

	public MemberDto getDto(int seq) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		sql = " SELECT MEMBER_ID, MEMBER_MINUTE FROM PC_MEMBER WHERE SEQ_MEMBER = " + seq;
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			dto = new MemberDto(rs.getString(1),rs.getInt(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally { DBClose.close(psmt, conn, rs); }

		return dto;
	}
	
	public boolean changePw(String id, String pw) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		
		sql = " UPDATE PC_MEMBER SET MEMBER_PW = " + pw + " WHERE MEMBER_ID = " + id;
	
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally{ DBClose.close(psmt, conn, rs); }
		
		return count > 0 ? true : false;
	}
}
