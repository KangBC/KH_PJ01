package Controller;

import java.awt.EventQueue;

import View.ManageMemView;

public class MemberController {

	// ControlView

	// 회원정보view
	public void manager() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMemView frame = new ManageMemView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.dispose();
	}

	
	
	
	
	
	private void dispose() {
		
	}
}
