package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import Main.MainClass;
import View.ChatView;
import View.ControlView;

public class serverController extends Thread {
	private final int PORT_NUMBER = 9000;
	private Socket socket;
	private ChatView chat;

	// Connect Server
	public void connectServer() {
		try {
			socket = new Socket("127.0.0.1", PORT_NUMBER);
			new serverController().start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "서버가 점검중이거나" + "\n" + "접속 할 수 없습니다.");
			System.exit(0);
		}
	}

	// Chat_ON
	public void Chat_ON() {
		MainClass.chatview.setVisible(true);
	}

	// Chat_OFF
	public void Chat_OFF() {
		MainClass.chatview.setVisible(false);
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
				if (msg.equals("GET_THE_MESSAGE_FROM_ADMIN")) {
					System.out.println("USER" + msg);
					MainClass.chatview.setVisible(true);
				} else {
					System.out.println("USER" + msg);
					MainClass.chatview.chatArea.append(msg + "\n");
				}
			}
		} catch (SocketException e1) {

		} catch (IOException e) {

		}
	}

	// Send Logout Sign
	public void logOutSign() {
		PrintWriter pw;
		try {
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println("SERBER_OUT_FROM_ADMIN");
			pw.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Send Login Sign
	public void sendLoginSign() {
		PrintWriter pw;
		try {
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println("SERBER_JOIN_TO_ADMIN_FROM_USER");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Send command sign
	public void commandSign() {
		PrintWriter pw;
		try {
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println("GET_THE_MESSAGE_FROM_USER");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Send Message
	public void sendMsg(String msg) {
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