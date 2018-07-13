package Main;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.UIManager;

import DB.DBConnection;
import Singleton.Singleton;
import View.BbsUpateview;

public class MainClass {

<<<<<<< HEAD
	public static void main(String[] args) throws Exception{
=======
	public static void main(String[] args) throws SQLException {

		// DB
		new DBConnection().makeConnection();

		// Single
		Singleton sc = Singleton.getInstance();

>>>>>>> KH_MiniProject/hyunwoo

		// Look & Feel
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
<<<<<<< HEAD
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		JFrame.setDefaultLookAndFeelDecorated(true);

		ControlView frame = new ControlView();
		frame.setVisible(true);
	}
}
