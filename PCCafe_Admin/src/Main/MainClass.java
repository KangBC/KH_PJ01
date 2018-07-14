package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import DB.DBConnection;
import Singleton.Singleton;
import View.BbsUpateview;
import View.ControlView;

public class MainClass {

	public static void main(String[] args) throws Exception {

		// Single
		Singleton sc = Singleton.getInstance();

		// Look & Feel

		UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");

		JFrame.setDefaultLookAndFeelDecorated(true);

		ControlView frame = new ControlView();
		frame.setVisible(true);

	}
}
