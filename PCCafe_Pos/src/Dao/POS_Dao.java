package Dao;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import DB.DBClose;
import DB.DBConnection;
import Dto.member_Dto;
import View.addTime_View;
import View.checkSpot_View;
import View.demand_View;
import View.main_View;

public class POS_Dao {

	private static POS_Dao dao = new POS_Dao();

	// Member Variable
	private int choTime = 0;
	private int choPrice = 0;
	private int insertMoney = 0;
	private ArrayList<member_Dto> List = new ArrayList<>();

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

	public ArrayList<member_Dto> getList() {
		return List;
	}

	public void setList(ArrayList<member_Dto> list) {
		List = list;
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

	}

	// DB 테스트용
	public void findId(String temp) {
		if (temp.equals(null) || temp.equals("")) {
			return;
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
		List = getList;
	}

	public static POS_Dao getInstance() {
		return dao;
	}
}