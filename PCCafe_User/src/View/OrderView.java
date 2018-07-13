package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;



public class OrderView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	


	public OrderView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("과자류");
		btnNewButton.setBounds(0, 6, 97, 47);
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("식사류");
		btnNewButton_1.setBounds(96, 6, 97, 47);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("간식류");
		btnNewButton_2.setBounds(195, 6, 97, 47);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("음료류");
		btnNewButton_3.setBounds(293, 6, 97, 47);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("인기 메뉴");
		btnNewButton_4.setBounds(392, 6, 92, 47);
		panel.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(332, 80, 152, 26);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1);
		
		JLabel orderListLabel = new JLabel("주문 내역");
		panel_1.add(orderListLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(332, 107, 152, 26);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel nameLabel = new JLabel("상품");
		panel_2.add(nameLabel);
		
		JLabel priceLabel = new JLabel("가격");
		panel_2.add(priceLabel);
		
		JLabel totalPriceLabel = new JLabel("총 금액");
		panel_2.add(totalPriceLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(332, 133, 152, 104);
		panel.add(textArea);
		
		JButton oderBtn = new JButton("주문하기");
		oderBtn.setBounds(335, 239, 149, 29);
		panel.add(oderBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 80, 303, 175);
		panel.add(scrollPane);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderView frame = new OrderView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
