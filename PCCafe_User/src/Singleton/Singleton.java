package Singleton;

import Controller.BbsController;
import Controller.MemberController;
<<<<<<< HEAD
import Controller.StuffController;
=======
import Controller.serverController;
>>>>>>> 86ecf272e9df3e0a48e23b0a6bc47e042d5b7b1f
import Dto.MemberDto;
import View.ChatView;

public class Singleton {
	private static Singleton single = new Singleton();

	public MemberDto dto = null;
	public BbsController bbsCtrl = null;
	public MemberController memCtrl = null;
	public StuffController stuffCtrl = null;
	public serverController serCtrl = null;
	
	private Singleton() {
		bbsCtrl = new BbsController();
		memCtrl = new MemberController();
		stuffCtrl = new StuffController();
		serCtrl = new serverController();
	}

	public static Singleton getInstance() {
		return single;
	}
}
