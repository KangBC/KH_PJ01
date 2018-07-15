package Main;

<<<<<<< HEAD
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

>>>>>>> origin/master
import javax.swing.JFrame;
import javax.swing.UIManager;

import DB.DBConnection;
import Singleton.Singleton;
import View.ControlView;

public class MainClass {

<<<<<<< HEAD
	public static void main(String[] args) {
		// Single
		Singleton sc = Singleton.getInstance();
		
		// DB Connect
		DBConnection.makeConnection();
=======
	public static void main(String[] args) throws Exception {

		// Single
		Singleton sc = Singleton.getInstance();

		// Look & Feel

		UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
>>>>>>> origin/master

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