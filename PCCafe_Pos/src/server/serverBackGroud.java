package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class serverBackGroud extends Thread {
	private final int PORT_NUMBER = 9000;
	private Socket socket;
	private ArrayList<String> checkSpot;

	// Getter & Setter
	public ArrayList<String> getCheckSpot() {
		return checkSpot;
	}

	public void setCheckSpot(ArrayList<String> checkSpot) {
		this.checkSpot = checkSpot;
	}

	public void connectServer() {
		try {
			socket = new Socket("127.0.0.1", PORT_NUMBER);
			System.out.println("서버에 접속하였습니다.");
			start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "서버가 점검중이거나" + "\n" + "접속 할 수 없습니다.");
			System.exit(0);
		}
	}

	@Override
	public void run() {
		super.run();
		try {
			BufferedReader br = null;
			String str;
			while (true) {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				str = br.readLine();
				for (int i = 0; i < str.length(); i++) {
					checkSpot.add(str.charAt(i) + "");
				}
			}
		} catch (SocketException e1) {
			JOptionPane.showMessageDialog(null, "서버가 종료되었습니다");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// sendMsg
	public void sendSign() {
		String str = "SERBER_JOIN_TO_ADMIN_FROM_POS";
		PrintWriter pw;
		try {
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println(str);
			pw.flush();
			checkSpot = new ArrayList<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}