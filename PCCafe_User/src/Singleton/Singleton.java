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
<<<<<<< HEAD
	public StuffController stuffCtrl = null;
	
	private Singleton() {
		bbsCtrl = new BbsController();
		memCtrl = new MemberController();
		stuffCtrl = new StuffController();
=======
	public serverController serCtrl = null;

	private Singleton() {
		bbsCtrl = new BbsController();
		memCtrl = new MemberController();
		serCtrl = new serverController();
>>>>>>> 86ecf272e9df3e0a48e23b0a6bc47e042d5b7b1f
	}

	public static Singleton getInstance() {
		return single;
	}
}
