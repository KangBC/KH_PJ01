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

	String columnNames[] = { "번호", "상품명", "현재수량", "전체수량", "남은수량" };

	Object rowData[][] = { { "1", "신라면", "10", "40", "30" } };

	DefaultTableModel model;

	public OrderView() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1522, 480);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		String cur = System.getProperty("user.dir");
		System.out.println("cur:" + cur);
		contentPane.setLayout(null);

		JLabel loginLabel = new JLabel("재고관리");
		loginLabel.setBounds(10, 10, 120, 15);
		getContentPane().add(loginLabel);

		model = new DefaultTableModel(columnNames, 0);

		model.setDataVector(rowData, columnNames);

		jTable = new JTable(model) {
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
		jScrPane.setBounds(10, 50, 600, 300);
		getContentPane().add(jScrPane);

		writeBtn = new JButton("수정");
		writeBtn.setBounds(10, 380, 100, 20);
		writeBtn.addActionListener(this);
		getContentPane().add(writeBtn);

		// 검색
		selectField = new JTextField();
		selectField.setBounds(250, 380, 150, 20);
		getContentPane().add(selectField);

		getContentPane().setBackground(Color.GRAY);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.setBounds(416, 377, 105, 27);
		contentPane.add(btnNewButton);
		setVisible(true);
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
