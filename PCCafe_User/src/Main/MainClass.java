package Main;

import Singleton.Singleton;
import View.LoginView;

public class MainClass {

	public static void main(String[] args) {
		
		Singleton sgt = Singleton.getInstance();
		sgt.memCtrl.draw_login();
	}

}
