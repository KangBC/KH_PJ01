package Singleton;

import Controller.BbsController;
import Controller.MemberController;
import Controller.chatController;

public class Singleton {
	
	private static Singleton single = new Singleton();
	
	public MemberController memCtrl;
	public BbsController bbsCtrl;
	
	private Singleton() {
		memCtrl = new MemberController();
		bbsCtrl = new BbsController();
	}
	
	public static Singleton getInstance() {
		return single;
	}
}