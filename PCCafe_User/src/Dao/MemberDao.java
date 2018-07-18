package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.midi.Sequence;

import DB.DBClose;
import DB.DBConnection;
import Dto.MemberDto;

public class MemberDao {

	private MemberDto dto = null;
	private String sql;
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public MemberDao() {
	}
	
	public MemberDao(MemberDto dto) {
		this.dto = dto;
	}
	// 중복확인
	
	public int getMemSeq(String id) {
		sql = "SELECT SEQ_MEMBER FROM PC_MEMBER WHERE MEMBER_ID = '" + id + "'";
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {DBClose.close(psmt, conn, rs);}
		return -1;
		
	}
	public boolean checkId(String id) {
		int count = 0;
		sql = "SELECT MEMBER_ID FROM PC_MEMBER WHERE MEMBER_ID = '" + id + "'";
	
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {DBClose.close(psmt, conn, rs);}
		return true;
	}
	
	// 반환값이 null일경우 로그인 실패하도록 해줘야함. 이 dto는 singleton이 계속 갖고있도록 할것.
	public MemberDto login(String id, String pw) {			
		sql = "SELECT SEQ_MEMBER, MEMBER_MINUTE, MEMBER_ID FROM PC_MEMBER WHERE MEMBER_ID = '" + id + "'AND MEMBER_PW = '" + pw + "'";
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDto(rs.getInt(1),rs.getInt(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally { DBClose.close(psmt, conn, rs);	}
		
		return dto;
	}
	
	// 회원가입을 위한 메서드
	public boolean signUp(MemberDto dto) {					
		int count = 0;
		
		sql = "INSERT INTO PC_MEMBER(SEQ_MEMBER, MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_MINUTE, ENTRY_DATE, PHONE_NUMBER) "
							+ "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?)";
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setInt(4, dto.getR_time());
			psmt.setString(5, dto.getPhone());
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally { DBClose.close(psmt, conn, rs); }
		
		return count > 0 ? true : false;
	}
	
	public int getRTime(MemberDto dto) {			
		int r_time = 0;
		
		sql = "SELECT MEMBER_MINUTE FROM PC_MEMBER WHERE MEMBER_ID = '" + dto.getId()+ "'";
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				r_time = rs.getInt(1);
				System.out.println(r_time + "");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally { DBClose.close(psmt, conn, rs); }
		return r_time;
	}
	
	// timer를 위한 메서드임. POS에서는 다른 쿼리 써야함.
	// 남은 시간을 업데이트 하기 위한 메서드. 
	public boolean updateRTime(MemberDto dto) {			
		int count = 0;
		
		sql = "UPDATE PC_MEMBER SET MEMBER_MINUTE = ? WHERE MEMBER_ID = ?";
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, dto.getR_time()-1);
			psmt.setString(2, dto.getId());
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally { DBClose.close(psmt, conn, rs); }
		
		return count > 0 ? true : false;
	}
}
