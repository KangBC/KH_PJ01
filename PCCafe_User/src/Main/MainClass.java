package Main;

import java.net.Socket;

import Singleton.Singleton;
import View.ChatView;

public class MainClass {
	public static ChatView chatview = new ChatView();
	public static Socket sock;

	// getter & setter
	public static Socket getSock() {
		return sock;
	}

	public static void setSock(Socket sock) {
		MainClass.sock = sock;
	}


	public static void main(String[] args) {

		Singleton sgt = Singleton.getInstance();

		// LoginView
		sgt.memCtrl.draw_login();

		// ChatView
		chatview.setVisible(false);
	}
}