package Controller;

import java.net.Socket;

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
}