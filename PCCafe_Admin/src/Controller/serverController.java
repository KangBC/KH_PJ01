package Controller;

import java.awt.EventQueue;
import java.net.Socket;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> KH_MiniProject/hyunwoo

import View.ChatView;

public class serverController {

	// Seat List
	private String seatList[] = new String[10]; // 00010 00100
	// Port List
	private Socket sockList[] = new Socket[10];
	// Id List
	private String loginId[] = new String[10];

<<<<<<< HEAD
	private ChatView chatList[] = new ChatView[10];

=======
>>>>>>> KH_MiniProject/hyunwoo
	private final int SERVER_PORT = 9000;

	// Constructor
	public serverController() {
		// Initialize List
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = "0";
			sockList[i] = null;
			loginId[i] = null;
<<<<<<< HEAD
			chatList[i] = null;
=======
>>>>>>> KH_MiniProject/hyunwoo
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

<<<<<<< HEAD
	public ChatView[] getChatList() {
		return chatList;
	}

	public void setChatList(ChatView[] chatList) {
		this.chatList = chatList;
	}

=======
>>>>>>> KH_MiniProject/hyunwoo
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

	// chatView
	public void chatView(int seatNum) {
		Socket temp[] = sockList;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatView frame = new ChatView(temp[seatNum]);
					frame.setUndecorated(true);
					frame.setVisible(true);
<<<<<<< HEAD
					chatList[seatNum] = frame;
=======
>>>>>>> KH_MiniProject/hyunwoo
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
<<<<<<< HEAD
	
	// ShowView
	public void showView(int num) {
		chatList[num].setVisible(true);
	}
=======
>>>>>>> KH_MiniProject/hyunwoo
}