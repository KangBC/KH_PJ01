package Singleton;

import Controller.BbsController;
import Controller.MemberController;
import Controller.StuffController;
import Controller.serverController;
import Dto.MemberDto;

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
