package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ManageMemView extends JFrame implements ActionListener, MouseListener {

	// 작업해야합니다. ******************
	
	private JPanel contentPane;
	private JButton logoutBtn,btnNewButton;
	private JTable jTable;
	private JScrollPane jScrPane;
	private JButton writeBtn;

	private JComboBox<String> choiceList;

	private JTextField selectField;
	private JButton selectBtn;

	String columnNames[] = { "번호", "상품명", "개수", "총금액" };

	Object rowData[][] = { { "1", "진라면", "1개", "2000" }};

	DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public ManageMemView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String cur = System.getProperty("user.dir");
		System.out.println("cur:" + cur);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel loginLabel = new JLabel("고객아이디:");
		loginLabel.setBounds(90, 19, 81, 15);
		getContentPane().add(loginLabel);

		model = new DefaultTableModel(columnNames, 0);

		model.setDataVector(rowData, columnNames);

		jTable = new JTable(model);

		jTable.getColumnModel().getColumn(0).setMaxWidth(50);
		jTable.getColumnModel().getColumn(1).setMaxWidth(500);
		jTable.getColumnModel().getColumn(2).setMaxWidth(200);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(14, 55, 600, 181);
		getContentPane().add(jScrPane);


		getContentPane().setBackground(Color.GRAY);
		
		btnNewButton = new JButton("완료");
		btnNewButton.setBounds(503, 394, 105, 27);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(184, 14, 258, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 263, 296, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 299, 296, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 335, 296, 24);
		contentPane.add(textField_3);
		
		JLabel label = new JLabel("총 상품금액");
		label.setBounds(53, 268, 92, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("지불할 금액");
		label_1.setBounds(53, 302, 92, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("거실름돈");
		label_2.setBounds(75, 341, 70, 15);
		contentPane.add(label_2);
		setBounds(100, 100, 640, 480);
		setVisible(true);
		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnNewButton) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
						ControlView frame = new ControlView();
						frame.setVisible(true);
				}
			});
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// int row = jTable.getSelectedRow();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
