package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBClose;
import DB.DBConnection;
import Dto.BbsDto;

public class BbsDao {

	private String sql;
	private List<BbsDto> dtoList = null;
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private BbsDto dto = null;

	public BbsDao() {

	}

	public BbsDao(BbsDto dto) {
		this.dto = dto;
	}

	// 뿌려줄 때 사용할 list를 얻어옴.
	public List<BbsDto> getList() {
		dtoList = new ArrayList<>();
		sql = " SELECT SEQ_BBS, SEQ_MEMBER, BBS_DEL, BBS_ADMIN, BBS_TITLE, BBS_CONTENT, BBS_COUNT, BBS_DATE "
				+ " FROM BBS " + " WHERE BBS_DEL = 0" + " ORDER BY BBS_DATE DESC ";

		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				dto = new BbsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBClose.close(psmt, conn, rs);
		}

		return dtoList;
	}

	// Detail이나 Update View를 위한 메서드
	public BbsDto getPost(int seq) {
		sql = " SELECT SEQ_BBS, SEQ_MEMBER, BBS_DEL, BBS_ADMIN, BBS_TITLE, BBS_CONTENT, BBS_COUNT, BBS_DATE "
				+ " FROM BBS " + " WHERE BBS_DEL = 0 AND SEQ_BBS = " + seq;

		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				dto = new BbsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBClose.close(psmt, conn, rs);
		}

		return dto;
	}

	// 글쓰기
	public boolean addPost(BbsDto dto) {
		int count = 0;

		sql = " INSERT INTO BBS(SEQ_BBS, SEQ_MEMBER, BBS_DEL, BBS_ADMIN, BBS_TITLE, BBS_CONTENT, BBS_COUNT, BBS_DATE) "
				+ " VALUES( SEQ_BBS.NEXTVAL, 1, 0 , ?, ?, ?, 0, SYSDATE) ";

		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);

			// psmt.setInt(1, dto.getUserNum());
			psmt.setInt(1, dto.getNotice());
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

	// 수정한 내용을 DB에 적용하기 위한 메서드
	public boolean updatePost(int seq, String title, String content) {
		int count = 0;

		// 기존코드 sql = "UPDATE INTO BBS_ SET TITLE = ?, CONTENT = ? WHERE SEQ_BBS = ?";
		sql = "UPDATE BBS SET BBS_TITLE = ?, BBS_CONTENT = ? WHERE SEQ_BBS = ?";

		try {
			conn = DBConnection.makeConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
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

	// 삭제한 글을 DB에서 처리하기 위한 메서드
	public boolean deletePost(int seq) {
		int count = 0;
		// 빛찬이한테 확인 : 컬럼이름이 달라서 고침
		// 기존코드 sql = "UPDATE BBS SET TITLE = '------삭제된 글입니다-----', CONTENT = '', DEL =
		// 1 WHERE BBS_SEQ = " + seq;
		sql = "UPDATE BBS SET BBS_TITLE = '------삭제된 글입니다-----', BBS_CONTENT = '', BBS_DEL = 1 WHERE SEQ_BBS = " + seq;

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

	// 조회수를 1씩 추가해주기 위한 메서드
	public void addReadCount(int seq) {
		sql = " UPDATE BBS SET BBS_COUNT = BBS_COUNT + 1 WHERE SEQ_BBS = " + seq;

		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBClose.close(psmt, conn, rs);
		}
	}

	// 검색
	public List<BbsDto> serchPost(String column, String contain) {
		dtoList = new ArrayList<>();
		sql = " SELECT SEQ_BBS, SEQ_MEMBER, BBS_DEL, BBS_ADMIN, BBS_TITLE, BBS_CONTENT, BBS_COUNT, BBS_DATE "
				+ " FROM BBS " + " WHERE BBS_DEL = 0 AND " + column + " LIKE '%" + contain + "%'"
				+ " ORDER BY BBS_DATE DESC ";
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BbsDto dto = new BbsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBClose.close(psmt, conn, rs);
		}

		return dtoList;
	}
}
