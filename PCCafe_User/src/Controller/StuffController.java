package Controller;

import View.OrderView;

public class StuffController {
	private OrderView orderView = null;	
	
	public void draw_orderView() {
		if(orderView == null) {
			orderView = new OrderView();
		}else {
			orderView.dispose();
			orderView = new OrderView();
		}
	}
}
