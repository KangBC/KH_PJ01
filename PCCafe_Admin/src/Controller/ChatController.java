package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Dto.chatDto;

public class ChatController extends Thread {

	// Member Variable
	private ArrayList<chatDto> list = new ArrayList<>();
	private ArrayList<Integer> userSeatNum = new ArrayList<>();
	private Socket socket;
	private int seatNum;

	// Getter & Setter
	public Socket getSocket() {
		return socket;
	}

	public ArrayList<chatDto> getList() {
		return list;
	}

	public void setList(ArrayList<chatDto> list) {
		this.list = list;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

//	// Server ON
//	public void serverOn() {
//		try {
//			ServerSocket serSock = new ServerSocket(9010);
//			while (true) {
//				System.out.println("대기중...");
//				Socket socket = serSock.accept();
//				
//				list.add(socket,);
//				System.out.println("IP:" + socket.getInetAddress() + " Port:" + socket.getPort());
//				// new ServerThread(socket, list).start(); - 런파일 수정
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	// RunThread
	@Override
	public void run() {
		super.run();
		boolean isFirst = false;
		try {
			while (true) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = reader.readLine();
				if (isFirst == false) {
					isFirst = true;
					seatNum = Integer.parseInt(msg);
				} else {
					// View창 생성 및 Append로 View 창에 글을 올려준다
					Thread.sleep(100);
				}
			}
		} catch (IOException e) {
			System.out.println("연결끊김 IP:" + socket.getInetAddress() + " Port:" + socket.getPort());
			list.remove(this.socket);
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Send Msg
	public void sendMsg(String msg) {
		Socket s = new Socket();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSeatNum() == seatNum) {
				s = list.get(i).getSock();
				break;
			}
		}
		PrintWriter writer;
		try {
			writer = new PrintWriter(s.getOutputStream());
			writer.println(msg);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}