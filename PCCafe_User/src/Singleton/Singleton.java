package Singleton;

import Controller.BbsController;
import Controller.MemberController;
import Dto.MemberDto;

public class Singleton {
	private static Singleton single = new Singleton();
	
	public MemberDto dto = null;
	public BbsController bbsCtrl = null;
	public MemberController memCtrl = null;
	
	private Singleton() {
		bbsCtrl = new BbsController();
		memCtrl = new MemberController();
	}
	
	public static Singleton getInstance() {
		return single;
	}
}
