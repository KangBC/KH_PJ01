package Dao;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DB.DBClose;
import DB.DBConnection;
import Dto.member_Dto;
import View.addTime_View;
import View.checkSpot_View;
import View.demand_View;
import View.main_View;
import server.serverBackGroud;

public class POS_Dao {

	private static POS_Dao dao = new POS_Dao();

	public serverBackGroud serCtrl;

	// Member Variable
	private int choTime = 0;
	private int choPrice = 0;
	private int insertMoney = 0;
	private member_Dto userDto;

	// Getter & Setter
	public int getChoTime() {
		return choTime;
	}

	public void setChoTime(int choTime) {
		this.choTime = choTime;
	}

	public int getChoPrice() {
		return choPrice;
	}

	public void setChoPrice(int choPrice) {
		this.choPrice = choPrice;
	}

	public int getInsertMoney() {
		return insertMoney;
	}

	public void setInsertMoney(int insertMoney) {
		this.insertMoney = insertMoney;
	}

	public member_Dto getUserDto() {
		return userDto;
	}

	public void setUserDto(member_Dto userDto) {
		this.userDto = userDto;
	}

	// View Method
	public void mainView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_View frame = new main_View();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addTimeView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addTime_View frame = new addTime_View();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void checkSpotView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkSpot_View frame = new checkSpot_View();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void demandView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demand_View frame = new demand_View();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private POS_Dao() {
		serCtrl = new serverBackGroud();
	}

	// ID Search
	public ArrayList<member_Dto> findId(String temp) {
		if (temp.equals(null) || temp.equals("")) {
			return null;
		}
		String sql = null;
		sql = " SELECT SEQ_MEMBER, MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_MINUTE, ENTRY_DATE, PHONE_NUMBER"
				+ " FROM PC_MEMBER " + " WHERE MEMBER_ID LIKE '%" + temp + "%'";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		ArrayList<member_Dto> getList = new ArrayList<>();

		try {
			conn = DBConnection.makeConnection();

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int i = 1;
				member_Dto dto = new member_Dto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
						rs.getInt(i++), rs.getString(i++), rs.getString(i++));
				getList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return getList;
	}

	// Input time
	public boolean inputTime(int seq, int time) {
		String sql = "UPDATE PC_MEMBER SET MEMBER_MINUTE = " + time + " WHERE SEQ_MEMBER = ?";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return true;
	}

	public static POS_Dao getInstance() {
		return dao;
	}
}