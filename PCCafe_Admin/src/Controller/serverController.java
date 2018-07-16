package Controller;

import java.awt.EventQueue;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBClose;
import DB.DBConnection;
import Dto.MemberDto;
import View.ChatView;
import View.UserDetailView;

public class serverController {

	// Seat List
	private String seatList[] = new String[10]; // 00010 00100
	// Port List
	private Socket sockList[] = new Socket[10];
	// Id List
	private String loginId[] = new String[10];

	private final int SERVER_PORT = 9000;

	// Constructor
	public serverController() {
		// Initialize List
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = "0";
			sockList[i] = null;
			loginId[i] = null;
		}
	}

	// Getter & Setter
	public String[] getSeatList() {
		return seatList;
	}

	public void setSeatList(String[] seatList) {
		this.seatList = seatList;
	}

	public Socket[] getSockList() {
		return sockList;
	}

	public void setSockList(Socket[] sockList) {
		this.sockList = sockList;
	}

	public int getSERVER_PORT() {
		return SERVER_PORT;
	}

	public String[] getLoginId() {
		return loginId;
	}

	public void setLoginId(String[] loginId) {
		this.loginId = loginId;
	}

	// Set Random SeatNum
	public int randomSeatNum(Socket socket) {
		int temp;
		while (true) {
			temp = (int) (Math.random() * 10);
			System.out.println("tmep : " + temp);
			if (seatList[temp].equals("0")) {
				seatList[temp] = "1";
				sockList[temp] = socket;
				break;
			}
		}
		return temp;
	}

	// detail View
	public void detailView(int seatNum) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String userId = loginId[seatNum];
		System.out.println("id : " + userId);
		String sql = " SELECT MEMBER_ID, MEMBER_MINUTE FROM PC_MEMBER WHERE MEMBER_ID = ?";
		MemberDto dto = new MemberDto();
		try {
			conn = DBConnection.makeConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString(1);
				int time = rs.getInt(2);
				dto = new MemberDto(id, time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		UserDetailView frame = new UserDetailView(seatNum, dto);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

	// ChatView
	public void chatView(Socket socket) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatView frame = new ChatView(socket);
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}