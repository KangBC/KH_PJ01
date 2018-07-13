package Main;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.UIManager;

import DB.DBConnection;
import Singleton.Singleton;
import View.BbsUpateview;

public class MainClass {

	public static void main(String[] args) throws SQLException {

		// DB
		new DBConnection().makeConnection();

		// Single
		Singleton sc = Singleton.getInstance();


		// Look & Feel
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame.setDefaultLookAndFeelDecorated(true);

		// View
		//ControlView frame = new ControlView();
		BbsUpateview frame = new BbsUpateview();
		frame.setVisible(true);
		
		/*// Server ON
		try {
			ServerSocket serSock = new ServerSocket(9010);
			while (true) {
				System.out.println("대기중...");
				Socket socket = serSock.accept();
				sc.chatCtrl.start();

				System.out.println("IP:" + socket.getInetAddress() + " Port:" + socket.getPort());
				// new ServerThread(socket, list).start(); - 런파일 수정
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
