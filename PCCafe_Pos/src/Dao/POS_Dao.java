package Dao;

import java.awt.EventQueue;
import java.util.ArrayList;

import Dto.member_Dto;
import View.addTime_View;
import View.checkSpot_View;
import View.demand_View;
import View.main_View;

public class POS_Dao {

	private static POS_Dao dao = new POS_Dao();
	// Test DB
	private static ArrayList<member_Dto> list;

	// Member Variable
	private int choTime = 0;
	private int choPrice = 0;
	private int insertMoney = 0;

	// Getter & Setter
	public int getChoTime() {
		return choTime;
	}

	public void setChoTime(int choTime) {
		this.choTime = choTime;
	}

	public int getChoPrice() {
		return choPrice;
	}

	public void setChoPrice(int choPrice) {
		this.choPrice = choPrice;
	}

	public int getInsertMoney() {
		return insertMoney;
	}

	public void setInsertMoney(int insertMoney) {
		this.insertMoney = insertMoney;
	}

	// Test DB Getter & Setter
	public static ArrayList<member_Dto> getList() {
		return list;
	}

	public static void setList(ArrayList<member_Dto> list) {
		POS_Dao.list = list;
	}

	// View Method
	public void mainView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_View frame = new main_View();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addTimeView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addTime_View frame = new addTime_View();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void checkSpotView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkSpot_View frame = new checkSpot_View();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void demandView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demand_View frame = new demand_View();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private POS_Dao() {
		list = new ArrayList<>();
		list.add(new member_Dto("apple", "1", 60));
		list.add(new member_Dto("app", "1", 160));
		list.add(new member_Dto("ap7ple", "1", 260));
		list.add(new member_Dto("app1le", "1", 560));
		list.add(new member_Dto("ape1", "1", 660));
		list.add(new member_Dto("ale", "1", 160));

	}

	public static POS_Dao getInstance() {
		return dao;
	}
}