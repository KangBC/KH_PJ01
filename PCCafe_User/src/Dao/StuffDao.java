package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBClose;
import DB.DBConnection;
import Dto.StuffDto;

public class StuffDao {
	
	private String sql;
	private StuffDto dto ;
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public StuffDao() {
	}

	// 상품명으로 검색
	public StuffDto getStuff(String str) {
		
		sql = "SELECT * FROM STUFF WHERE STUFF_NAME = " + str;
		
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			dto = new StuffDto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally { DBClose.close(psmt, conn, rs); }
		
		return dto;
	}
}
