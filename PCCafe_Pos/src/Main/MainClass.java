package Main;

import DB.DBConnection;
import Dao.POS_Dao;

public class MainClass {

	public static void main(String[] args) {
		POS_Dao dao = POS_Dao.getInstance();
		DBConnection.makeConnection();
		dao.mainView();
	}
}