package Singleton;

import Controller.BbsController;
import Controller.MemberController;
import Controller.serverController;
import Dto.MemberDto;
import View.ChatView;

public class Singleton {
	private static Singleton single = new Singleton();

	public MemberDto dto = null;
	public BbsController bbsCtrl = null;
	public MemberController memCtrl = null;
	public serverController serCtrl = null;

	private Singleton() {
		bbsCtrl = new BbsController();
		memCtrl = new MemberController();
		serCtrl = new serverController();
	}

	public static Singleton getInstance() {
		return single;
	}
}
