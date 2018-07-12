package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DB.DBClose;
import DB.DBConnection;
import Dto.BbsDto;

public class BbsDao {
	
	private BbsDto dto = null;
	private String sql;
	
	private List<BbsDto> dtoList = null;
	
	public List<BbsDto> getList(){

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		sql = " SELECT SEQ_BBS, SEQ_MEMBER, BBS_DEL, BBS_ADMIN, BBS_TITLE, BBS_CONTENT, BBS_COUNT, BBS_DATE "
				+ " FROM BBS " + " WHERE BBS_DEL = 0" 
				+ " ORDER BY BBS_DATE DESC " ;
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(5), rs.getString(6));
				dtoList.add(dto);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return dtoList;
	}
	
	public BbsDto getPost(int seq) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		sql = " SELECT SEQ_BBS, SEQ_MEMBER, BBS_DEL, BBS_ADMIN, BBS_TITLE, BBS_CONTENT, BBS_COUNT, BBS_DATE "
				+ " FROM BBS " + " WHERE BBS_DEL = 0 AND SEQ_BBS = " + seq;
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			BbsDto dto = new BbsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(5), rs.getString(6));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
	}
	
	public boolean addPost() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		
		sql = " INSERT INTO BBS(SEQ_BBS, SEQ_MEMBER, BBS_DEL, BBS_ADMIN, BBS_TITLE, BBS_CONTENT, BBS_COUNT, BBS_DATE) "
				+ " VALUES( SEQ_BBS.NEXTVAL, ?, 0, 0, ?, ?, 0, SYSDATE" ;
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, dto.getUserNum());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DBClose.close(psmt, conn, rs);	
		}
		
		return count > 0 ? true : false;
	}
	
	public boolean updatePost(int seq) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		
		sql = "UPDATE INTO BBS SET TITLE = ?, CONTENT = ? WHERE SEQ_BBS = ?";
		
		try {
			conn = DBConnection.makeConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, seq);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DBClose.close(psmt, conn, rs);	
		}
		
		return count > 0 ? true : false;
	}
	
	public boolean deletePost(int seq) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		
		sql = "UPDATE BBS SET TITLE = '------삭제된 글입니다-----', CONTENT = '', DEL = 1 WHERE BBS_SEQ = " + seq;
		
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
		
		return count > 0 ? true: false;
	}
	
	public void addReadCount(int seq) {
		sql=" UPDATE BBS SET BBS_COUNT = BBS_COUNT + 1 WHERE BBS_SEQ = " + seq;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		try {
			conn = DBConnection.makeConnection();	
			psmt=conn.prepareStatement(sql);
			psmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally{
			DBClose.close(psmt, conn, rs);	
		}
	}
}
