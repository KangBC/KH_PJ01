package Singleton;

import Controller.BbsController;
import Controller.MemberController;
import Controller.chatController;

public class Singleton {
	
	private static Singleton single = new Singleton();
<<<<<<< HEAD
	
	public MemberController memCtrl;
=======
	//public MemberController memCtrl;
>>>>>>> origin/master
	public BbsController bbsCtrl;
	//public chatController chatCtrl;
	
	private Singleton() {
		//memCtrl = new MemberController();
		bbsCtrl = new BbsController();
		//chatCtrl = new chatController();
	}
	
	public static Singleton getInstance() {
		return single;
	}
}