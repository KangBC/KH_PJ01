package Main;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Dao.serverBackGround;
import Singleton.Singleton;
import View.ControlView;

public class MainClass {
	public static void main(String[] args) throws Exception {
		// Single
		Singleton single = Singleton.getInstance();

		// MainView
		ControlView frame = new ControlView();
		frame.setVisible(true);

		// Server On
		ServerSocket serSock = new ServerSocket(single.serCtrl.getSERVER_PORT());
		while (true) {
			Socket socket = serSock.accept();
			new serverBackGround(socket).start();
		}
	}
}