package Main;

import Dao.POS_Dao;

public class MainClass {

	public static void main(String[] args) {
		POS_Dao dao = POS_Dao.getInstance();
		dao.serCtrl.connectServer();
		dao.mainView();
	}
}