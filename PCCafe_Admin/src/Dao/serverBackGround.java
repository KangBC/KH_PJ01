package Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Main.MainClass;
import Singleton.Singleton;
import View.ChatView;
import View.ControlView;

public class serverBackGround extends Thread {
	private Singleton single = Singleton.getInstance();
	private Socket socket;
	private boolean userLogin;

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
				} else if (userLogin) {
					int temp = single.serCtrl.randomSeatNum(socket); // temp = Seat index Number
					String tempIdList[] = single.serCtrl.getLoginId();
					tempIdList[temp] = msg;
					userLogin = false;
					MainClass.mainView.dispose();
					MainClass.mainView = new ControlView();
					MainClass.mainView.setVisible(true);
				} else {
					// ChatView.contentArea.append(msg);
				}
				Thread.sleep(100);
			}
		} catch (IOException e1) {
			try {
				Socket tempSock[] = single.serCtrl.getSockList();
				String tempSeat[] = single.serCtrl.getSeatList();
				String tempId[] = single.serCtrl.getLoginId();
				for (int i = 0; i < tempSock.length; i++) {
					if (tempSock[i] == socket) {
						tempSock[i] = null;
						tempSeat[i] = "0";
						tempId[i] = null;
						single.serCtrl.setSeatList(tempSeat);
						single.serCtrl.setSockList(tempSock);
						single.serCtrl.setLoginId(tempId);
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