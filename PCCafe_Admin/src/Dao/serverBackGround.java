package Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Main.MainClass;
import Singleton.Singleton;
<<<<<<< HEAD
import View.ChatView;
=======
>>>>>>> KH_MiniProject/hyunwoo
import View.ControlView;

public class serverBackGround extends Thread {
	private Singleton single = Singleton.getInstance();
	private Socket socket;
	private boolean userLogin;
<<<<<<< HEAD
	private int num = 0;
=======
>>>>>>> KH_MiniProject/hyunwoo

	public serverBackGround(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			String msg;
			while (true) {
				msg = reader.readLine();
				if (msg.equals("SERBER_JOIN_TO_ADMIN_FROM_POS")) {
					// Demand seatData from POS
					String temp[] = single.serCtrl.getSeatList();
					msg = "";
					for (int j = 0; j < temp.length; j++) {
						msg = msg + temp[j];
					}
					pw.println(msg);
					pw.flush();
				} else if (msg.equals("SERBER_JOIN_TO_ADMIN_FROM_USER")) {
					userLogin = true;
<<<<<<< HEAD
				} else if (msg.equals("GET_THE_MESSAGE_FROM_USER")) {
					System.out.println("ADMIN"+msg);
					Socket temp[] = single.serCtrl.getSockList();
					ChatView temp1[] = single.serCtrl.getChatList();
					for (int i = 0; i < temp.length; i++) {
						if (temp[i] == socket) {
							num = i;
							if (temp1[i] == null) {
								single.serCtrl.chatView(i);
							} else {
								temp1[i].setVisible(true);
							}
						}
					}
=======
>>>>>>> KH_MiniProject/hyunwoo
				} else if (userLogin) {
					int temp = single.serCtrl.randomSeatNum(socket); // temp = Seat index Number
					String tempIdList[] = single.serCtrl.getLoginId();
					tempIdList[temp] = msg;
					userLogin = false;
					MainClass.mainView.dispose();
					MainClass.mainView = new ControlView();
					MainClass.mainView.setVisible(true);
				} else {
<<<<<<< HEAD
					System.out.println("ADMIN"+msg);
					ChatView temp1[] = single.serCtrl.getChatList();
					temp1[num].contentArea.append(msg+"\n");
=======
					// ChatView.contentArea.append(msg);
>>>>>>> KH_MiniProject/hyunwoo
				}
				Thread.sleep(100);
			}
		} catch (IOException e1) {
			try {
				Socket tempSock[] = single.serCtrl.getSockList();
				String tempSeat[] = single.serCtrl.getSeatList();
				String tempId[] = single.serCtrl.getLoginId();
<<<<<<< HEAD
				ChatView tempChat[] = single.serCtrl.getChatList();
=======
>>>>>>> KH_MiniProject/hyunwoo
				for (int i = 0; i < tempSock.length; i++) {
					if (tempSock[i] == socket) {
						tempSock[i] = null;
						tempSeat[i] = "0";
						tempId[i] = null;
<<<<<<< HEAD
						tempChat[i] = null;
						single.serCtrl.setSeatList(tempSeat);
						single.serCtrl.setSockList(tempSock);
						single.serCtrl.setLoginId(tempId);
						single.serCtrl.setChatList(tempChat);
=======
						single.serCtrl.setSeatList(tempSeat);
						single.serCtrl.setSockList(tempSock);
						single.serCtrl.setLoginId(tempId);
>>>>>>> KH_MiniProject/hyunwoo
						break;
					}
				}
				socket.close();
			} catch (IOException e2) {
				e1.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

<<<<<<< HEAD
	// Send command sign
	public void commandSign(Socket sock) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println("GET_THE_MESSAGE_FROM_ADMIN");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

=======
>>>>>>> KH_MiniProject/hyunwoo
	// Send Message
	public void sendMsg(Socket sock, String msg) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println(msg);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}