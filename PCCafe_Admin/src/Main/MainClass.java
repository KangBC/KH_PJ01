package Main;

import javax.swing.JFrame;
import javax.swing.UIManager;

import DB.DBConnection;
import Singleton.Singleton;
import View.ControlView;

public class MainClass {
	public static void main(String[] args) throws Exception {

		//DB
		DBConnection.makeConnection();
		
		// Single
		Singleton sc = Singleton.getInstance();

		// Look & Feel
		UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");

		JFrame.setDefaultLookAndFeelDecorated(true);

		ControlView frame = new ControlView();
		frame.setVisible(true);
	}
}