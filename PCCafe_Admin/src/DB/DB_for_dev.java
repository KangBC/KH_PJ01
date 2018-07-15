package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB_for_dev {
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	
	public DB_for_dev() {
		conn = DBConnection.makeConnection();
		
		try {
			DB_DROP();
			
			DB_MEMBER();
			DB_BBS();
			
			DB_STUFF();

			conn.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void DB_DROP() throws SQLException{		
		String sql = " DROP TABLE PC_MEMBER CASCADE CONSTRAINT ";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
		
		sql = " DROP SEQUENCE SEQ_MEMBER";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
		
		sql = " DROP TABLE BBS CASCADE CONSTRAINT ";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();

		sql = " DROP SEQUENCE SEQ_BBS";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
	}
	
	public void DB_MEMBER() throws SQLException {
		
		String sql = " CREATE TABLE PC_MEMBER(SEQ_MEMBER NUMBER, MEMBER_ID VARCHAR2(25 BYTE), MEMBER_PW VARCHAR2(25 BYTE), " 
				+ "MEMBER_NAME VARCHAR2(25 BYTE), MEMBER_MINUTE NUMBER, ENTRY_DATE DATE, PHONE_NUMBER VARCHAR2(20 BYTE), "
			    + "CONSTRAINT MEMBER_PK PRIMARY KEY (SEQ_MEMBER)) ";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
		
		sql = " CREATE SEQUENCE SEQ_MEMBER INCREMENT BY 1 START WITH 1 ";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
		
		sql = " INSERT INTO PC_MEMBER(SEQ_MEMBER, MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_MINUTE, ENTRY_DATE, PHONE_NUMBER) "
				+ "VALUES (SEQ_MEMBER.NEXTVAL, 'ID', 'PW', 'NAME', 1000, SYSDATE, '010-0000-0000') ";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
		
		sql = " INSERT INTO PC_MEMBER(SEQ_MEMBER, MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_MINUTE, ENTRY_DATE, PHONE_NUMBER) "
				+ "VALUES (SEQ_MEMBER.NEXTVAL, 'A', 'A', 'A', 1000, SYSDATE, '010-1111-1111') ";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
	}

	public void DB_BBS() throws SQLException{
		String sql = " CREATE TABLE BBS(SEQ_BBS NUMBER, SEQ_MEMBER NUMBER, MEMBER_ID VARCHAR2(25 BYTE), BBS_TITLE VARCHAR2(50 BYTE), "
					+ "BBS_CONTENT VARCHAR2(1000 BYTE), BBS_DATE DATE, BBS_COUNT NUMBER(8,0), BBS_DEL NUMBER(2), BBS_ADMIN NUMBER(2), "
					+ " CONSTRAINT BBS_PK PRIMARY KEY (SEQ_BBS), CONSTRAINT MEMBER_FK FOREIGN KEY (SEQ_MEMBER) REFERENCES PC_MEMBER(SEQ_MEMBER)) ";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
		
		sql = " CREATE SEQUENCE SEQ_BBS INCREMENT BY 1 START WITH 1 ";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
		
		sql = " INSERT INTO BBS(SEQ_BBS, SEQ_MEMBER, BBS_DEL, BBS_ADMIN, BBS_TITLE, BBS_CONTENT, BBS_COUNT, BBS_DATE) "
				+ " VALUES( SEQ_BBS.NEXTVAL, 1, 0, 0, 'TEST_BBS', '-----------!!!!!!!!!!!!!!!!!-----------------', 0, SYSDATE)" ;
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
		
		sql = " INSERT INTO BBS(SEQ_BBS, SEQ_MEMBER, BBS_DEL, BBS_ADMIN, BBS_TITLE, BBS_CONTENT, BBS_COUNT, BBS_DATE) "
				+ " VALUES( SEQ_BBS.NEXTVAL, 2, 0, 0, 'TEST_BBS2', '!!!!!!!!!!!!------!!!!!------', 0, SYSDATE)" ;
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
	}
	
	public void DB_STUFF() throws SQLException{
		String sql = "CREATE TABLE STUFF (STUFF_NUM NUMBER(4,0), STUFF_NAME VARCHAR2(25 BYTE), STUFF_PRICE NUMBER(8,0), "
										+ " STUFF_KIND NUMBER(3,0), CONSTRAINT STUFF_PK PRIMARY KEY (STUFF_NUM))";
		psmt = conn.prepareStatement(sql);
		psmt.executeQuery();
	}
}
