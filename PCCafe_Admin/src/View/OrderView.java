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

public class OrderView extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JButton logoutBtn;
	private JTable jTable;
	private JScrollPane jScrPane;
	private JButton writeBtn;

	private JComboBox<String> choiceList;

	private JTextField selectField;

	String columnNames[] = { "번호", "상품명", "상품수량", "상품금액", "총상품금액" };

	Object rowData[][] = { { "1", "신라면", "10개", "4000", "4000" } };

	DefaultTableModel model;

	public OrderView() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String cur = System.getProperty("user.dir");
		System.out.println("cur:" + cur);
		contentPane.setLayout(null);

		JLabel loginLabel = new JLabel("주문확인");
		loginLabel.setBounds(10, 10, 120, 15);
		getContentPane().add(loginLabel);

		model = new DefaultTableModel(columnNames, 0);

		model.setDataVector(rowData, columnNames);

		jTable = new JTable(model) {
			//테이블 text 수정방지
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jTable.addMouseListener(this);

		jTable.getColumnModel().getColumn(0).setMaxWidth(700);
		jTable.getColumnModel().getColumn(1).setMaxWidth(700);
		jTable.getColumnModel().getColumn(2).setMaxWidth(700);
		jTable.getColumnModel().getColumn(3).setMaxWidth(700);
		jTable.getColumnModel().getColumn(4).setMaxWidth(700);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(0, 33, 1902, 708);
		getContentPane().add(jScrPane);

		writeBtn = new JButton("상세보기");
		writeBtn.setBounds(10, 832, 387, 136);
		writeBtn.addActionListener(this);
		getContentPane().add(writeBtn);

		// 검색
		selectField = new JTextField();
		selectField.setBounds(698, 850, 489, 100);
		getContentPane().add(selectField);

		getContentPane().setBackground(Color.GRAY);

		JButton btnNewButton = new JButton("검색");
		btnNewButton.setBounds(1188, 850, 186, 100);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.setBounds(1515, 832, 387, 136);
		contentPane.add(btnNewButton_1);
		setVisible(true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);// 전체
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

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == writeBtn) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					OrderListView frame = new OrderListView();
					dispose(); // 현재 창을 닫음
					frame.setVisible(true);
				}

			});
		}
	}
}
