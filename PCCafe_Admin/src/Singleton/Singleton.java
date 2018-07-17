package Singleton;

import Controller.BbsController;
import Controller.MemberController;
import Controller.ChatController;

public class Singleton {
	
	private static Singleton single = new Singleton();
	
	public MemberController memCtrl;
	public BbsController bbsCtrl;
	//public chatController chatCtrl;
	
	private Singleton() {
		memCtrl = new MemberController();
		bbsCtrl = new BbsController();
		//chatCtrl = new chatController();
	}
	
	public static Singleton getInstance() {
		return single;
	}
}