package View;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Singleton.Singleton;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class orderCheckView extends JFrame {
	private Singleton single = Singleton.getInstance();
	private JTextArea contentArea;
	private JTextField textField;
	private JLabel lblNewLabel;

	public orderCheckView(String order, int seatNum) {

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentArea = new JTextArea();
		String temp[] = order.split("-");
		for (int i = 0; i < temp.length; i++) {
			contentArea.append(temp[i] + "\n");
		}
		contentArea.setEditable(false);
		contentArea.setLineWrap(true);

		JScrollPane scrollPane = new JScrollPane(contentArea);
		scrollPane.setBounds(14, 132, 404, 309);
		contentPane.add(scrollPane);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("주문번호 : " + (single.serCtrl.getOrderListNum() + 1));
		single.serCtrl.setOrderListNum(single.serCtrl.getOrderListNum() + 1);
		textField.setEditable(false);
		textField.setBounds(14, 76, 116, 31);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNewLabel = new JLabel();
		lblNewLabel.setText((seatNum + 1) + "PC에서 주문이 들어왔습니다.");

		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 12, 353, 52);
		contentPane.add(lblNewLabel);

		setVisible(true);
		setContentPane(contentPane);
		setBounds(1470, 0, 450, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}