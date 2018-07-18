package Main;

import java.net.ServerSocket;
import java.net.Socket;

import Dao.serverBackGround;
import Singleton.Singleton;
import View.ControlView;

public class MainClass {
	public static ControlView mainView;

	public static void main(String[] args) throws Exception {
		// Single
		Singleton single = Singleton.getInstance();

		// MainView
		mainView = new ControlView();
		mainView.setVisible(true);

		// Server On
		ServerSocket serSock = new ServerSocket(single.serCtrl.getSERVER_PORT());
		while (true) {
			Socket socket = serSock.accept();
			new serverBackGround(socket).start();
		}
	}
}