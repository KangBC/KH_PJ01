package Main;

import javax.swing.JFrame;
import javax.swing.UIManager;

import DB.DBConnection;
import Singleton.Singleton;
import View.ControlView;

public class MainClass {

	public static void main(String[] args) {
		// Single
		Singleton sc = Singleton.getInstance();
		
		// DB Connect
		DBConnection.makeConnection();

		// Look & Feel
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		
		ControlView frame = new ControlView();
		frame.setVisible(true);
	}
}